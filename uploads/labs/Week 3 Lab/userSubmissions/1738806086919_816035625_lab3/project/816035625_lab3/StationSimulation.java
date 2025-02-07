//Modify your code block from Step 6 in the StationSimulation class to create Vehicle
//objects for each line of data. The three values on each line represent the length, width,
//breadth of a Vehicle’s fuel tank. You will need to parse and extract the values from the
//line (Tip: Use StringTokenizer or a String’s split(..) method) .Test your code works by
//printing out the details of each Vehicle object (using the toString( ) ).

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class StationSimulation{
    public static void main(String args[]){
       
        ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
        String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        for(int i = 0; i<5; i++){
            drivers.add(new VehicleDriver(names[i]));
        }
        
        
        
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        for(int i = 0; i<10; i++){
            vehicles.add(new Vehicle(getRandomNumber(1,10),getRandomNumber(1,10), 
                                    getRandomNumber(1,10),getRandomNumber(1,4))); 
        }
        
        for(VehicleDriver driver: drivers){
            int index = StationSimulation.getRandomNumber(0, 10);
            Vehicle v = vehicles.get(index);
            driver.addVehicle(v);
            
            do{
                index = StationSimulation.getRandomNumber(0,10);
                v = vehicles.get(index);
            }while(driver.addVehicle(v));
            System.out.println(driver);
        }
    }
    
    public static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min) + min));
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
    