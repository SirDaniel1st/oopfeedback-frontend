public class FuelStation{
    
    //defining the attributes
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    //NOTE: you usually initialise the attributes inside of the constructor
    
    //creation of no-argument constructor
    public FuelStation(){
        this.fuelType="gasoline";
        this.fuelVolume=75000;
        this.fuelRate=2.00;
        this.fuelSales=0.0 ;
        
    }
    
    //Accessor methods (usually public, start with 
    public String getFuelType(){return this.fuelType;}
    public double getFuelVolume(){return this.fuelVolume;}
    public double getFuelRate(){return this.fuelRate;}
    public double getFuelSales(){return this.fuelSales;}
    
    public String toString(){
        return(
        "FUEL: " +this.fuelType /*getFuelType()*/+
        " VOL: "+String.format("%.01f", this.fuelVolume)+
        " L PRICE PER L: "+String.format("%.02f", this.fuelRate)+ 
        " SALES: "+String.format("%.02f", this.fuelSales)
        );
    }
    
    private boolean sellFuel(double volume){
        //check if we have the right amount of fuel to sell
        if(this.fuelVolume>volume){
           this.fuelVolume -= volume;
           this.fuelSales += (this.fuelRate*volume);
           return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType!=null){
            return fuelType.equals(getFuelType()) /*this.fuelType*/;
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if(canDispenseFuelType(fuelType)){
            //no other class can use sellFuel because it is private therefore we must make a pathway
            return sellFuel(volume);
        }
        return false;
    }
    
    
}