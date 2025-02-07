public class FuelStation{
    
    //declaring private attributes
    
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        
        fuelType = "gasoline";
        fuelVolume = 75000;
        fuelRate = 2.00;
        fuelSales = 0;
    }
    
    //creating accessors(getters)
    
    public String getFuelType(){
        
        return fuelType;
    }
    
    public double getFuelVolume(){
        
        return this.fuelVolume;
    }
    
    public double getFuelRate(){
        
        return this.fuelRate;
    }
    
    public double getFuelSales(){
        
        return this.fuelSales;
    }
    
    public String toString(){
        
        return(
        
        "FUEL : " +this.fuelType+
        " VOL : " +String.format("%.1f", this.fuelVolume)+
        "L PRICE PER L : $ " +this.fuelRate+
        " SALES : $ " +String.format("%.2f", +this.fuelSales));
    }
    
    private boolean sellFuel(double volume){
        
        if(this.fuelVolume > volume){
            
            this.fuelVolume -= volume;
            
            this.fuelSales += (volume * this.fuelRate);
            
            return true;
        }
        
        return false;
    }
    
    private boolean canDispenseFuelType(String fuelType){
        
        if(this.fuelType != null){
            
            //stringA == stringB does NOT work in java.Instead use
            
            return fuelType.equals(this.fuelType); //or getFuelType()
            
        }
        
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        
        if(canDispenseFuelType(fuelType)){
            
           return sellFuel(volume); 
    }
    
    return false;
    }
}
   