import java.awt.im.InputMethodRequests;
import java.util.Scanner;
import java.io.File;

public class StationSimulation {
    public static void main (String[] args){
        FuelStation station = new FuelStation();
        System.out.println(station);

        try{
            File fp = new File("vehicle.txt");
            Scanner sc = new Scanner(fp);

            String carData = "";
            while(sc.hasNextLine()){
                carData = sc.nextLine();
                System.out.println(carData);

                Vehicle v = createVehicle(carData.split(","));
                serviceVehicle(v,station);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }

    }

    public static void serviceVehicle (Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(f.dispense(v.getFuelType(), v.getTankCapacity()));
    }

    public static Vehicle createVehicle(String[] dimensions){
        int l = Integer.parseInt(dimensions[0]);
        int w = Integer.parseInt(dimensions[1]);
        int b  = Integer.parseInt(dimensions[2]);
        Vehicle v = new Vehicle(l,w,b);
        return v;
    }

}
