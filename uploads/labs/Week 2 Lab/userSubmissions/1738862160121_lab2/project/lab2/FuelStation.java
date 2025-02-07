public class FuelStation {
  //Instance variables
  private String fuelType;
  private double fuelVolume;
  private double fuelRate;
  private double fuelSales;
  
  //No-argument constructor
  public FuelStation () {
    this.fuelType = "gasoline";
    this.fuelVolume = 75000;
    this.fuelRate = 2;
    this.fuelSales = 0;
  }
  
  //Accesor methods
  public String getFuelType () {return fuelType;}
  public double getFuelVolume () {return fuelVolume;}
  public double getFuelRate () {return fuelRate;}
  public double getFuelSales () {return fuelSales;}
  
  public String toString() {
    return ("FUEL: " + this.fuelType + " VOL: " + String.format("%.1f", this.fuelVolume) + "L PRICE PER L: $" + String.format("%.02f", this.fuelRate) + " SALES: $" + String.format("%.02f", this.fuelSales));
  }
  
  private boolean sellFuel(double volume) {
    if (this.fuelVolume > volume) {
      this.fuelVolume -= volume;
      this.fuelSales += volume * this.fuelRate;
      return true;
    }
    else return false;
  }
  
  public boolean canDispenseFuelType(String fuelType) {
    if (fuelType != null && this.fuelType.equals(fuelType)) return true;
    else return false;
  }

  public boolean dispense(String fuelType, double volume) {
    if (canDispenseFuelType(fuelType)) return sellFuel(volume);
    else return false;
  }
}