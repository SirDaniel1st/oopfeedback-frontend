import java.util.Random;

public class Vehicle {
    private int tankCapacity;
    private String fuelType;
    private String plateID;
    private int vehicleClassification;

    private static int plateNumberCounter = 1;

    public Vehicle(int length, int breadth, int width) {
        tankCapacity = length * breadth * width;
        if (tankCapacity % 2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";

        setPlateID();
        this.vehicleClassification = 3; // Default classification
    }

    public Vehicle(int length, int breadth, int width, int classification) {
        this(length, breadth, width); // Call the previous constructor
        setVehicleClassification(classification);
    }

    private void setPlateID() {
        plateID = "TAB" + String.format("%02d", plateNumberCounter); // Plate ID starts with "TAB" and followed by a 2-digit number
        plateNumberCounter++; // Increment the counter for the next plate ID
    }

    public String getPlateID() {
        return plateID;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public int getVehicleClassification() {
        return vehicleClassification;
    }

    public String getVehicleClassification(int classification) {
        switch (classification) {
            case 1:
                return "Motorcycle";
            case 3:
                return "Light Motor Vehicle";
            case 4:
                return "Heavy Motor Vehicle";
            default:
                return "Unknown Classification";
        }
    }

    public void setVehicleClassification(int classification) {
        if (classification == 1 || classification == 3 || classification == 4) {
            this.vehicleClassification = classification;
        } else {
            System.out.println("Invalid classification. Setting to default (3: Light Motor Vehicle).");
            this.vehicleClassification = 3;
        }
    }

    public String toString() {
        return "VEHICLE TANK CAPACITY: " + getTankCapacity()
                + " FUEL TYPE: " + getFuelType()
                + " PLATE ID: " + getPlateID()
                + " VEHICLE CLASSIFICATION: " + getVehicleClassification(vehicleClassification);
    }

    public String getFuelType() {
        return fuelType;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            return this.plateID.equals(v.plateID);
        }
        return false;
    }
}
