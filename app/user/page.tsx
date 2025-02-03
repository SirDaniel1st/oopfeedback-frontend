import { createClient } from "@/utils/supabase/server";
import { InfoIcon } from "lucide-react";
import { redirect } from "next/navigation";

export default async function Home(){
    const supabase = await createClient();
    const {
        data: { user },
      } = await supabase.auth.getUser();
    
      if (!user) {
        return redirect("/sign-in");

      }
      return(
        <div className="min-h-screen bg-background">
            <main className="container py-6">
                <div className="flex flex-col gap-4">
                    <h1 className="text-3xl font-bold">Welcome {user.user_metadata.first_name} to the OOP 1 Lab FeedbackDashboard</h1>
                </div>
            </main>
        </div>
      )

}   