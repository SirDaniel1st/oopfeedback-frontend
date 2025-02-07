import java.util.ArrayList;

public class StationSimulation {
    // Constructor
    public StationSimulation() {
        
    }
    
    
    public static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
    
    
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
        
        String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        
        for (int x = 0; x < 5; x++) {
            drivers.add(new VehicleDriver(names[x]));
        }
        
        for (int x = 0; x < 10; x++) {
            vehicles.add(new Vehicle(getRandomNumber(1,20),
                                    getRandomNumber(1, 5),
                                    getRandomNumber(1, 5),
                                    getRandomNumber(1, 5)));
        }
        
        for (VehicleDriver driver : drivers) {
            int index = StationSimulation.getRandomNumber(0, 10);
            Vehicle v = vehicles.get(index);
            driver.addVehicle(v);
            do {
                v = vehicles.get(StationSimulation.getRandomNumber(0, 10));
            } while(!driver.addVehicle(v));
        }
        
        for (VehicleDriver driver : drivers) {
            System.out.println(driver.toString());
        }
    }
}