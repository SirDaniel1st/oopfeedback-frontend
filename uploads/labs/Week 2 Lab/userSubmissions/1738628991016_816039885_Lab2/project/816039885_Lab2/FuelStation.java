public class FuelStation{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        fuelType= "gasoline";
        fuelVolume = 75000;
        fuelRate= 2.00;
        fuelSales= 0;
    }
    
    public String getFuelType(){return fuelType;}
    public double getFuelVolume(){return fuelVolume;}
    public double getFuelRate(){return fuelRate;}
    public double getFuelSales(){return fuelSales;}
    
    
    public String toString(){
        return(
        "FUEL: "+this.fuelType+
        " VOL: "+String.format("%.1f",this.fuelVolume)+
        "L PRICE PER L: $"+String.format("%.2f",this.fuelRate)+
        " SALE: $"+String.format("%.2f",this.fuelSales));
    }
    
    private boolean sellFuel(double volume){
        if(this.fuelVolume>volume){
            this.fuelVolume-=volume;
            this.fuelSales+=(volume*this.fuelRate);
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType!=null){
            return fuelType.equals(this.fuelType);
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
