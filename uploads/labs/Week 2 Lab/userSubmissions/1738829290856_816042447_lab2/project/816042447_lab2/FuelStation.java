public class FuelStation{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        fuelType = "gasoline";
        fuelVolume= 75000;
        fuelRate=2;
        fuelSales=0;
    }

    //Accessors
    public String getFuelType(){return this.fuelType;}
    public double getFuelVolume(){return this.fuelVolume;}
    public double getFuelRate(){return this.fuelRate;}
    public double getFuelSales(){return this.fuelSales;}
    
    public String toString(){
        return("FUEL: "+ this.fuelType+ " VOL: " + this.fuelVolume+ " PRICE PER L: " +
        String.format("%.02f", this.fuelRate)+ "SALES: $" + String.format("%.02f", this.fuelSales));
        
    }
    
    private boolean sellFuel(double volume){
        if (this.fuelVolume>volume){
            this.fuelVolume=this.fuelVolume-volume;
            this.fuelSales+=(volume*this.fuelRate);
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType (String fuelType){
        if (fuelType!= null){
            return fuelType.equals(this.fuelType);
        }
        return false;
        
    }
    
    public boolean dispense (String fuelType, double volume){
        if (canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        return false;
    }
}