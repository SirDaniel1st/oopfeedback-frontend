import java.util.Scanner;
import java.io.File;

public class StationSimulation
{
    public static void main(String[] args)
    {
        FuelStation fs = new FuelStation();
        System.out.print(fs.toString());
        
        try
        {
            File file = new File("vehicles.txt");
            Scanner s = new Scanner(file);
            String carData = "";
            
            while (s.hasNextLine())
            {
                carData = s.nextLine();
                System.out.println(carData);
                
                String[] splitData = carData.split(",");
                Vehicle v = createVehicle(splitData);
                serviceVehicle(v, fs);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    
        
        
    }
    
    public static void serviceVehicle(Vehicle v, FuelStation f)
    {
        System.out.println(v);
        System.out.println("Filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
    }
    public static Vehicle createVehicle(String [] dimensions)
    {
        int l = Integer.parseInt(dimensions[0]);
        int w = Integer.parseInt(dimensions[1]);
        int b = Integer.parseInt(dimensions[2]);
        
        Vehicle v = new Vehicle(l, w, b);
        return v; 
    }
}