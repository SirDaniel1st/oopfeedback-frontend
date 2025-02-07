//Modify your code block from Step 6 in the StationSimulation class to create Vehicle
//objects for each line of data. The three values on each line represent the length, width,
//breadth of a Vehicle’s fuel tank. You will need to parse and extract the values from the
//line (Tip: Use StringTokenizer or a String’s split(..) method) .Test your code works by
//printing out the details of each Vehicle object (using the toString( ) ).

import java.io.File;
import java.util.Scanner;

public class StationSimulation{
    public static void main(String args[]){
        FuelStation fStation = new FuelStation();
        
        System.out.println(fStation.toString());
        
        try{
            File dataFile = new File("vehicles.txt");
            Scanner sc = new Scanner(dataFile);
            String carData = "";
            FuelStation fs = new FuelStation();
            
            while(sc.hasNextLine()){
                carData = sc.nextLine();
                
                Vehicle v = createVehicle(carData.split(","));
                serviceVehicle(v, fs);
                System.out.println("");
                
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
        
        Vehicle v = new Vehicle(l, b, w);
        return v;
    }
    
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(
        "Filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
    }
}
    