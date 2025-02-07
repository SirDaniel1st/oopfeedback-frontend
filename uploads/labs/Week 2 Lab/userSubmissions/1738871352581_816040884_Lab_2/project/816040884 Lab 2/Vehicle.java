public class Vehicle{
    private int tankCapasity;
    private String fuelType;
    //accessor methods are used if attributes are private
    
    public Vehicle(int l, int w, int b){
        this.tankCapasity = l*b*w;
        if(this.tankCapasity %2 ==0){
            this.fuelType ="gasoline";
        }
        else{
            this.fuelType="diesel";
        }
    }
    
    //Acessors
    public int getTankCapasity(){return this.tankCapasity;}
    public String getFuelType(){return this.fuelType;}
    
    public String toString(){
        return(
        "VEHICLE TANK CAPACITY; " +this.tankCapasity+
        " FUEL TYPE: " +this.fuelType);
    }
    
}
