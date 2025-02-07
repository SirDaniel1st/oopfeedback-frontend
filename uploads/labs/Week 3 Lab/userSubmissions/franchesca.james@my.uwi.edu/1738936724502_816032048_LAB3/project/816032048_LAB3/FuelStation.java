
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
    
    //accessors
    public String getFuelType(){return this.fuelType;}
    public double getFuelVolume(){return this.fuelVolume;}
    public double getFuelRate(){return this.fuelRate;}
    public double getFuelSales(){return this.fuelSales;}
    
    public String toString(){
        return (
        "FUEL: " + this.fuelType + 
        " VOL: " + String.format("%.02f", this.fuelVolume) +
        "L PRICE PER L: " + "$" + String.format("%.02f", this.fuelRate) + 
        " SALES: " + "$" + String.format("%.02f", this.fuelSales)
        );
    }
    
    //mutators
    private boolean sellFuel(double volume){
        if(this.fuelVolume > volume){
            this.fuelVolume -= volume;
            this.fuelSales += (volume * this.fuelRate);
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType != null){
            return fuelType.equals(this.fuelType);
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if(canDispenseFuelType(fuelType) && sellFuel(volume)){
            return true;
        }
        return false;
    }
}
