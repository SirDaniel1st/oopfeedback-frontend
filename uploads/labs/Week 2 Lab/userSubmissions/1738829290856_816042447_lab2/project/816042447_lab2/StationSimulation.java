import java.util.Scanner;
import java.io.File;


public class StationSimulation{
    public static void main (String args[]){
        FuelStation fStation= new FuelStation();
        System.out.println(fStation);
        
        try{
            File dataFile =new File("vehicles.txt");
            Scanner sc = new Scanner (dataFile);
            String carData="";
            
            while(sc.hasNextLine()){
                carData =sc.nextLine();
                System.out.println(carData);
                Vehicle v = createVehicle(carData.split(","));
                serviceVehicle(v,fStation);
            }    
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public static Vehicle createVehicle(String[] dimensions){
        int l= Integer.parseInt(dimensions[0]);
        int w= Integer.parseInt(dimensions[1]);
        int b= Integer.parseInt(dimensions[2]);
        Vehicle v = new Vehicle (l,w,b);
        return v;


    }
    
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println("Fileld up : " + f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
    }
}
