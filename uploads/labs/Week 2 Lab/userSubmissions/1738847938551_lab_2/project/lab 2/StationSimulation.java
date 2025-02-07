import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StationSimulation {
    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();
        System.out.println(fuelStation.toString());
        Random generator = new Random();
        String[] fuelTypes = {"petroleum", "gasoline", "diesel"};
        for (int i = 0; i < 5; i++) {
            String fuelType = fuelTypes[generator.nextInt(3)];
            double fuelVolume = generator.nextDouble() * 50000;
            if (fuelStation.dispense(fuelType, fuelVolume)) {
                System.out.println("Fuel of this type can be dispensed: " + fuelType);
                fuelStation.sellFuel(fuelVolume);
            } else {
                System.out.println("Fuel of this type cannot be dispensed: " + fuelType);
            }
            System.out.println(fuelStation + "\n");
        }

        try {
            File veh = new File("C:\\Users\\student\\Documents\\comp 2603\\vehicles.txt");
            Scanner myReader = new Scanner(veh);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] numbers = line.split(","); // Split the line by commas
                if (numbers.length == 3) {
                    try {
                        int length = Integer.parseInt(numbers[0].trim());
                        int width = Integer.parseInt(numbers[1].trim());
                        int breadth = Integer.parseInt(numbers[2].trim());
                        Vehicle vehicle = new Vehicle(length, width, breadth);
                        System.out.println(vehicle);

                        // Fill up the tank
                        if (vehicle.getFuelType().equals("diesel")) {
                            System.out.println("Filled up: false");
                        } else {
                            fuelStation.sellFuel(vehicle.getTankCapacity());
                            System.out.println("Filled up: true");
                        }
                        System.out.println(fuelStation + "\n");
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid number: " + line);
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
}