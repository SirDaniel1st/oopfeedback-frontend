
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Vehicle
{
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle (int length,int breadth,int width){
        this.tankCapacity=length*breadth*width;
        if(tankCapacity%2==0){
            fuelType="gasoline";
        }
        else{
            fuelType="disel";
        }
    }
    public int getTankCapacity(){
        return this.tankCapacity;
    }
    
    public String getFuelType(){return this.fuelType;}
    
    public String toString(){
        return ("VEHICLE TANK CAPACITY:"+this.tankCapacity+"FUEL TYPE:"+this.fuelType);
    }
}
