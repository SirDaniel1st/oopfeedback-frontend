import { NextResponse } from 'next/server';
import { writeFile, mkdir } from 'fs/promises';
import { join } from 'path';
import * as fs from 'fs';
import * as unzipper from 'unzipper'
import { supabase } from '@/lib/supabase';

export async function POST(request: Request) {
  try {
    const formData = await request.formData();
    const labName = formData.get('labName') as string;
    const testFiles = formData.get('testFiles') as File;

    if (!labName || !testFiles) {
      return NextResponse.json({ error: 'Missing required fields' }, { status: 400 });
    }

    // Create lab directory
    const labBasePath = join(process.cwd(), 'uploads', 'labs', labName);
    const testFilesZipPath = join(labBasePath, 'testfiles.zip');
    const testFilesDir = join(labBasePath, 'testfiles');
    const userSubmissionsDir = join(labBasePath, 'userSubmissions');

    await mkdir(labBasePath, { recursive: true });
    await mkdir(testFilesDir, { recursive: true });
    await mkdir(userSubmissionsDir, { recursive: true });

    const arrayBuffer = await testFiles.arrayBuffer();
    const buffer = new Uint8Array(arrayBuffer);
    await writeFile(testFilesZipPath, buffer);

    // Extract test files
    await new Promise((resolve, reject) => {
      fs.createReadStream(testFilesZipPath)
        .pipe(unzipper.Extract({ path: testFilesDir }))
        .on('close', resolve)
        .on('error', reject);
    });

    // **Create a Supabase Table for the Lab**
    const { error } = await supabase.rpc('create_lab_table', { lab_name: labName });
    if (error) {
      console.error('Error creating lab table:', error);
      return NextResponse.json({ error: 'Failed to create lab table' }, { status: 500 });
    }

    return NextResponse.json({ success: true });
  } catch (error) {
    console.error('Error creating lab:', error);
    return NextResponse.json({ error: 'Failed to create lab' }, { status: 500 });
  }
}
