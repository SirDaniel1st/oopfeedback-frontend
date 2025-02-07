import java.util.Random;

public class Vehicle {
    private static int plateNumberCounter = 1;
    private int tankCapacity;
    private String fuelType;
    private String plateID;
    private int vehicleClassification; 

    public Vehicle(int length, int breadth, int width) {this(length, breadth, width, 3); }

    public Vehicle(int length, int breadth, int width, int classification) {
        this.tankCapacity = length * breadth * width;
        this.fuelType = (tankCapacity % 2 == 0) ? "gasoline" : "diesel";
        setPlateID();
        setVehicleClassification(classification); 
    }

    private void setPlateID() {this.plateID = "TAB" + plateNumberCounter++;}

    public int getTankCapacity() {return tankCapacity;}

    public String getFuelType() {return fuelType;}

    public String getPlateID() {return plateID;}

    public int getVehicleClassification() {return vehicleClassification;}

    public String getVehicleClassification(int classification) {
        switch (classification) {
            case 1: return "Motorcycle";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehicle";
            default: return "Unknown Classification";
        }
    }

    public void setVehicleClassification(int classification) {
        if (classification == 1 || classification == 3 || classification == 4) {this.vehicleClassification = classification;}
        else {this.vehicleClassification = 3; }
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

    public String toString() {return String.format("VEHICLE PLATE ID: %s TANK CAPACITY: %d FUEL TYPE: %s VEHICLE CLASSIFICATION: %d %s",getPlateID(), getTankCapacity(), getFuelType(), getVehicleClassification(), getVehicleClassification(getVehicleClassification()));}
}
