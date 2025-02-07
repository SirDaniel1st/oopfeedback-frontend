import java.util.HashMap;

public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private String plateID;
    private int vehicleClassification = 3; // default
    
    private static int plateNumberCounter = 1;
    
    // Accessors
    public String getPlateID() { return this.plateID; }
    public int getVehicleClassification() { return this.vehicleClassification; }
    public String getVehicleClassification(int vehicleClassification) { 
        
        HashMap<Integer, String> classes = new HashMap<Integer, String>();
        
        classes.put(1, "Motorcycle");
        classes.put(3, "Light motor vehicle");
        classes.put(4, "Heavy motor vehicle");
        
        return classes.get(vehicleClassification);
    }
    
    // Mutators
    private void setPlateID() {
        this.plateID = "TAB" + String.format("%02d", this.plateNumberCounter);
        this.plateNumberCounter += 1;
    }
    private void setVehicleClassification(int vehicleClass) {
        if (vehicleClass < 1 || vehicleClass > 4 || vehicleClass == 2) {
            return;
        }
        
        this.vehicleClassification = vehicleClass;
    }
    
    // Constructors
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        setPlateID();
    }
    // 4-arg overloaded constructor
    public Vehicle(int length, int breadth, int width, int vehicleClassification) {
        this(length, breadth, width);
        setVehicleClassification(vehicleClassification);
    }
    
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String toString(){
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
            boolean result = this.plateID.equals(otherVehiclePlateID);
            return result;
        }
        return false;
    }
}