public class FuelStation{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        fuelType = "gasoline";
        fuelVolume = 75000.00;
        fuelRate = 2;
        fuelSales = 0;
    }
    
    //Accessors
    public String getFuelType(){return fuelType;}
    public double getFuelVolume(){return fuelVolume;}
    public double getFuelRate(){return fuelRate;}
    public double getFuelSales(){return fuelSales;}
    
    //Mutators - testing purposes
    public void setFuelType(String fuelType){this.fuelType = fuelType;}
    public void setFuelVolume(double fuelVolume){this.fuelVolume = fuelVolume;}
    public void setFuelRate(double fuelRate){this.fuelRate = fuelRate;}
    public void setFuelSales(double fuelSales){this.fuelSales = fuelSales;}
    
    public String toString(){
        return "FUEL:" + getFuelType() + " VOL:" + getFuelVolume() + " PRICE PER L:$" + getFuelRate() + " SALES:$" + getFuelSales();
    }
    
    private boolean sellFuel(double volume){
        if (this.getFuelVolume() >= volume){
            this.setFuelVolume(this.getFuelVolume() - volume);
            this.setFuelSales(this.getFuelSales() + (volume * this.getFuelRate()));
            return true;
        } else {return false;}
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if (fuelType == this.getFuelType()){return true;}
        else {return false;}
    }
    
    public boolean dispense(String fuelType, double volume){
        if (this.sellFuel(volume)==true && this.canDispenseFuelType(fuelType)==true){return true;}
        else {return false;}
    }
}
