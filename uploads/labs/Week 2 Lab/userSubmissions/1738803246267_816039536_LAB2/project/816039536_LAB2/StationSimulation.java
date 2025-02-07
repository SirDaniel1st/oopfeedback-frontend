import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 

public class StationSimulation{
    
    public static void main(String[] args){
        FuelStation fuelStation = new FuelStation();
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        System.out.println(fuelStation.toString());
        System.out.println("Can sell gasoline: " + 
                            fuelStation.canDispenseFuelType("gasoline"));
        System.out.println("Can sell 5L of gas: " + fuelStation.dispense("gasoline", 5));
        System.out.println("Remaining gas: " + fuelStation.getFuelVolume());
    
        try{
            File f = new File("vehicles.txt");
            Scanner fScanner = new Scanner(f);
            String carData = "";
            
            while(fScanner.hasNextLine()){
                carData = fScanner.nextLine();
                System.out.println(carData);

                String[] splitData = carData.split(",");
                Vehicle v = new Vehicle(Integer.parseInt(splitData[0]), 
                                        Integer.parseInt(splitData[1]), 
                                        Integer.parseInt(splitData[2]));
                vehicles.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        for(Vehicle v: vehicles){
            System.out.println(v);
            System.out.println("Filled up: " +
                                fuelStation.dispense(v.getFuelType(), v.getTankCapacity()));
            System.out.println(fuelStation);
        }
        
    }
}