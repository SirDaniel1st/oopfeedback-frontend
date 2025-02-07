import java.util.Random;
import java.io.File;
import java.util.Scanner;

public class StationSimulation{
    public static void main(String[] args){
        //Q3
        FuelStation fs = new FuelStation();
        String result;
        
        result = fs.toString();
        
        System.out.println(result);
        
        
        //Q4
        Random r = new Random();
        double volume = r.nextDouble(99999);
        String[] triggerTypes = {"petrol", "gasoline", "cng"};
        String type = triggerTypes[r.nextInt(3)];
        
        System.out.print("Filled up: ");
        if (fs.dispense(type, volume)){
            System.out.println(" true");
        }
        else{
            System.out.println(" false");
        }
        
        String result2 = fs.toString();
        System.out.println(result2);
        
        //Q5 & Q6
        try{
            File dataFile = new File("vehicles.txt");
            Scanner fileScanner = new Scanner(dataFile);
            String carData = "";
            
            while (fileScanner.hasNextLine()){
                carData = fileScanner.nextLine();
                System.out.println(carData);
                
                String[] splitData = carData.split(",");
                Vehicle v = createVehicle(splitData);
                
                serviceVehicle(v, fs);
            }

        }
        catch(Exception e){
            System.out.println(e.toString());
        }
     }
    
    public static void serviceVehicle(Vehicle v, FuelStation fs){
        System.out.println(v);
        System.out.println("Filled up: " + fs.dispense(v.getFuelType(), v.getTankCapacity()));
    }
     
    public static Vehicle createVehicle(String[] dimensions){
        int length = Integer.parseInt(dimensions[0]);
        int breadth = Integer.parseInt(dimensions[0]);
        int width = Integer.parseInt(dimensions[0]);
        
        Vehicle v = new Vehicle(length, breadth, width);
        return v;
    }
}
