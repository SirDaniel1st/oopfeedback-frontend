import java.util.ArrayList;

public class StationSimulation{
    public static void main(String[] args){
        for(int i=0; i<10;i++){
            int l = getRandomNumber(1,50);
            int b = getRandomNumber(1,15);
            int w = getRandomNumber(1,20);
            Vehicle v = new Vehicle(l, b, w);
            System.out.println(v.toString());
        }
        
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        for(int i=0; i<10;i++){
            int l = getRandomNumber(1,50);
            int b = getRandomNumber(1,15);
            int w = getRandomNumber(1,20);
            int c = getRandomNumber(1,5);
            vehicles.add(new Vehicle(l, b, w, c));
        }
        
        ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
        String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        for(int i=0;i<5;i++){
            drivers.add(new VehicleDriver(names[i]));
        }
        
        for(VehicleDriver driver: drivers){
            int index = getRandomNumber(1,10);
            Vehicle v = vehicles.get(index);
            driver.addVehicle(v);
            
            do{
                index = getRandomNumber(1,10);
                v = vehicles.get(index);
            } while(driver.addVehicle(v));
            System.out.println(driver);
        }
    }
    
    public static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
    
}