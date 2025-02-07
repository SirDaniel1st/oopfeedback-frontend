import java.util.Random;
import java.util.ArrayList;
public class StationSimulation {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<VehicleDriver> drivers = new ArrayList<>();

        // Generate 10 vehicles
        for (int i = 1; i <= 10; i++) {
            int length = rand.nextInt(5) + 1;
            int breadth = rand.nextInt(5) + 1;
            int width = rand.nextInt(5) + 1;

            int[] classifications = {1, 3, 4}; // Valid classifications
            int classification = classifications[rand.nextInt(3)];

            Vehicle vehicle = new Vehicle(length, breadth, width, classification);
            vehicles.add(vehicle);
        }

        // Create 5 drivers with random names
        String[] driverNames = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        for (String name : driverNames) {
            drivers.add(new VehicleDriver(name));
        }

        // Assign 2 unique vehicles to each driver
        for (VehicleDriver driver : drivers) {
            int index1, index2;
            Vehicle vehicle1, vehicle2;

            do {
                index1 = rand.nextInt(vehicles.size());
                index2 = rand.nextInt(vehicles.size());
            } while (index1 == index2); // Ensure different vehicles

            vehicle1 = vehicles.get(index1);
            vehicle2 = vehicles.get(index2);

            driver.addVehicle(vehicle1);
            driver.addVehicle(vehicle2);
        }

        // Print final output (driver + vehicles)
        for (VehicleDriver driver : drivers) {
            System.out.println(driver);
        }
    }
}

