public class FuelStation {
    
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;

    //Note for when I'm reviewing lab - this.fuelType and fuelType and two ways of referencing the attribute
    public FuelStation() {
        this.fuelType = "gasoline";
        this.fuelVolume = 75000.0;
        this.fuelRate = 2.0;
        this.fuelSales = 0.0;
    }

    // Accessor methods (getters)
    public String getFuelType() {
        return fuelType;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuelSales() {
        return fuelSales;
    }

    
    private boolean sellFuel(double volume) {
        if (volume > 0 && volume <= fuelVolume) { 
            fuelVolume -= volume; 
            fuelSales += volume * fuelRate; 
            return true; 
        }
        return false; 
    }

    
    public boolean canDispenseFuelType(String fuelType) {
        if (fuelType != null && fuelType.equalsIgnoreCase(this.fuelType)) {
            return true; 
        }
        return false; 
    }

    
    public boolean dispense(String fuelType, double volume) {
        if (canDispenseFuelType(fuelType) && sellFuel(volume)) {
            return true; 
        }
        return false; 
    }

    // toString() method
    public String toString() {
        return "FUEL: " + getFuelType() + 
               " VOL: " + getFuelVolume() + "L" + 
               " PRICE PER L: $" + String.format("%.2f", getFuelRate()) + 
               " SALES: $" + String.format("%.2f", getFuelSales());
    }
}

