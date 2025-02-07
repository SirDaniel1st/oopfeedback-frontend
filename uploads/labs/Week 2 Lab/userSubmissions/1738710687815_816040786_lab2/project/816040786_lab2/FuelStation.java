public class FuelStation{
    
    //Q1a
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    
    //Q1b
    public FuelStation(){
        this.fuelType = "gasoline";
        this.fuelVolume = 75000;
        this.fuelRate = 2.00;
        this.fuelSales = 0.0;
    }
    
    //Q1c
    public String getType() {
        return this.fuelType;    
    }
    
    public double getVolume(){
        return this.fuelVolume;
    }
    
    public double getRate(){
        return this.fuelRate;
    }
    
    public double getSales(){
        return this.fuelSales;
    }
    
    //Q1d
    public String toString(){
        return ("FUEL: " + getType() + " VOL: " + getVolume() + "L PRICE PER L: $" + String.format("%.2f",getRate()) + " SALES:" + String.format("%.2f",getSales()));
    }
    
    
    //Q2
    private boolean sellFuel(double volume){
        if (volume <= getVolume()){
            this.fuelVolume -= volume;
            this.fuelSales += (volume * getRate());
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if (fuelType != null){
            return(fuelType.equals(this.fuelType));
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if (canDispenseFuelType(fuelType) && sellFuel(volume)){
            return true;
        }
        return false;
    }
}