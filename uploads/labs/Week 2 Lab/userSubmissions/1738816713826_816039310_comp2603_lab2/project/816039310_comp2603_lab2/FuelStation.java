public class FuelStation{
    private static String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        fuelType= "gasoline";
        fuelVolume= 75000;
        fuelRate=2;
        fuelSales=0;
    }
    
    public String getFuelType(){ return this.fuelType;}
    public double getFuelVolume(){ return this.fuelVolume;}
    public double getFuelRate(){return this.fuelRate;}
    public double getFuelSales(){return this.fuelSales;}
    
    public String toString(){
        return "FUEL: " + getFuelType() +" VOL: " + String.format("%.1f", getFuelVolume()) + "L PRICE PER L: $"+ String.format("%.1f", getFuelRate())+" SALES: $"+ String.format("%.1f", getFuelSales());
    }
    
    private boolean sellFuel(double volume){
      if(volume>this.fuelVolume)
          return false;
      else{
          this.fuelVolume=this.fuelVolume-volume;
          this.fuelSales= this.fuelSales + volume*this.fuelRate;
          return true;
      }
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(this.fuelType.equals(fuelType))
            return true;
        else
            return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if(canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
            return false;
    }
}