public class Vehicle {
    // Attributes
    private int tankCapacity;
    private String fuelType;

    // Constructor
    public Vehicle(int length, int width, int breadth) {
        this.tankCapacity = length * width * breadth;
        if (this.tankCapacity % 2 == 0) {
            this.fuelType = "gasoline";
        } else {
            this.fuelType = "diesel";
        }
    }

    // Accessor methods
    public int getTankCapacity() {
        return tankCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    // toString method
    public String toString() {
        return "VEHICLE TANK CAPACITY: " + tankCapacity + " FUEL TYPE: " + fuelType;
    }

    // Main method for testing
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(2, 3, 10);
        System.out.println(vehicle);
    }
}