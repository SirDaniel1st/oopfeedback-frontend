public class FuelStation
{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        this.fuelType = "gasoline";
        this.fuelVolume = 75000;
        this.fuelRate = 2;
        this.fuelSales = 0;
    }
    
    public String getFuelType(){return this.fuelType;} 
    public double getFuelVolume(){return this.fuelVolume;}
    public double getFuelRate(){return this.fuelRate;}
    public double getFuelSales(){return this.fuelSales;}
    
    public String toString(){
        return String.format("FUEL: %s VOL: %sL PRICE PER L: $%.2f SALES: $%.2f", getFuelType(), getFuelVolume(), getFuelRate(), getFuelSales());
        //("FUEL: " + getFuelType() + " VOL: " + getFuelVolume() + "L " + "PRICE PER L: $" + getFuelRate() + " SALES: $" + getFuelSales());
    }
    
    public boolean sellFuel(double volume){
        if(volume<this.fuelVolume){
        this.fuelVolume-=volume;
        this.fuelSales+=(volume*=fuelRate);
        return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType!=null){
            return fuelType.equalsIgnoreCase(this.fuelType);
        }
        return false;
    }
    
    public boolean dispense(String fuelType,double volume){
        if(canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        return false;
    }
    
    
    
    
    
    
    
    
    

        
   
}

