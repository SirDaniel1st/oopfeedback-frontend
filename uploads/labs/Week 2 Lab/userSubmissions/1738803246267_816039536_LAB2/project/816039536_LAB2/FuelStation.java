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
    
    public FuelStation(String fuelType){
        this.fuelType = "diesel";
        this.fuelVolume = 75000;
        this.fuelRate = 2;
        this.fuelSales = 0;
    }
    
    public String getFuelType(){return this.fuelType;}
    public double getFuelVolume(){return this.fuelVolume;}
    public double getFuelRate(){return this.fuelRate;}
    public double getFuelSales(){return this.fuelSales;}
    
    public String toString(){
        return("FUEL: "+ getFuelType() + 
                " VOL: " + String.format("%.1f",getFuelVolume()) + 
                "L PRICE PER L: $" + String.format("%.2f",getFuelRate()) +
                " SALES: $"+ String.format("%.2f",getFuelSales()));
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType != null){return fuelType.equals(getFuelType());}
        else{return false;}
    }
    
    public boolean dispense(String fuelType, double volume){
        if(canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        else{
            return false;
        }
    }
    
    private boolean sellFuel(double volume){
        if(getFuelVolume() >= volume){
            this.fuelVolume -= volume;
            this.fuelSales += volume * this.fuelRate;
            return true;
        }
        else{
            return false;
        }
    }
}