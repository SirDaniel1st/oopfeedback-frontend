public class Vehicle {
    // Instance Variables
    private int tankCapacity;
    private int vehicleClassification;
    private String fuelType;
    private String plateID;
    // Class Variables
    private static int plateNumberCounter;
    
    
    // Static Initialiser
    static {
        plateNumberCounter = 1;
    }
    
    
    // Constructor
    public Vehicle(int length, int breadth, int width) {
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        setPlateID();
        setVehicleClassification(3);
    }
    
    // Overloaded Constructor
    public Vehicle(int length, int breadth, int width, int vehicleClassification) {
        this(length, breadth, width);
        setVehicleClassification(vehicleClassification);
    }
    
    
    // Accessors
    public int getTankCapacity() {
        return this.tankCapacity;
    }
    
    public int getVehicleClassification() {
        return this.vehicleClassification;
    }
    
    public String getVehicleClassification(int vehicleClassification) {
        switch(vehicleClassification) {
            case 1: return "Motorcycle";
            case 4: return "Heavy motor vehicle";
            default: return "Light motor vehicle";
        }
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    public String getPlateID() {
        return plateID;
    }
    
    public static int getPlateNumberCounter() {
        return plateNumberCounter;
    }
    
    
    // Mutators
    public void setVehicleClassification(int vehicleClassification) {
        switch(vehicleClassification) {
            case 1, 4:
                this.vehicleClassification = vehicleClassification;
                break;
            default:
                this.vehicleClassification = 3;
                break;
        }
    }
    
    private void setPlateID() {
        this.plateID = ("TAB" + String.format("%02d", getPlateNumberCounter()));
        setPlateNumberCounter();
    }
    
    private static void setPlateNumberCounter() {
        plateNumberCounter++;
    }
    
    
    // Methods
    public String toString() {
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity()
            + " FUEL TYPE: "+ getFuelType()
            + " PLATE ID: " + getPlateID()
            + " VEHICLE CLASSIFICATION: " + getVehicleClassification()
            + " " + getVehicleClassification(this.vehicleClassification);
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            String otherVehiclePlateID = v.getPlateID();
            return (this.plateID.equals(otherVehiclePlateID));
        }
        
        return false;
    }
}