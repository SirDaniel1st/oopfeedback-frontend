import { NextResponse } from 'next/server';
import { readdir, stat, mkdir } from 'fs/promises';
import { join } from 'path';
import { createClient } from "@/utils/supabase/server"; // Supabase auth

export async function GET(request: Request) {
  try {
    // Initialize Supabase client
    const supabase = await createClient();

    // Authenticate user
    const { data: { user }, error: authError } = await supabase.auth.getUser();

    if (authError || !user) {
      console.error("Unauthorized request:", authError);
      return NextResponse.json({ error: 'Unauthorized' }, { status: 401 });
    }

    // Define the labs directory
    const labsDir = join(process.cwd(), 'uploads', 'labs');

    // Create the directory if it does not exist
    try {
      await stat(labsDir);
    } catch {
      console.warn("Labs directory does not exist, creating...");
      await mkdir(labsDir, { recursive: true });
      return NextResponse.json([]); // Return an empty array if no labs exist
    }

    // Read lab directories
    const labs = await readdir(labsDir);

    // Get metadata for each lab
    const labsWithMetadata = await Promise.all(
      labs.map(async (labName) => {
        const labPath = join(labsDir, labName);
        const stats = await stat(labPath);
        
        return {
          id: labName,
          name: labName,
          createdAt: stats.birthtime.toISOString(),
        };
      })
    );

    return NextResponse.json(labsWithMetadata);
  } catch (error) {
    console.error('Error fetching labs:', error);
    return NextResponse.json({ error: 'Failed to fetch labs' }, { status: 500 });
  }
}
