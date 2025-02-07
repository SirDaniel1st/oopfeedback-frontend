import java.util.ArrayList;

public class StationSimulation {
    public static void main(String[] args) {
        for(int i = 0; i <10; i++) {
            Vehicle v = new Vehicle(
                        getRandomNumber(1,20),
                        getRandomNumber(1,5),
                        getRandomNumber(1,5),
                        getRandomNumber(1,5)
                        );
            System.out.println(v);
        }
        
        //Arrays initialized: Vehicle[] vehicles
        //Array Lists: ArrayList<Vehicle> vehicles
        
        //Vehicle Array List:
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        for(int i = 0; i < 10; i++) {
            vehicles.add(
                    new Vehicle (
                        getRandomNumber(1,20),
                        getRandomNumber(1,5),
                        getRandomNumber(1,5),
                        getRandomNumber(1,5)
                    )
            );
        }
        // ArrayList has 10 Vehicles
        
        //Drivers Array List:
        ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
        String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        for(int i = 0; i < 5; i++) {
            drivers.add(new VehicleDriver(names[i]));
        }
        
        for(VehicleDriver driver : drivers) {
            int index = getRandomNumber(1,10);
            Vehicle v = vehicles.get(index);
            driver.addVehicle(v);
            //This only does the first vehicle, so do the 2nd one too
            
            do{
            index = getRandomNumber(1,10);
            v = vehicles.get(index);
            }while(driver.addVehicle(v));
            System.out.println(driver);
        }
    }
    
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}