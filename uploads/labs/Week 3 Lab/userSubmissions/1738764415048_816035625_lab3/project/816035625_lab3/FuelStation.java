
/**
 * Write a description of class FuelStation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */          
public class FuelStation
{
    // instance variables - replace the example below with your o
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        fuelType = "gasoline";
        fuelVolume = 75000;
        fuelRate = 2;
        fuelSales = 0;
    }
    
    //Accessors
    public String getFuelType(){return fuelType;}
    public double getFuelVolume(){return fuelVolume;}
    public double getFuelRate(){return fuelVolume;}
    public double getFuelSales(){return fuelVolume;}
    
    //toString( ) method that produces and returns a string as follows:
    //FUEL: gasoline VOL: 75000.0L PRICE PER L: $2.00 SALES: $0.00
    public String toString(){
        return "FUEL: " +   fuelType + " VOL: " + fuelVolume + "L PRICE PER L: $" 
        + String.format("%.02f", fuelRate) + " SALES: $" + fuelSales; 
        // format used to print to 2dp
        
    }
    
    //Decreases the fuelVolume of the FuelStation by the supplied volume, if possible, updates
    //the sales values, returns true if successful false otherwise. This method is private
    private boolean sellFuel(double volume){
        if(fuelVolume < volume){
            return false;
        }
        
        fuelVolume -= volume;
        fuelSales += volume * fuelRate;
        
        return true;
        
    }


    //Returns true if the FuelStation dispenses fuel of the supplied type, false otherwise. 
    //This method is public.
    public boolean canDispenseFuelType( String fuelType){
        if (fuelType != null){
            return this.fuelType.equals(fuelType);
        }
        
        return false;
    }
    
    //Returns true if the FuelStation can dispense the supplied type and volume of fuel, false
    //otherwise. This method is public.
    public boolean dispense(String fuelType, double volume){
        if ( !canDispenseFuelType(fuelType)){
            return false;
        }
        
        if(!sellFuel(volume)){ 
            return false;
        }
        
        return true;
    }
    
    
}