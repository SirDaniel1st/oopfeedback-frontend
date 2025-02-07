public class FuelStation{
    //let us define the attributes
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    //create some no args constructor
    //public ClassName(){} (how to create constructor)
    
    public FuelStation(){
        this.fuelType="gasoline";
        this.fuelVolume=75000;
        this.fuelRate=2.00;
        this.fuelSales=0.0;
    }
    
    //Assessors(getters)- they allow the object to display or return its attribute values
    //Mutators(setters)= these are methods that allow other obhects or classes to set values to our private attributes.
    public String getFuelType(){  //example of accessor
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
    
    public String toString(){
        return(
        "FUEL: " +this.fuelType+    
        "VOL : " +String.format("%.01f", this.fuelVolume)+
        "L PRICE PER L : $" +String.format("%.02f", this.fuelSales)+
        " SALES : $" +String.format("%.02f", this.fuelSales)
        );
    }
    
    private boolean sellFuel(double volume){
        //gonna check if we have the right amount of fuel to sell
        if(this.fuelVolume>volume){
            this.fuelVolume-=volume;
            this.fuelSales+=(volume*this.fuelRate);
            return true;
        }
        
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType != null){
            return fuelType.equals(getFuelType());
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