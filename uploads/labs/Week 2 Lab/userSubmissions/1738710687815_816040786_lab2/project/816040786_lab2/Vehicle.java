public class Vehicle{
    //Q7a
    private int tankCapacity;
    private String fuelType;
    
    //Q7b
    public Vehicle(int length, int width, int breadth){
        this.tankCapacity = length * breadth * width;
        if(this.tankCapacity % 2 == 0){
            this.fuelType = "gasoline";
        }
        else{
            this.fuelType = "diesel";
        }
    }
    
    //Q7c
    public int getTankCapacity(){
        return this.tankCapacity;
    }
    
    public String getFuelType(){
        return this.fuelType;
    }
    
    //Q7d
    public String toString(){ 
        return ("VEHICLE TANK CAPACITY: " + getTankCapacity() + " FUEL TYPEL: " + getFuelType());
    }
}
