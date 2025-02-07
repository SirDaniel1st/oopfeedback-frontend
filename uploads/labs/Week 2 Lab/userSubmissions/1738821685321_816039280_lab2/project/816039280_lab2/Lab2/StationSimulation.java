import java.util.Random;
import java.util.Scanner;
import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class StationSimulation
{
    public static void main(String[] args){
        FuelStation station = new FuelStation();
        
        
        try{
            File datafile = new File("vehicles.txt");
            Scanner filescanner = new Scanner(datafile);
            String carData="";//initialising line for data on Vehicles
            
            while(filescanner.hasNextLine()){
                carData = filescanner.nextLine();
                String[] splitData = carData.split(",");
                Vehicle vehicle = createVehicle(splitData);
                serviceVehicle(vehicle, station);
                //System.out.println(carData);
            }
        }
        
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    } 
    
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println("Filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f.toString());
    }
    
    public static Vehicle createVehicle(String[] dimensions){
        int l = Integer.parseInt(dimensions[0]);
        int b = Integer.parseInt(dimensions[1]);
        int w = Integer.parseInt(dimensions[2]);
        Vehicle vehicle = new Vehicle(l, w, b);
        return vehicle;
    }
}
