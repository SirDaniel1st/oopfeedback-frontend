import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StationSimulation {
    public static void main(String[] args) {
        
        FuelStation station = new FuelStation();
        //className VariableName = new classConstructor ()
        System.out.println(station.toString()); 

        try {
            //a try catch block tries code and then catches an error
            File file = new File("vehicles.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Raw Data: " + line); 

                
                String[] dimensions = line.split(",");
                int length = Integer.parseInt(dimensions[0]);
                int width = Integer.parseInt(dimensions[1]);
                int breadth = Integer.parseInt(dimensions[2]);

                Vehicle vehicle = new Vehicle(length, width, breadth);
                System.out.println(vehicle.toString()); 

                
                boolean filledUp = false;
                if (vehicle.getFuelType().equals("gasoline")) {
                    filledUp = station.dispense(vehicle.getFuelType(), vehicle.getTankCapacity());
                }

                System.out.println("Filled up: " + filledUp);
                System.out.println(station.toString()); // Print updated station details
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
