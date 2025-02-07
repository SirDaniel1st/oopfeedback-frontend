public class FuelStation {
    
    //Defining attributes: fuelType(String), fuelVolume(double), fuelRate(double), fuelSales(double)
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    //Creating NO_ARGUMENT constructors: public ClassName()
    public FuelStation() {
        this.fuelType = "gasoline";
        this.fuelVolume = 75000;
        this.fuelRate = 2.00;
        this.fuelSales = 0.0;
    }
    
    //using accessors (getters) to display or return its atribute values
    public String getFuelType() {return this.fuelType;}
    public double getFuelVolume() {return this.fuelVolume;}
    public double getFuelRate() {return this.fuelRate;}
    public double getFuelSales() {return this.fuelSales;}
    
    //mutators (setters) allow other objects or classes to set values to our private attributes
    
    //using the toString() method
    public String toString() {
        return (
        "FUEL: " + this.fuelType /* using accessor: getFuelType() */ +
        " VOLUME: " + String.format("%.01f", this.fuelVolume /* using accessor: getFuelVolume() */ ) + "L" +
        " PRICE PER L: $" + String.format("%.02f", this.fuelRate /* using accessor: getFuelRate() */ ) +
        " SALES: $" + String.format("%.02f", this.fuelSales /* using accessor: getFuelSales() */ )
        );
    }
    
    private boolean sellFuel(double volume) {
        //Decreases the fuelVolume of the FuelStation 
        //by the supplied volume, if possible, updates 
        //the sales values, returns true if successful,
        //false otherwise.
        
        //error checking if we even have the amount of fuel to sell
        if (this.fuelVolume > volume) {
            this.fuelVolume -= volume;
            this.fuelSales += (volume * this.fuelRate);
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType) {
        if (fuelType != null) {
            return fuelType.equals(this.fuelType /* OR : getFuelType() */);
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