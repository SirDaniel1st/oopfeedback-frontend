
/**
 * Write a description of class FuelStation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class FuelStation
{
    private String fuelType;
    private  double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        fuelType="gasoline";
        fuelVolume=75000;
        fuelRate=2;
        fuelSales=0;
    }
    
    public String getFuelType(){return fuelType;}
    public double getFuelVolume(){return fuelVolume;}
    public double getFuelRate(){return fuelRate;}
    public double getFuelSales(){return fuelSales;}
    
    public String toString(){
    return ("FUEL:"+getFuelType()+"VOL:"+getFuelVolume()+"L PRICE PER L:$"+getFuelSales());
    }
    
    private boolean sellFuel(double volume){
        if(fuelVolume>volume){
            fuelVolume=fuelVolume-volume;
            fuelSales=volume*fuelRate;
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFueltype(String fuelType){
        if(fuelType!=null){
            return fuelType.equals(this.fuelType);
        } 
    return false;
    }  
    
    public boolean dispense(String fuelType,double volume){
        
        if(canDispenseFueltype(fuelType)){
        return sellFuel(volume);
        }
        return false;
    }

}
    
