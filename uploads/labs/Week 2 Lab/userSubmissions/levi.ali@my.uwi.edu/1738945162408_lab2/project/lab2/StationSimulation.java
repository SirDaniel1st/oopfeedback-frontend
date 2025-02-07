import java.util.Scanner;
//import java.util.Random;
//import java.text.DecimalFormat;
import java.io.File;


public class StationSimulation{
    public static Vehicle newVehicle(String s[]){
        int length = Integer.parseInt(s[0]);
        int width = Integer.parseInt(s[1]);
        int breadth = Integer.parseInt(s[2]);
        Vehicle car = new Vehicle(length, width, breadth);
        return car;
    }
    public static void fillTank (Vehicle car, FuelStation x){
        System.out.println(car.toString());
        if(x.canDispenseFuelType(car.getFuelType())==true){
            System.out.println("Filled up:" + x.dispense(car.getFuelType(), car.getTankCapacity()));
            System.out.println(x.toString());
        } else {
            System.out.println("Filled up:false");
            System.out.println(x.toString());
        }
    }
    public static void main(String[] args){
        //Scanner input = new Scanner(System.in);
        //Random r = new Random();
        //FuelStation test = new FuelStation();
        //System.out.println(test.toString());
        //String s = input.nextLine();
        
        //while (!s.equals("exit")){
        //    double rand = r.nextInt(80000) + r.nextDouble();
        //    DecimalFormat df = new DecimalFormat("#.##");
        //    System.out.println("Number: "+ df.format(rand));
        //    if (test.dispense("gasoline", rand)==true){
        //        System.out.println("can sell");
        //    }
        //    s = input.nextLine();
        //}
        
        try{
            File file = new File("vehicles.txt");
            Scanner reader = new Scanner(file);
            String data="";
            FuelStation x = new FuelStation();
            
            while (reader.hasNextLine()){
                data = reader.nextLine();
                //System.out.println(data);
                Vehicle car = newVehicle(data.split(","));
                //System.out.println(car.toString());
                fillTank(car, x);
            }
        } catch (Exception e) {
            System.out.println ("Something went wrong.");
        }
    }    
}