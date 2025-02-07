import java.util.Random;
import java.util.ArrayList;
public class StationSimulation{

public static void main(String[] args){
    for(int count=0; count<10; count++){
        Vehicle v = new Vehicle(
                                getRandomNumber(1,25),
                                getRandomNumber(1,5),
                                getRandomNumber(1,5)
                                );
        System.out.println(v);
}

    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    for(int i=0; i<10; i++){
        vehicles.add(new Vehicle ( getRandomNumber(1,25),
                                getRandomNumber(1,5),
                                getRandomNumber(1,5)
                                )
                                );
    }
    
    
}
   
 public static int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max-min)) + min);
}
 
}
