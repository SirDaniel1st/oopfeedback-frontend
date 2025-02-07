public class FuelStation{
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
    
    public String getFuelType(){
      return fuelType;  
    }
    
    public void setFuelType(String fuelType){
        this.fuelType = fuelType;
    }
    
    public double getFuelVolume(){
        return fuelVolume;
    }
    
    public void setFuelVolume(double volume){
        this.fuelVolume = volume;
    }
    
    public double getFuelRate(){
        return fuelRate;
    }
    
    public void setFuelRate(double rate){
        this.fuelRate = rate;
    }
    
    public double getFuelSales(){
        return fuelSales;
    }
    
    public void setFuelSales(double sales){
        this.fuelSales = sales;
    }
    
    public String toString(){
        return "TYPE: " + getFuelType() + " VOL: " + getFuelVolume() + "L" + " Price Per L: " + getFuelRate() + " Sales : " + getFuelSales();
    }
    
    
    private boolean sellFuel(double volume){
        if(volume <= fuelVolume && volume > 0){
            fuelVolume -= volume; // removes volume specified from fuelVolume
            fuelSales += fuelRate * volume; //increase fuel sales using the rate and volume supplied
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(this.fuelType.equals(fuelType)){
            return true;
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if(sellFuel(volume) && canDispenseFuelType(fuelType)){ //these 2 functions return true if fuel can be dispensed and sold LOL
            return true;
        }
        return false;
    }
    
    public boolean sellFuelToVehicle(double volume) {
    return sellFuel(volume); 
}

}