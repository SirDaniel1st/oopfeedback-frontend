public class Vehicle{
    
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int l, int w, int b){
        
        this.tankCapacity = l * w * b;
        
        if(tankCapacity % 2 == 0){
            
            this.fuelType = "gasoline";
        }
        
        else{
            
            this.fuelType = "diesel";
        }
    }
    
    //giving it accessors
    
    public int getTankCapacity(){
        
        return this.tankCapacity;
    }
    
    public String getFuelType(){
        
        return this.fuelType;
    }
    
    public String toString(){
        
        return("VEHICLE TANK CAPACITY : " + this.tankCapacity + "FUEL TYPE : " + this.fuelType);
    }
}
