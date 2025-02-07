public class Vehicle{
    //lets declare the attributes
    private int tankCapacity;
    private String fuelType;
    
    //constructor with arguemnts in it
    public Vehicle(int l, int w, int b){
        this.tankCapacity =l*b*w;
        if(this.tankCapacity%2==0){
            this.fuelType="gasoline";
        }
        else{
            this.fuelType="disel";
        }
    }
    
    //accessors
    public int getTankCapacity(){
        return this.tankCapacity;
    }
    
    public String getFuelType(){
        return this.fuelType;
    }
    
    public String toString(){
        return(
        "VEHICLE TANK CAPACITY: "+this.tankCapacity+
        "FUEL TANK: "+this.fuelType
        );
    }
}