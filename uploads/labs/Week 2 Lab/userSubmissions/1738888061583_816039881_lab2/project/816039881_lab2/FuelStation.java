public class FuelStation {
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation() {
        this.fuelType = "gasoline";
        this.fuelVolume = 75000.0;
        this.fuelRate = 2.0;
        this.fuelSales = 0.00;
    }
    
    public String getFuelType() {
        return this.fuelType;
    }
    
    public double getFuelVolume() {
        return this.fuelVolume;
    }
    
    public double getFuelRate() {
        return fuelRate;
    }
    
    public double getFuelSales() {
        return this.fuelSales;
    }
    
    public String toString() {
        return String.format("FUEL: %s VOL: %.1fL PRICE PER L: $%.1f SALES: $%.1f", getFuelType(), getFuelVolume(), getFuelRate(), getFuelSales());  
    }
    
    private boolean sellFuel(double volume) {
        if (this.fuelVolume >= volume) {
            this.fuelVolume = this.fuelVolume - volume;
            this.fuelSales = this.fuelSales + (volume * this.fuelRate);
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean canDispenseFuelType(String fuelType) {
        if (fuelType != null) {
            return fuelType.equals(this.fuelType);
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume) {
        if (canDispenseFuelType(fuelType)) {
            return sellFuel(volume);
        }
        return false;
    }
}