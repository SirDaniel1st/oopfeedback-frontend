import java.util.Scanner;
import java.io.File;



public class StationSimulation{
    /*
     * Instance by importing it, then called it
     * e.g
     *  * Random rand = new Random();
     *  * so the template is
     *  * ClassName = InstanceName = new Class Constructor();
     */
    public static void main (String[] args){
        FuelStation fS = new FuelStation();
        System.out.println(fS.toString()); // can also be just FS it means the same
        
        //try cathc block, for trying code on a file and catching the error if one occurs.
        try{
            //try block
            //Open File code
            File data = new File("vehicles.txt");
            Scanner FScanner = new Scanner(data);
            String carData="";
            
            while(FScanner.hasNextLine()){
                carData=FScanner.nextLine();
                System.out.println(carData);
                String[] sd= carData.split(",");
                Vehicle v = createVehicle(sd);
                service(v,fS);
            }
        }
        catch(Exception e){
            //catch block
            System.out.println(e.toString());
        }
        
    }
    
    public static void service(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(
        "filled up:"+f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
    }
    
    public static Vehicle createVehicle(String[] dimensions){
        int l = Integer.parseInt(dimensions[0]);
        int b =Integer.parseInt(dimensions[1]);
        int w =Integer.parseInt(dimensions[2]);
        Vehicle v = new Vehicle(l,w,b);
        return v;
    }
}
