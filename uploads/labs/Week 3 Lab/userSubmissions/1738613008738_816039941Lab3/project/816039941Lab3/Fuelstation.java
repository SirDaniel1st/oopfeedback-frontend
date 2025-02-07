import java.util.Scanner;

public class Fuelstation{
    
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
        
    
    //Constructor - Default No Argument
    public Fuelstation( ){
        fuelType="gasoline";
        fuelVolume=75000;
        fuelRate=2.0;
        fuelSales=0;
    }
    
    
    //Accessors
    public String getFuelType( ){ return fuelType;}
    public double getFuelVolume( ){ return fuelVolume;}
    public double getFuelRate( ){ return fuelRate;}
    public double getFuelSales( ){ return fuelSales;}
    
    //Mutators
    public void setFuel(String fuelType){
        if(fuelType==null);
        this.fuelType="gasoline";
    }
    public void setVolume(double fuelVolume){
        if(fuelVolume==0);
        this.fuelVolume=75000;
    }
    public void setRate(double fuelRate){
        if(fuelRate==0);
        this.fuelRate=2;
    }
    public void setSales(double fuelSales){
        if(fuelSales==0);
        this.fuelSales=0;
    }

    public String toString(){
        return ("FUEL: " + fuelType + " VOL: " + fuelVolume + "L " + "PRICE PER L: $" + String.format("%.02f",fuelRate) + " SALES: $" + String.format("%.02f",fuelSales));
    }
    
    private boolean sellFuel(double volume){
        if(fuelVolume>volume){
            fuelVolume=fuelVolume-volume;
            fuelSales+=volume*fuelRate;
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        return fuelType.equals(this.fuelType);
    }
    
    public boolean dispense(String fuelType,double volume){
        if(canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        return false;
    }
}