import java.util.Scanner;
import java.io.File;


public class StationSimulation{
    public static void main(String[] args){
      FuelStation fs = new FuelStation();
     
      //it is understood that if you are calling an object you are calling its toString method
      System.out.println(fs);
      
      //try catch block 
        try{
            //trying some block of code
            
            //FILES (read data from the vehocles.txt file using try/catch blocks
            File dataFile = new File("vehicles.txt");
            Scanner fileScanner = new Scanner(dataFile);
            String carData = "";
            
            while(fileScanner.hasNextLine()){
                carData = fileScanner.nextLine();
                System.out.println(carData);
                
                String[] splitData = carData.split(","/*delimiter*/);
                Vehicle v = createVehicle(splitData);
                serviceVehicle(v, fs);
            }
        } //errors? exceptions? invalid arguments? if there exists an error we want to catch it and print it
        catch(Exception e){
            System.out.println(e.toString());
        }
    }   
    
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(
        "filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity())
        );
        System.out.println(f);
    }
    public static Vehicle createVehicle(String[] dimensions){
        int length = Integer.parseInt(dimensions[0]);
        int breadth = Integer.parseInt(dimensions[1]);
        int width = Integer.parseInt(dimensions[2]);
        
        Vehicle v = new Vehicle(length, breadth, width);
        return v;
    }
    
}
