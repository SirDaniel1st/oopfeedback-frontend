public class FuelStation 
{
    //defining attributes
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales; 
    //the default values are set in the constructor
    
    //constructors are always public!!
    public FuelStation()
    {
        this.fuelType = "gasoline";
        this. fuelVolume = 75000.0;
        this.fuelRate = 2.00;
        this.fuelSales = 0.00;
    }
    
    //accessors
    public String getFuelType()
    {
        return this.fuelType;
    }
    public double getFuelVolume()
    {
        return this.fuelVolume;
    }
    public double getFuelRate()
    {
        return this.fuelRate;
    }
    public double getFuelSales()
    {
        return this.fuelSales;
    }
    
    //two string method
    public String toString()
    {
        return ("FUEL:" +  this.fuelType +
        "VOL: " + String.format("%.01f", this.fuelVolume) +
        " PRICE PER L: " + String.format("%.02f", this.fuelRate) + 
        " SALES: $ " + String.format("%.02f", this.fuelSales));
    }
    
    private boolean sellFuel(double volume)
    {
        //checking if we have enough to subtract given volume from fuel volume
        if (this.fuelVolume > volume)
        {
            this.fuelVolume -= volume; 
            this.fuelSales += (volume * this.fuelRate);
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType)
    {
        if (fuelType != null)
        {
            return fuelType.equals(getFuelType());
            //return fuelType.equals(this.fuelType);
        }
        return false; 
    }
    
    public boolean dispense(String fuelType, double volume)
    {
        if (canDispenseFuelType(fuelType))
        {
            return sellFuel(volume);
        }
        return false;
    }
}