import java.util.Scanner;
import java.io.File;
public class StationSimulation
{
   
    
    
    public static void main(String[]args){
       FuelStation newstation = new FuelStation();
       System.out.println(newstation);
       
       
       try{
        
        File dataFile= new File("vehicles.txt");
        Scanner fileScanner = new Scanner(dataFile);
        String carData="";
        
        while(fileScanner.hasNextLine()){
           carData = fileScanner.nextLine();
           System.out.println(carData);
           String[] splitData = carData.split(",");
           Vehicle v = createVehicle(splitData);
        }
        
        
       }
       catch(Exception e){
        System.out.println(e.toString());
       }
    
    }
   public static Vehicle createVehicle(String[] dimensions){
        int l = Integer.parseInt(dimensions[0]);
        int b = Integer.parseInt(dimensions[1]);
        int w = Integer.parseInt(dimensions[2]);
        Vehicle v = new Vehicle(l,w,b);
        return v;
    }
   public static void serviceVehicle(Vehicle v,FuelStation f){
        System.out.println(v);
        System.out.println(
        "Filled up: " + f.dispense(v.getFuelType(),v.getTankCapacity())
        );
        System.out.println(f);
    }
    

    
}
