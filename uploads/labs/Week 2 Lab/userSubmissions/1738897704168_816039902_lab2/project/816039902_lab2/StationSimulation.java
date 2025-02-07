import java.util.Scanner;
import java.io.File;

public class StationSimulation {
    public static void main(String[] args) {
        FuelStation station = new FuelStation();
        System.out.println(station);

        try {
            File dataFile = new File("vehicles.txt");
            Scanner dataScanner = new Scanner (dataFile);
            String carData = "";
            
            while (dataScanner.hasNextLine()) {
                carData = dataScanner.nextLine();
                System.out.println(carData);
                Vehicle v = createVehicle(carData.split(","));
                
                serviceVehicle (v, station);
            }
        } 
        
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static void serviceVehicle (Vehicle v, FuelStation f) {
        System.out.println(v);
        System.out.println( 
        "Filled up: " + f.dispense (v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
    }
    
    public static Vehicle createVehicle(String[] dimensions) {
        int length = Integer.parseInt(dimensions[0]);
        int width = Integer.parseInt(dimensions[1]);
        int breadth = Integer.parseInt(dimensions[2]);
        
        Vehicle v = new Vehicle (length, width, breadth);
        return v;
    }
}

