import java.util.ArrayList;

public class StationSimulation {
    public static void main (String[] args){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Vehicle n = new Vehicle(getRandomNumber(0,10), getRandomNumber(0,30), getRandomNumber(0,20), getRandomNumber(0,5));
            vehicles.add(n);
            System.out.println(n);
        }

        ArrayList<VehicleDriver> drivers = new ArrayList<>();
        String[] names = {"Bob", "James", "Harry", "Jones", "Larry"};
        for (int i = 0; i < 5; i++) {
            drivers.add(new VehicleDriver(names[i]));
        }

        for (VehicleDriver driver : drivers) {
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

    public static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
