import java.util.ArrayList;

public class StationSimulation{
    public static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min) + min));
    }
    
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        
        ArrayList<VehicleDriver> driver = new ArrayList<VehicleDriver>();
        String names[] = {"Tristan", "Vishesh", "Dylan", "Alex", "Rohan"};
        
        while(j < 5){
            driver.add(new VehicleDriver(names[i]));
            j++;
        }
        
        while(i < 10){
            int length = getRandomNumber(1, 10);
            int width = getRandomNumber(1, 10);
            int breadth = getRandomNumber(1, 10);
            int vehicleClassification = getRandomNumber(1, 5);
            while (vehicleClassification == 2){
                if (getRandomNumber(1, 4) != 2){
                    vehicleClassification = getRandomNumber(1, 4);
                }
            }
            Vehicle vehicle = new Vehicle(length, width, breadth, vehicleClassification);
            String output = vehicle.toString();
            System.out.println(output);
            i++;
        }
    }
}