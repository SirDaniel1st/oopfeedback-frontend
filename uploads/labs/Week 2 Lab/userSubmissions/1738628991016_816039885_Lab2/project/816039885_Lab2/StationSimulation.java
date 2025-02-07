import java.io.File;
import java.util.Scanner;

public class StationSimulation{
    public static void main(String[] args){
        FuelStation f = new FuelStation();
        System.out.println(f);
        
        try{
            File dataFile =new File("vehicles.txt");
            Scanner dataScanner = new Scanner(dataFile);
            String carData="";
            
            while(dataScanner.hasNextLine()){
                carData=dataScanner.nextLine();
                System.out.println(carData);
                Vehicle v = createVehicle(carData.split(","));
                serviceVehicle(v, f);
            }
        }
        
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(
        "Filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity())
        );
        System.out.println(f);
    }
    
    public static Vehicle createVehicle(String[] dimensions){
        int l= Integer.parseInt(dimensions[0]);
        int w= Integer.parseInt(dimensions[1]);
        int b= Integer.parseInt(dimensions[2]);
        Vehicle v = new Vehicle(l, w, b);
        return v;
    }
}