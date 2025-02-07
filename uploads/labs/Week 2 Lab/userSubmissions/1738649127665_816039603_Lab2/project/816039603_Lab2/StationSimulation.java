import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

public class StationSimulation{
    public static void main(String[] args){
        FuelStation station = new FuelStation();
        String s1 = station.toString();
        System.out.println(s1);
        
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        
        try{
        File file = new File("vehicles.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){   
        String data = scanner.nextLine();
        String regex = "[,]";
        String ints[] = data.split(regex);
        int length = Integer.parseInt(ints[0]);
        int width = Integer.parseInt(ints[1]);
        int breadth = Integer.parseInt(ints[2]);
        
        Vehicle vehicle = new Vehicle (length, width, breadth);
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle);
        
        
        
        System.out.println(data);
        }
        scanner.close();
        }catch(IOException e){
            System.out.println("An error occurred..");
            e.printStackTrace();
        }
        
        System.out.println("Vehicles in the list:");
        boolean filled = false;
        for (Vehicle v : vehicles){
            System.out.println(v);
            if(station.canDispenseFuelType(v.getFuelType())){
                double volume = (v.getTankCapacity());
                filled = true;
                station.sellFuelToVehicle(volume);
            }
            System.out.println("FILLED : " + filled);
            System.out.println(station);
        }
        
}  

}