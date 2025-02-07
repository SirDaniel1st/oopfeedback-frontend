import java.util.Scanner;
import java.io.File;

public class StationSimulation {
    public static void main(String[] args) {
        // Create an instance of FuelStation
        //ClassName InstanceName =  new Class Constructor();
        FuelStation station = new FuelStation();
        // print the result with the toString() 
        System.out.println(station.toString());//System.out.println(station)
        
        //try catch block
        try{
            //Try code,anticipating that there will be some errors or exceptions 
            //or invalid arguments as we dont have complete contol over the input.
            //If there is an error we want to catch and print it
            
            //Reading file
            File dataFile = new File("vehicles.txt");
            //if file was in a folder: File dataFile = new File("/folder/vehicles.txt");
            Scanner fileScanner = new Scanner(dataFile);
            String carData="";
            while(fileScanner.hasNextLine()){
                carData= fileScanner.nextLine();
                System.out.println(carData);
                
                String[]splitData =carData.split(",");
                //system.out.println(splitdata[0])
                
                Vehicle v = createVehicle(splitData);
                serviceVehicle(v,station);
                //split the car data into 3 interges
            }
            
        }
        catch(Exception e){
        System.out.println(e.toString());
        }
    }
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println("Filled up:"+ f.dispense(v.getFuelType(), v.getTankCapasity()));
        System.out.println(f);
    }
    public static Vehicle createVehicle(String[] dimensions){
        int l =Integer.parseInt(dimensions[0]);
        int b =Integer.parseInt(dimensions[1]);
        int w =Integer.parseInt(dimensions[2]);
        
        Vehicle v = new Vehicle(l,b,w);
        return v;
        
    }
}