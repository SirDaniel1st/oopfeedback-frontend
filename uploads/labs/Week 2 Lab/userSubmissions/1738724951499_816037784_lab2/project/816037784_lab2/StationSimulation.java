import java.util.Scanner;
import java.io.File;

public class StationSimulation{
    
    public static void main(String[]args){
        
        //lets learn how to instance a class or an object
        FuelStation fStation = new FuelStation();
        System.out.println(fStation); //can also call System.out.println(fStation.toString()) as they mean the same
        
        //try catch block
        try{
            //try some block of code
            File dataFile = new File("vehicles.txt");
            Scanner fileScanner = new Scanner (dataFile);
            String carData="";
            
            while(fileScanner.hasNextLine()){
                carData=fileScanner.nextLine();
                System.out.println(carData);
                
                String[] splitData = carData.split(",");
                Vehicle v =createVehicle(carData.split(","));
            }
        }//anticipatinf that there will be some errors or exeptions or invlaid arguments. If there is some error we want to catch and print it for us
        catch(Exception e){
            System.out.println(e.toString());
        }
    
    }
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(
        "filled up: " +f.dispense(v.getFuelType(), v.getTankCapacity())
        );
        System.out.println(f);
    }
    public static Vehicle createVehicle(String[] dimensions){
        int l = Integer.parseInt(dimensions[0]);
        int b = Integer.parseInt(dimensions[1]);
        int w = Integer.parseInt(dimensions[2]);
        
        Vehicle v = new Vehicle(l,w,b);
        return v;
    }
    
}