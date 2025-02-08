import { NextResponse } from 'next/server';
import { createClient } from "@/utils/supabase/server";
import { join } from 'path';
import * as fs from 'fs/promises';
import * as fsSync from 'fs'; // Use synchronous methods for path checking

export async function GET(
  request: Request,
  context: { params: Promise<{ id: string }> } // ✅ `params` is a Promise
) {
  try {
    const supabase = await createClient();
    const userIp = request.headers.get('x-forwarded-for') || 'unknown';

    // Authenticate user
    const { data: { user }, error: authError } = await supabase.auth.getUser();
    
    // 🛑 Ensure user exists and has an email
    if (authError || !user || !user.email) {
      console.error("Unauthorized access attempt.");
      return NextResponse.json({ error: 'Unauthorized: No valid user email' }, { status: 401 });
    }

    const { id } = await context.params; // ✅ Await `params` before using
    console.log("🟢 Received lab ID:", id);

    // Define the base directory for user submissions
    const userSubmissionsDir = join(
      process.cwd(),
      'uploads',
      'labs',
      id, // ✅ Use awaited `id`
      'userSubmissions'
    );

    const userEmail = user.email;
    const userFolder = userEmail.replace(/[^a-zA-Z0-9@._-]/g, '_'); // Sanitize email
    const userSubmissionsPath = join(userSubmissionsDir, userFolder);

    if (!fsSync.existsSync(userSubmissionsPath)) {
      console.error(`No submissions found for user: ${userEmail}`);
      return NextResponse.json({ error: 'No feedback available' }, { status: 404 });
    }

    // Get all submissions for this user
    const userSubmissions = await fs.readdir(userSubmissionsPath);

    if (userSubmissions.length === 0) {
      console.error(`No submissions found in: ${userSubmissionsPath}`);
      return NextResponse.json({ error: 'No submissions found' }, { status: 404 });
    }

    // Find the latest submission **for this user only**
    const latestSubmission = userSubmissions
      .filter((sub) => fsSync.statSync(join(userSubmissionsPath, sub)).isDirectory())
      .sort()
      .pop();

    if (!latestSubmission) {
      console.error(`No valid submission found for user: ${userEmail}`);
      return NextResponse.json({ error: 'No feedback found' }, { status: 404 });
    }

    // Define the project folder path inside the latest submission
    const projectFolder = join(userSubmissionsPath, latestSubmission, 'project');

    // Ensure the project folder exists
    if (!fsSync.existsSync(projectFolder)) {
      console.error(`Project folder does not exist: ${projectFolder}`);
      return NextResponse.json({ error: 'Project folder not found' }, { status: 404 });
    }

    // Recursively search for the feedback PDF
    const findPdfFile = async (dir: string): Promise<string | null> => {
      const files = await fs.readdir(dir, { withFileTypes: true });

      for (const file of files) {
        const filePath = join(dir, file.name);
        if (file.isDirectory()) {
          const nestedPdf = await findPdfFile(filePath);
          if (nestedPdf) return nestedPdf;
        } else if (file.name.toLowerCase().endsWith('.pdf')) {
          return filePath;
        }
      }

      return null;
    };

    const pdfPath = await findPdfFile(projectFolder);

    if (!pdfPath) {
      console.error(`No PDF file found in: ${projectFolder}`);
      return NextResponse.json({ error: 'Feedback PDF not found' }, { status: 404 });
    }

    console.log(`Serving feedback PDF from: ${pdfPath}`);

    // Read and serve the PDF file
    const pdfBuffer = await fs.readFile(pdfPath);

    return new NextResponse(pdfBuffer, {
      headers: {
        'Content-Type': 'application/pdf',
        'Content-Disposition': `inline; filename="${pdfPath.split('/').pop()}"`,
      },
    });

  } catch (error) {
    console.error('Error serving feedback PDF:', error);

    if (error instanceof Error) {
      return NextResponse.json({ error: 'Failed to serve feedback PDF', details: error.message }, { status: 500 });
    }

    return NextResponse.json({ error: 'Failed to serve feedback PDF', details: String(error) }, { status: 500 });
  }
}
