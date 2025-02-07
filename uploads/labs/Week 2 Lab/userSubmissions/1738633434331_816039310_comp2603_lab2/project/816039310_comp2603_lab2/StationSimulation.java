import java.util.Scanner;
import java.io.File;

public class StationSimulation{
    public static void main (String[]args){
        FuelStation fs=new FuelStation();
        System.out.println(fs);
        
        try{
            File data=new File("vehicles.txt");
            Scanner sc=new Scanner(data);
            
            String carData="";
            while(sc.hasNextLine()){
                carData=sc.nextLine();
                String[] dim=carData.split(",");
                Vehicle v=createVehicle(dim);
                System.out.println(v);
                
                System.out.println("Filled up: " +serviceVehicle(v,fs));
                System.out.println(fs);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public static boolean serviceVehicle(Vehicle v, FuelStation fs){
         if(fs.dispense(v.getFuelType(),v.getTankCapacity()))
             return true;
         else
             return false;
    }
    public static Vehicle createVehicle(String[] dimensions){
        int l=Integer.parseInt(dimensions[0]);
        int w=Integer.parseInt(dimensions[1]);
        int b=Integer.parseInt(dimensions[2]);
        Vehicle v=new Vehicle(l,w,b);
        return v;
    }
}