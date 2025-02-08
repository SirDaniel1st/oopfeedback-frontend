import type { Metadata } from "next";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";
import { Button } from "@/components/ui/button"
import Link from 'next/link';
import HeaderAuth from "@/components/header-auth";
import { EnvVarWarning } from "@/components/env-var-warning";
import { hasEnvVars } from "@/utils/supabase/check-env-vars";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export const metadata: Metadata = {
  title: "OOP 1 Lab Feedback Generator",
  description: "Give a class feedback automatically,  Developed by Daniel Rasheed",
};

export default function Layout({ children }: { children: React.ReactNode }) {
  return (
  <html lang="en" className={geistSans.className} suppressHydrationWarning>
      <body className="bg-background text-foreground h-full">
          <main className="flex flex-col items-center flex-grow">
            <div className="flex-1 w-full flex flex-col gap-20 items-center overflow-auto">
              <nav className="w-full flex justify-center border-b border-b-foreground/10 h-16">
                <div className="w-full max-w-5xl flex justify-between items-center p-3 px-5 text-sm">
                  <div className="flex gap-5 items-center font-semibold text-l">
                  <Link href="/" className="text-2xl font-bold">
  OOP 1 Labs Feedback
</Link>
                    <div className="flex items-center gap-2">
                    </div>
                  </div>
                  {!hasEnvVars ? <EnvVarWarning /> : <HeaderAuth />}
                </div>
              </nav>
              <div>
                {children}
              </div>

              <footer className="w-full border-t text-center py-4 mt-auto ">
                <p className ="text-xs text-gray-700">
                © {new Date().getFullYear()} Daniel Rasheed. All rights reserved.
                </p>
              </footer>
            </div>
          </main>
      </body>
    </html>
  )
}
