import java.util.Scanner;
import java.io.File;

public class StationSimulation {
  public static void main(String[] args) {
    FuelStation unipetFuel = new FuelStation();
    double fuelVolume;
    String fuelType;
    System.out.println(unipetFuel.toString() + "\n");

    /*
    System.out.printf("Enter a fuel type to test canDispenseFuelType(): ");
    Scanner in = new Scanner(System.in);
    fuelType = in.nextLine();

    //Testing canDispenseFuelType()
    if (unipetFuel.canDispenseFuelType(fuelType)) System.out.println(fuelType + " can be dispensed.");
    else System.out.println(fuelType + " cannot be dispensed.");
    
    //Testing dispense and sellFuel()
    System.out.println("\nEnter a fuel type and fuel volume to test dispense()");
    System.out.printf("Fuel Type: ");
    fuelType = in.nextLine();
    System.out.printf("Fuel Volume: ");
    fuelVolume = in.nextDouble();
    
    if (unipetFuel.dispense(fuelType, fuelVolume)) System.out.printf("\n%.02f L of %s was successfully dispensed.\n", fuelVolume, fuelType);
    else System.out.printf("\n%.02f L of %s could not be dispensed.\n", fuelVolume, fuelType);
    */

    try {
      File myFile = new File("vehicles.txt");
      Scanner fileReader = new Scanner(myFile);
      String carData="";

      while (fileReader.hasNextLine()) {
        carData = fileReader.nextLine();
        //System.out.println(carData);
        Vehicle vehicle = createVehicle(carData.split(","));
        //System.out.println(vehicle.toString());
        serviceVehicle(vehicle, unipetFuel);
      }

      fileReader.close();
    }
    catch (Exception e) {
      System.out.println(e.toString());
    }
  }
  
  public static Vehicle createVehicle(String[] dimensions) {
    int length = Integer.parseInt(dimensions[0]);
    int width = Integer.parseInt(dimensions[1]);
    int breadth = Integer.parseInt(dimensions[2]);
    Vehicle vehicle = new Vehicle(length, width, breadth);
    return vehicle;
  }
  
  public static void serviceVehicle(Vehicle v, FuelStation f) {
    System.out.println(v.toString());
    System.out.println("Filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity()));
    System.out.println(f.toString() + "\n");
  }
}