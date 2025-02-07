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
                
                boolean filled=fs.dispense(v.getFuelType(),v.getTankCapacity());
                System.out.println("Filled up: " +filled);
                System.out.println(fs);
                
                
                //System.out.println(carData);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public static Vehicle createVehicle(String[] dimensions){
        int l=Integer.parseInt(dimensions[0]);
        int w=Integer.parseInt(dimensions[1]);
        int b=Integer.parseInt(dimensions[2]);
        Vehicle v=new Vehicle(l,w,b);
        return v;
    }
}