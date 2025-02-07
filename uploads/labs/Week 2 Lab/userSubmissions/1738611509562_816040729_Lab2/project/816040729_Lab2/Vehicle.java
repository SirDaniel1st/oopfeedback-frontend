public class Vehicle {
    private int tankCapacity;  
    private String fuelType;   

    public Vehicle(int length, int width, int breadth) {
        this.tankCapacity = length * width * breadth; 
        
        this.fuelType = (this.tankCapacity % 2 == 0) ? "gasoline" : "diesel";
    }

    
    public int getTankCapacity() {
        return tankCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }


    public String toString() {
        return "VEHICLE TANK CAPACITY: " + tankCapacity + " FUEL TYPE: " + fuelType;
    }
}
