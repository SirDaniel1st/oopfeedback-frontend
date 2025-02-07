
public class Vehicle{
    
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle (int length, int width, int breadth){
        this.tankCapacity = length*breadth*width;
        if (this.tankCapacity%2==0){
            this.fuelType = "gasoline";
        }else{
            this.fuelType = "diesel";
        }
    }
    
    public int getTankCapacity(){
        return this.tankCapacity;
    }
    
    public String getFuelType(){
        return this.fuelType;
    }
    
    public String toString(){
        //VEHICLE TANK CAPACITY: 60 FUEL TYPE: gasoline
        return ("VEHICLE TANK CAPACITY: "+ getTankCapacity() +
        " FUEL TYPE: "+ getFuelType());
    }
    
}
