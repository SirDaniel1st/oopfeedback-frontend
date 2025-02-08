
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import Link from 'next/link';
import { Users } from 'lucide-react';



export default function Home() {
  return (
    <div className="min-h-screen bg-background">
      <main className="container py-6">
        <div className="flex flex-col gap-4">
        <h1
          style={{
            textAlign: "center",
          }}
          className="text-3xl font-bold"
        >
        Welcome to the Object-Oriented Programming 1<br/>Labs Feedback Dashboard
        </h1>
        <div className="flex items-center justify-center px-4">
          <div className="grid gap-6  bg-white p-8 rounded-2xl shadow-lg">
            <Card className="p-6">
              <CardHeader className="flex flex-col items-center">
                <Users className="h-10 w-10 mb-2 text-black-500" />
                <CardTitle className="text-xl font-semibold">User Dashboard</CardTitle>
                <CardDescription className="text-center text-gray-600">
                  View and manage your OOP1 Labs
                </CardDescription>
              </CardHeader>
              <CardContent className="flex justify-center">
                <Button asChild className="w-full bg-black hover:bg-blue-700 text-white py-2 rounded-lg">
                  <Link href="/user">Access User Dashboard</Link>
                </Button>
              </CardContent>
            </Card>
          </div>
        </div>
        </div>
      </main>
    </div>
  );
}
