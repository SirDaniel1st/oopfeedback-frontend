import { LabsSidebar } from '@/components/labs-sidebar';

export default function UserLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <div className="min-h-screen bg-background">
      <div className="flex">
        <aside className="flex-shrink-5">
          <LabsSidebar />
        </aside>
        <main>
          {children}
        </main>
      </div>
    </div>
  );
}