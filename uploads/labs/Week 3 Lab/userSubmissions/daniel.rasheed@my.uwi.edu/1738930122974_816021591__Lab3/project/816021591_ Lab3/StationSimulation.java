import java.util.ArrayList;
public class StationSimulation{

    public static void main(String[] args){

        //Parts 1-3
        for(int i = 0; i<10; i++){
            Vehicle v = new Vehicle(StationSimulation.getRandomNumber(1,20),
                                    StationSimulation.getRandomNumber(1,5),
                                    StationSimulation.getRandomNumber(1,5), 
                                    StationSimulation.getRandomNumber(1,5));
            System.out.println(v);         
        }   

        //Parts 4-5
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        for(int i = 0; i<10; i++){
            vehicles.add(new Vehicle(StationSimulation.getRandomNumber(1,20),
                                     StationSimulation.getRandomNumber(1,5),
                                     StationSimulation.getRandomNumber(1,5), 
                                     StationSimulation.getRandomNumber(1,5)));
        }

        ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
        String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};
        for(int i = 0; i<5; i++){
            drivers.add(new VehicleDriver(names[i]));
        }

        for(VehicleDriver driver: drivers){
            int index = StationSimulation.getRandomNumber(0, 10);
            Vehicle v = vehicles.get(index);
            driver.addVehicle(v);
           do{
                index = StationSimulation.getRandomNumber(0, 10);
                v = vehicles.get(index);   
            }while(driver.addVehicle(v));

            System.out.println(driver);
        }

    }


    //from: https://www.baeldung.com/java-generating-random-numbers-in-range
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}
