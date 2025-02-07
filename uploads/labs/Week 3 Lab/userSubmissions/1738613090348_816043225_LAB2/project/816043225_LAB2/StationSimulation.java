import java.util.ArrayList;


public class StationSimulation {
    
    public static void main (String[] args){
        
    
    for (int i = 0; i<10; i++){
         Vehicle v = new Vehicle(
         StationSimulation.getRandomNumber(1,20),
         StationSimulation.getRandomNumber(1,5),
         StationSimulation.getRandomNumber(1,5)
         );
         System.out.println(v); 
    }
    
    ArrayList<Vehicle> vehicles = new ArrayList <Vehicle>();
    for (int i = 0; i<10; i++){
         Vehicle v = new Vehicle(
         StationSimulation.getRandomNumber(1,20),
         StationSimulation.getRandomNumber(1,5),
         StationSimulation.getRandomNumber(1,5),
         StationSimulation.getRandomNumber(1,5)
         );
         
    }
     ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
     String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
     for (int i = 0; i<10; i++){
         drivers.add(new VehicleDriver(names[i]));
     }
     for(VehicleDriver driver: drivers) {
         int index = StationSimulation.getRandomNumber(0,10);
         Vehicle v = vehicles.get(index);
         driver.addVehicle(v);
         do{
             index= StationSimulation.getRandomNumber(0,10);
             v=vehicles.get(index);
         } while (driver.addVehicle(v));
         System.out.println(driver);
     }
     
    
} 
    public static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max-min)) + min);
    }
    
}