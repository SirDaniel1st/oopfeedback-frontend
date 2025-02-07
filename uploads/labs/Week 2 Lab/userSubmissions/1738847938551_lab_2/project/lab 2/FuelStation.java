public class FuelStation{
    //#1
    //a
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    //c
    public String getFuelType(){
        return fuelType;
    }
    public double getFuelVolume(){
        return fuelVolume;
    }
    public double getFuelRate(){
        return fuelRate;
    }
    public double getFuelSales(){
        return fuelSales;
    }
    
    //d
    public String toString(){
        return "FUEL: " + getFuelType() + " VOL: " + getFuelVolume() + " PRICE PER L: $" + getFuelRate() + " SALES: $" + getFuelSales();
    }
    
    //b
    public FuelStation(){
        fuelType = "gasoline";
        fuelVolume = 75000;
        fuelRate = 2;
        fuelSales = 0;
    }
    
    //#2
    public boolean sellFuel(double volume){
        if(fuelVolume-volume<0) return false;
        fuelSales += volume*fuelRate;
        fuelVolume -= volume;
        return true;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        //return fuelType == getFuelType();
        if(fuelType == this.fuelType) return true;
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        return (canDispenseFuelType(fuelType) && fuelVolume-volume>=0);
    }
}