"use client";

import { useState } from "react";
import { useParams } from "next/navigation"; // ✅ Use useParams() instead of params prop
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import * as z from "zod";
import { Button } from "@/components/ui/button";
import { FileUpload } from "./FileUpload";
import { Form, FormControl, FormField, FormItem, FormLabel, FormMessage } from "@/components/ui/form";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { toast } from "sonner";
import { Upload, Download } from "lucide-react";

// Define validation schema
const formSchema = z.object({
  projectZip: z
    .any()
    .refine(
      (files) =>
        typeof window !== "undefined" &&
        files instanceof FileList &&
        files.length === 1,
      "Please select exactly one ZIP file"
    )
    .refine(
      (files) =>
        typeof window !== "undefined" &&
        files[0]?.name.toLowerCase().endsWith(".zip"),
      "File must be a ZIP archive"
    )
    .refine(
      (files) => typeof window !== "undefined" && files[0]?.size <= 5 * 1024 * 1024,
      "File size must not exceed 5 MB"
    ),
});


type FormValues = z.infer<typeof formSchema>;

export default function LabPage() {
  const params = useParams(); // ✅ Correct way to get dynamic route parameters
  const labId = params.id as string; // Ensure it's a string
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [feedback, setFeedback] = useState<string | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [pdfUrl, setPdfUrl] = useState<string | null>(null);

  const form = useForm<FormValues>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      projectZip: undefined,
    },
  });

  async function onSubmit(data: FormValues) {
    if (!data.projectZip?.[0]) return;

    try {
      setIsSubmitting(true);
      setError(null);
      setFeedback(null);
      setPdfUrl(null);

      const formData = new FormData();
      formData.append("projectZip", data.projectZip[0]);

      const response = await fetch(`/api/labs/${labId}/submit`, {
        method: "POST",
        body: formData,
      });

      const result = await response.json();

      if (!response.ok) {
        throw new Error(result.error || "Failed to submit project");
      }

      setFeedback(result.feedback);
      setPdfUrl(result.pdfUrl);
      toast.success("Project submitted successfully");
      form.reset();
    } catch (err: any) {
      setError(err.message || "Failed to submit project");
      toast.error(err.message || "Failed to submit project");
    } finally {
      setIsSubmitting(false);
    }
  }

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader>
          <CardTitle>Submit Project</CardTitle>
          <CardDescription>Upload your project zip file to get feedback.</CardDescription>
        </CardHeader>
        <CardContent>
          <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
              <FormField
                control={form.control}
                name="projectZip"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Project ZIP</FormLabel>
                    <FormControl>
                      <FileUpload accept=".zip" onChange={(files) => field.onChange(files)} />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />

              <Button type="submit" disabled={isSubmitting}>
                <Upload className="mr-2 h-4 w-4" />
                {isSubmitting ? "Submitting..." : "Get Feedback"}
              </Button>
            </form>
          </Form>
        </CardContent>
      </Card>

      {error && (
        <Card className="border-destructive">
          <CardHeader>
            <CardTitle>Error</CardTitle>
          </CardHeader>
          <CardContent>
            <pre className="bg-muted p-4 rounded-lg whitespace-pre-wrap text-sm">{error}</pre>
          </CardContent>
        </Card>
      )}

      {feedback && (
        <Card>
          <CardHeader>
            <CardTitle>Feedback</CardTitle>
          </CardHeader>
          <CardContent className="space-y-4">
            <pre className="bg-muted p-4 rounded-lg whitespace-pre-wrap text-sm">{feedback}</pre>
            {pdfUrl && (
              <div className="space-y-4">
                <iframe src={pdfUrl} className="w-full h-[600px] rounded-lg border" title="Feedback PDF" />
                <Button 
  variant="outline" 
  onClick={() => window.open(pdfUrl)} 
  className="w-full bg-black text-white border-black hover:bg-gray-900"
>
  <Download className="mr-2 h-4 w-4 text-white" />
  Open PDF in New Tab
</Button>

              </div>
            )}
          </CardContent>
        </Card>
      )}
    </div>
  );
}
