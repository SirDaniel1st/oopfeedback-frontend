import java.util.ArrayList;

public class StationSimulation {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Vehicle v = new Vehicle(getRandomNumber(1,20),
                                    getRandomNumber(1,5), 
                                    getRandomNumber(1,5),
                                    getRandomNumber(1,5)
                                    );
            System.out.println(v);
        }
        
        //Using Array Lists
        //Arrays - Vehicle[] vehicles
        //Array Lists - ArrayList<Vehicle> vehicles
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        for (int i = 0; i < 10; i++) {
            vehicles.add(new Vehicle(
                            getRandomNumber(1,20),
                            getRandomNumber(1,5), 
                            getRandomNumber(1,5),
                            getRandomNumber(1,5) 
                )
            );
        }
        //ArrayList now has 10 vehicles in it
        
        ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
        String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        for (int i = 0; i < 5; i++) {
            drivers.add(new VehicleDriver(names[i]));
        }
        
        for (VehicleDriver driver: drivers) {
            int index = getRandomNumber(1,10);
            Vehicle v = vehicles.get(index);
            driver.addVehicle(v);
            //This ONLY does up to the FIRST vehicle
            
            //For the second vehicle(vehicle2)
            do{
               index = getRandomNumber(1,10);
               v = vehicles.get(index);
            } while(driver.addVehicle(v));
            System.out.println(driver);
        }
    } 
    
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
