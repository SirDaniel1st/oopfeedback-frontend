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
  const useLabID = decodeURIComponent(labId)
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
    <div className="space-y-6 pr-32 px-8">
  <h1 className="text-3xl font-bold text-gray-900">{useLabID}</h1>
  
  <Card className="shadow-lg rounded-lg">
    <CardHeader className="bg-gray-100 p-4 rounded-t-lg">
      <CardTitle className="text-2xl font-semibold">Submit Lab</CardTitle>
      <CardDescription className="text-gray-600">
        Upload your OOP Lab zip file to get feedback.
      </CardDescription>
    </CardHeader>
    <CardContent className="p-6">
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
          <FormField
            control={form.control}
            name="projectZip"
            render={({ field }) => (
              <FormItem>
                <FormLabel className="text-gray-900">Project ZIP </FormLabel>
                <p className="text-xs text-gray-700">(Remember to name your file   "studentid_labx.zip")</p>
                <p className="text-xs text-gray-700">Also remember that you shouldnt have subdirectories in your zip file</p>
                <FormControl>
                  <FileUpload
                    accept=".zip"
                    onChange={(files) => field.onChange(files)}
                    className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-back-500 focus:border-indigo-500 sm:text-sm"
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <Button
            type="submit"
            disabled={isSubmitting}
            className="w-full bg-black-600 text-white py-2 px-4 rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
          >
            <Upload className="mr-2 h-4 w-4" />
            {isSubmitting ? 'Submitting...' : 'Get Feedback'}
          </Button>
        </form>
      </Form>
    </CardContent>
  </Card>

  {error && (
    <Card className="border border-red-500">
      <CardHeader className="bg-red-100 p-4 rounded-t-lg">
        <CardTitle className="text-red-700">Error</CardTitle>
      </CardHeader>
      <CardContent className="p-6">
        <pre className="bg-red-50 p-4 rounded-lg whitespace-pre-wrap text-sm text-red-700">
          {error}
        </pre>
      </CardContent>
    </Card>
  )}

  {feedback && (
    <Card className="shadow-lg rounded-lg">
      <CardHeader className="bg-gray-100 p-4 rounded-t-lg">
        <CardTitle className="text-2xl font-semibold">Feedback</CardTitle>
      </CardHeader>
      <CardContent className="p-6 space-y-4">
        <pre className="bg-gray-50 p-4 rounded-lg whitespace-pre-wrap text-sm text-gray-800">
          {feedback}
        </pre>
        {pdfUrl && (
          <div className="space-y-4">
            <iframe
              src={pdfUrl}
              className="w-full h-96 rounded-lg border"
              title="Feedback PDF"
            />
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
