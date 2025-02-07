public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int l, int b, int w){
        this.tankCapacity=l*b*w;
        if (this.tankCapacity%2==0){
            this.fuelType="gasoline";
        }
        else{
            this.fuelType="disel";
        }
    }
    
    //Accessors
    public int getTankCapacity(){return this.tankCapacity;}
    public String getFuelType(){return this.fuelType;}
    
    //toString 
    public String toString(){
        return ("VEHICLE TANK CAPACITY:"+this.tankCapacity + " FUEL TYPE: " +this.fuelType);
    }
}