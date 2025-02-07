
public class FuelStation{
    
    public String fuelType;
    public double fuelVolume;
    public double fuelRate;
    public double fuelSales;
    
        public FuelStation() {
        this.fuelType = "gasoline";  
        this.fuelVolume = 75000.0;    
        this.fuelRate = 2.0;         
        this.fuelSales = 0.0;    
    }
    
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
    
    public String toString() {
        return "FUEL: " + getFuelType() + " VOL: " + getFuelVolume() + "L PRICE PER L: $" + String.format("%.2f", getFuelRate()) + " SALES: $" + String.format("%.2f", getFuelSales());
    }
    
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public void setFuelRate(double fuelRate) {
        this.fuelRate = fuelRate;
    }

    public void setFuelSales(double fuelSales) {
        this.fuelSales = fuelSales;
    }
    
    public boolean sellFuel(double volume) {
        if (volume > 0 && volume <= fuelVolume) {
            fuelSales += volume * fuelRate;
            fuelVolume -= volume;
            return true;  
        } else {
            return false; 
        }
    }
    public boolean canDispenseFuelType(String fuelType) {
        return this.fuelType.equals(fuelType);  
    }

    public boolean dispense(String fuelType, double volume) {
        if (!canDispenseFuelType(fuelType) || volume <= 0 || volume > fuelVolume) {
            return false;  
        }
        return sellFuel(volume); 
    }
    
    public void refuelStation(double volume) {
    if (volume > 0) {
        fuelVolume += volume;
    } else {
        System.out.println("Error: Invalid refuel volume.");
    }
}
}
    
   
    
