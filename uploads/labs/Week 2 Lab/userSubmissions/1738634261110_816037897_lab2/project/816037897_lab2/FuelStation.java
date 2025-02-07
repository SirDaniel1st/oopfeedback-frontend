public class FuelStation{
    
    //defining attributes:
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    //create some no args constructor
    //public ClassName(){}
    public FuelStation(){
        this.fuelType= "gasoline";
        this.fuelVolume=75000;
        this.fuelRate=2.00;
        this.fuelSales=0.0;
    }
    
    //Accessors (getters) - these allow the object to display or return its attributes values
    //Mutators (setters) - these are methods that allow other objects or classes to set values to our private attributes
    public String getFuelType(){return this.fuelType;}
    public double getFuelVolume(){return this.fuelVolume;}
    public double getFuelRate(){return this.fuelRate;}
    public double getFuelSales(){return this.fuelSales;}
    
    public String toString(){
        return(
        "FUEL: " +this.fuelType +
        "VOL: " +String.format("%.01f" , this.fuelVolume ) +
        "L PRICE PER L:  $"+String.format("%.02f" , this.fuelRate ) +
        "SALES: $" +String.format("%.02f" , this.fuelSales ) 
        );    
    }
    
    private boolean sellFuel(double volume){
        //error checking 
        if(this.fuelVolume>volume){
            this.fuelVolume-=volume; //reduce the volume requested from the fuelstation
            this.fuelSales += (volume*this.fuelRate); // calculate the amount they would pay and increase our sales by
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType != null){
            return fuelType.equals(this.fuelType);
        }
        return false;
    }
        
    public boolean dispense(String fuelType, double volume){
        if(canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        return false;
    }
}
