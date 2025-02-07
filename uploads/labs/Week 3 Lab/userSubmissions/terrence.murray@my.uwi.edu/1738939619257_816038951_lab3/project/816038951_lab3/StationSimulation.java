import java.util.ArrayList;

public class StationSimulation {
    public static void main (String args[]) {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
        String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        
        for (String name : names) {
            drivers.add(new VehicleDriver(name));
        }
        
        for (int i = 0; i < 10; i++) {
            vehicles.add(new Vehicle(
                getRandomNumber(1, 10),
                getRandomNumber(1, 10),
                getRandomNumber(1, 10),
                getRandomNumber(1, 5)
            ));
        }
        
        for (VehicleDriver driver : drivers) {
            boolean isSet;
            do {
                int index = StationSimulation.getRandomNumber(0, 10);
                Vehicle v = vehicles.get(index);
                isSet = driver.addVehicle(v);
            } while (isSet);
        }
        
        // print the drivers
        for (VehicleDriver driver : drivers) {
            System.out.println(driver);
        }
    }
    
    public static int getRandomNumber (int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}