public class FuelStation {
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;


    public FuelStation(){
        fuelType = "gasoline";
        fuelVolume = 75000;
        fuelRate = 2.00;
        fuelSales = 0;

    }

    public String getFuelType(){
        return this.fuelType;
    }
    public double getFuelVolume(){
        return this.fuelVolume;
    }
    public double getFuelRate(){
        return this.fuelRate;
    }
    public double getFuelSales(){
        return this.fuelSales;
    }

    public String toString (){
        return(
                this.fuelType + " : " +
                String.format("%.1f", this.fuelVolume) + " : " +
                String.format("%.2f", this.fuelRate) + " : " +
                String.format("%.2f", this.fuelSales)
        );
    }

    private boolean sellFuel(double volume){
        if(this.fuelVolume - volume < 0.00)
            return false;
        this.fuelVolume = this.fuelVolume - volume;
        this.fuelSales--;
        return true;
    }

    public boolean canDispenseFuelType (String fuelType){
        return fuelType.equals(this.fuelType);
    }

    public boolean dispense(String fuelType, double volume){
        return sellFuel(volume) && canDispenseFuelType(fuelType);
    }

}

