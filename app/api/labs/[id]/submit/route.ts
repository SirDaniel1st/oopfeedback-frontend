import { NextResponse } from 'next/server';
import { createClient } from "@/utils/supabase/server";
import { writeFile, mkdir, readdir, cp } from 'fs/promises';
import { join } from 'path';
import * as fs from 'fs';
import * as unzipper from 'unzipper';
import { promisify } from 'util';
import { exec } from 'child_process';

const execAsync = promisify(exec);

export async function POST(request: Request, context: { 
  params: Promise<{ id: string }> 
}) {
  try {
    const supabase = await createClient();
    const { id } = await context.params; // ✅ Await params before using
    const userIp = request.headers.get('x-forwarded-for') || 'unknown';

    // Authenticate user
    const { data: { user }, error: authError } = await supabase.auth.getUser();
    if (authError || !user) {
      return NextResponse.json({ error: 'Unauthorized' }, { status: 401 });
    }
    const userEmail = user.email;

    // Handle ZIP file upload
    const formData = await request.formData();
    const projectZip = formData.get('projectZip') as File;

    if (!projectZip) {
      return NextResponse.json({ error: 'Missing project zip file' }, { status: 400 });
    }

    const originalName = projectZip.name.replace(/\.zip$/, '');
    const labBasePath = join(process.cwd(), 'uploads', 'labs', id);
    const sanitizedZipName = originalName.replace(/[^a-zA-Z0-9_-]/g, '_');
    const userSubmissionDir = join(
      labBasePath,
      'userSubmissions',
      `${Date.now()}_${sanitizedZipName}`
    );
    const projectZipPath = join(userSubmissionDir, projectZip.name);
    const projectFilesDir = join(userSubmissionDir, 'project', originalName);

    await mkdir(userSubmissionDir, { recursive: true });

    const arrayBuffer = await projectZip.arrayBuffer();
    const buffer = new Uint8Array(arrayBuffer);
    await writeFile(projectZipPath, buffer);

    // Extract ZIP file
    console.log('Extracting ZIP...');
      await new Promise((resolve, reject) => {
        fs.createReadStream(projectZipPath)
          .pipe(unzipper.Extract({ path: projectFilesDir }))
          .on('close', resolve)
          .on('error', reject);
      });
    console.log('Files extracted to:', projectFilesDir);


    // Copy test files from `testfiles` directory
    const testFilesDir = join(labBasePath, 'testfiles');
      console.log('Copying test files from:', testFilesDir, 'to:', projectFilesDir);

      const testFiles = await readdir(testFilesDir);
      console.log('Test files:', testFiles);

      for (const file of testFiles) {
        await cp(
          join(testFilesDir, file),
          join(projectFilesDir, file),
          { recursive: true }
        );
      }
      console.log('Files in project directory after copying test files:', await readdir(projectFilesDir));

    // Define the path to iText PDF library
    const itextJarPath = join(projectFilesDir, 'itextpdf-5.5.6.jar');
    console.log('Using iText JAR path:', itextJarPath);

    // Get all Java files for compilation
    const javaFiles = (await readdir(projectFilesDir)).filter((file) => file.endsWith('.java'));
    console.log('Java files to compile:', javaFiles);

    // Compile all Java files
    const { stderr: compileError } = await execAsync(
      `javac -cp "${itextJarPath}" ${javaFiles.join(' ')}`,
      { cwd: projectFilesDir }
    );
    if (compileError) {
      console.error('Compilation error:', compileError);
      throw new Error(`Compilation error: ${compileError}`);
    }

    // Run the test runner
    const { stdout, stderr } = await execAsync(
      `java -cp "${itextJarPath}:." LabTestsRunner`,
      { cwd: projectFilesDir }
    );
    console.log('Test runner output:', stdout);
    if (stderr) {
      console.error('Test runner error (if any):', stderr);
    }

    // Dynamically find any PDF in the directory
    const filesInDir = await readdir(projectFilesDir);
    const pdfFile = filesInDir.find((file) => file.toLowerCase().endsWith('.pdf'));

    if (!pdfFile) {
      console.error('No feedback PDF found in the directory:', projectFilesDir);
      throw new Error('Feedback PDF was not generated');
    }

    const pdfPath = join(projectFilesDir, pdfFile);
    console.log('Found PDF:', pdfPath);

    // ✅ Using Supabase RPC function to insert into dynamic table
    console.log("🟢 Attempting to insert into table:", `lab_${id}`);
    
    const { data, error: insertError } = await supabase.rpc("insert_into_table", {
      table_name: `lab_${id}`, // ✅ Ensure table name is correct
      user_email: userEmail,
      user_ip: userIp,
      zip_file_name: projectZip.name,
    });

    if (insertError) {
      console.error("🔴 Supabase insert error:", JSON.stringify(insertError, null, 2));
      return NextResponse.json({ error: "Failed to track submission", details: insertError }, { status: 500 });
    }

    return NextResponse.json({
      success: true,
      feedback: stdout,
      pdfUrl: `/api/labs/${id}/feedback.pdf`,
    });

  } catch (error) {
    console.error("Error submitting project:", error);
    return NextResponse.json({ error: "Failed to submit project" }, { status: 500 });
  }
}


