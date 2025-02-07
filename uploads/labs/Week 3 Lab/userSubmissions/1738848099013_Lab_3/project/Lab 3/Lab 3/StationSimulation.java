import java.util.Random;
import java.util.ArrayList;
public class StationSimulation{
public static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max-min)) + min);
}
    public static void main(String [] args){
    for(int i = 10; i>=0; i--){
        Vehicle veh = new Vehicle(getRandomNumber(1,20),getRandomNumber(1,20),getRandomNumber(1,20)); 
        //StationSimulation.getRandomNumber(p,q);
        System.out.println(veh);
    }
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    for(int i = 10; i>=0; i--){
        //Vehicle veh = new Vehicle(getRandomNumber(1,20),getRandomNumber(1,20),getRandomNumber(1,20), getRandomNumber(1,20));
        Vehicle veh = new Vehicle(getRandomNumber(1,20),getRandomNumber(1,20),getRandomNumber(1,20));
        //StationSimulation.getRandomNumber(p,q);
        System.out.println(veh);
    }
    ArrayList <VehicleDriver> drivers = new ArrayList<VehicleDriver>();
    String[] names = {"Lou", "Sue", "Drew", "koo", "Murphy"};
    for(int i = 0; i<10; i++){
        drivers.add(new VehicleDriver(names[i]));
    }
    for(VehicleDriver driver: drivers){
        int index = StationSimulation.getRandomNumber(0,10);
        Vehicle v = vehicles.get(index);
        driver.addVehicle(v);
        do{
            index = StationSimulation.getRandomNumber(0,10);
            v=vehicles.get(index);
        }while(driver.addVehicle(v));
        System.out.println(driver);
    }
}
}

