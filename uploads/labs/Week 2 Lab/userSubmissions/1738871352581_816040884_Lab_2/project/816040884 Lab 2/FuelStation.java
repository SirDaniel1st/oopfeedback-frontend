public class FuelStation{
    //define attributes
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
 //no argument construtor
 //public classname(){}
 
    public FuelStation(){
        this.fuelType="gasoline";
        this.fuelVolume=75000;
        this.fuelRate=2.00;
        this.fuelSales=0.0;
     }
     
     //accessors(getters)-allow object to displpay or return attribute values
     //mutators(setters)- allow other objects/classes to set values to private attributes
     
     public String getFuelType(){return this.fuelType;}
     public double getFuelVolume(){return this.fuelVolume;}
     public double getFuelRate(){return this.fuelRate;}
     public double getFueltType(){return this.fuelSales;}
     
     public String toString(){
        return (
        "FUEL: "+this.fuelType/*getFuelType() can be used instead of the this.fuelType*/+ 
        " VOL: "+String.format("%.01f", this.fuelVolume)+
        " PRICE PER L: "+String.format("%.02f", this.fuelRate)+
        " SALES: "+String.format("%.02f", this.fuelSales)
        );
    }
     
    private boolean sellFuel(double volume){
        //check if volume is available
        if(this.fuelVolume>volume){
            this.fuelVolume-=volume;//reduce the volume requested fron fuelstation volume
            this.fuelSales += (volume*this.fuelRate);//calculate the amount the will pay
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if (fuelType != null ){//error checking- make sure thers a value
            return fuelType.equals(getFuelType());//can not use fuelType==getfuelType for a string
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if (canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        return false;
    }
    
    
}
    
    
    
    
    