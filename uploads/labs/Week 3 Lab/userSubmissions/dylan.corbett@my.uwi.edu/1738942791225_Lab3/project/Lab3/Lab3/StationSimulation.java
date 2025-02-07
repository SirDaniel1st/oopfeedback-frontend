import java.util.ArrayList;
import java.util.Random;

public class StationSimulation {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<VehicleDriver> drivers = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            int length = rand.nextInt(5) + 1;
            int breadth = rand.nextInt(5) + 1;
            int width = rand.nextInt(5) + 1;
            
            int[] validClassifications = {1, 3, 4};
            int classification = validClassifications[rand.nextInt(validClassifications.length)];
            
            vehicles.add(new Vehicle(length, breadth, width, classification));
        }
        
        String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        for (String name : names) {drivers.add(new VehicleDriver(name));}
        
        for (VehicleDriver driver : drivers) {
            do {
                Vehicle randomVehicle = vehicles.get(rand.nextInt(vehicles.size()));
                if (driver.addVehicle(randomVehicle)) {break;}
            } while (true);
            
            do {
                Vehicle randomVehicle = vehicles.get(rand.nextInt(vehicles.size()));
                if (driver.addVehicle(randomVehicle)) {break;}
            } while (true);
            
            System.out.println(driver);
            System.out.println();
        }
    }
}