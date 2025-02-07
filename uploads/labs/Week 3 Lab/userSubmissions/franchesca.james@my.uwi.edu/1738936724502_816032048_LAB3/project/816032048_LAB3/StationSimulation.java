import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class StationSimulation{
    public static void main(String[] args){
        /*FuelStation fs = new FuelStation();
        
        System.out.println(fs);
        
        System.out.println(fs.canDispenseFuelType("disel"));
        System.out.println(fs.dispense("gasoline", 200));
        
        Vehicle carData = new Vehicle(15, 2, 2);
        
        System.out.println(carData);
        
        try{
            File data = new File("vehicles.txt");
            Scanner fileScanner = new Scanner(data);
            String car = " ";
            ArrayList vehicleData = new ArrayList();
            
            while(fileScanner.hasNextLine()){
                car = fileScanner.nextLine();
                
                //vehicleData.add(fileScanner.nextLine());
                String[] splitData = car.split(",");
                Vehicle v = createVehicle(splitData);
                serviceVehicle(v, fs);
            }
            //fileScanner.close();
            //System.out.println(vehicleData);
        }catch(Exception e){
            System.out.println("Error occurred " + e.toString());
        }
        */
        //NEW CODE
        
        /*for (int i = 0; i < 10; i++){
            Vehicle v = new Vehicle(getRandomNumber(1,20), 
                                    getRandomNumber(1,20),
                                    getRandomNumber(1,20),
                                    getRandomNumber(1,5));
            System.out.println(v);
        }
        */
        //ARRAYLIST
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        for (int i = 0; i < 10; i++){
          vehicles.add (new Vehicle(getRandomNumber(1,20), 
                        getRandomNumber(1,20),
                        getRandomNumber(1,20),
                        getRandomNumber(1,5)
                        ));
        }
        
        ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
        String[] names = {"Lou", "Sue", "Drew" , "Koo", "Murphy"};
        
        for(int i= 0; i < 5; i++){
            drivers.add(new VehicleDriver(names[i]));
        }
        
        for(VehicleDriver driver : drivers){
            int index = getRandomNumber(0,10);
            Vehicle v = vehicles.get(index);
            driver.addVehicle(v);
            
            do{
                index = getRandomNumber(0,10);
                v = vehicles.get(index);
            }while(driver.addVehicle(v));
            
             System.out.println(driver);
            
        }
    }
    /*public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(
        "Filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity())
        );
        System.out.println(f);
    }
    public static Vehicle createVehicle(String[] dimensions){
        int l = Integer.parseInt(dimensions[0]);
        int b = Integer.parseInt(dimensions[1]);
        int w = Integer.parseInt(dimensions[2]);
        
        Vehicle v = new Vehicle(l, w, b);
        return v;
    }*/
    
    
    //new code
    public static int getRandomNumber(int min, int max){
        return (int)((Math.random() * (max - min)) + min);
    }
}
