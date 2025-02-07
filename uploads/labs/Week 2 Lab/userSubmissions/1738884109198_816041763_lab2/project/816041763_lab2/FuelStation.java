
public class FuelStation{
    
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        this.fuelType="gasoline";
        this.fuelVolume=75000;
        this.fuelRate=2.00;
        this.fuelSales=0.0;
    }
    
    //Accessor example - simple name getter, allows the object 
    //to display or return attributes values
    public String getfuelType(){
        return this.fuelType;
    }
    
    public double getfuelVolume(){
        return this.fuelVolume;
    }
    
    public double getfuelRate(){
        return this.fuelRate;
    }
    
    public double getfuelSales(){
        return this.fuelSales;
    }
    
    public String toString(){
        //"FUEL: "gasoline" VOL: "75000.0"L PRICE PER L: $"2.00" SALES: $"0.00"
        return ("FUEL: "+ getfuelType() +
        " VOL: "+ String.format("%.01f", getfuelVolume() )+
        "L PRICE PER L: $"+ String.format("%.02f",getfuelRate() ) +
        " SALES: $"+ String.format("%.02f",getfuelSales() ) );
    }
    
    private boolean sellFuel(double volume){
        if (this.fuelVolume > volume){
            this.fuelVolume-=volume;
            this.fuelSales +=(volume*this.fuelRate);
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType != null){   //checks if the requestin string is empty
            return fuelType.equals(getfuelType()); //returns a true or false if the fuel is sold at station
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if (canDispenseFuelType(fuelType)){
            if (sellFuel(volume)){
                return sellFuel(volume);
            }
            return false;
        }
        return false;
    }
}
