import java.util.Scanner;
import java.io.File; 
//to read files

/*
 * Creating a templated to instance any class whether we create it or not
 * (we instanced Random by importing it then calling it: Random rand = new Random();)
 * 
 * the new template we are creating is:
 *      ClassName InstanceName = new Class Constructor()
 *      FuelStation f1 = new FuelStation();
*/
public class SationSimulation {
    public static void main (String[] args) {
        FuelStation f1 = new FuelStation();
        System.out.println(f1); // also System.out.println(f1.toString()) 
        System.out.println(" ");
        //try catch block
        try{
            //try come block of code
            //Files code
            File dataVehicles = new File("vehicles.txt");
            Scanner scanVehicles = new Scanner(dataVehicles);
            
            String carData = "";
            
            while(scanVehicles.hasNextLine()) {
                carData = scanVehicles.nextLine();
                //System.out.println(carData);
                //2, 3, 10
                //35, 35, 35
                //5, 10, 8
                
                /*splitting 3 values into l, w, b*/
                String[] splitData = carData.split(",");
                /*
                for (int i = 0; i < 3; i++) {
                    System.out.println(splitData[i]);
                }
                */
               
                Vehicle v = createVehicle(splitData);
                serviceVehicle(v, f1);
            }
        } //anticipating errors or exceptions or invalid arguments
        //if there are errors we catch it and print it for us
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public static void serviceVehicle(Vehicle v, FuelStation f1) {
        System.out.println(v);
        System.out.println(
        "Filled up: " + f1.dispense(v.getFuelType(), v.getTankCapacity())
        );
        System.out.println(f1);
        System.out.println(" ");
    }
    
    public static Vehicle createVehicle(String[] dimensions) {
        int l = Integer.parseInt(dimensions[0]);
        int w = Integer.parseInt(dimensions[1]);
        int b = Integer.parseInt(dimensions[2]);
        
        Vehicle v = new Vehicle(l, w, b);
        return v;
    }
}