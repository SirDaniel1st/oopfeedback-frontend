public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private static int plateNumberCount = 1;
    private String plateID;
    private int vehicleClassification;
    
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        setPlateID();
        setVehicleClassification(3);
    }

    public Vehicle(int length, int breadth, int width, int vehicleClassification){
        this(length, breadth, width);
        setVehicleClassification(vehicleClassification);
    }

    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String getPlateID() {
        return plateID;
    }
    public int getVehicleClassification() {
        return vehicleClassification;
    }
    public String getVehicleClassification(int vehicleClassification) {
        switch (vehicleClassification){
            case 1:
                return "Motorcycle";
            case 3:
                return "Light motor vehicle";
            case 4:
                return "Heavy motor vehicle";
            default:
                return null;
        }
    }

    public String toString(){
        return ("VEHICLE TANK CAPACITY: "+ getTankCapacity()
                + " FUEL TYPE: " + getFuelType()
                + " PLATE ID: " + getPlateID()
                + " VEHICLE CLASSIFICATION: " + getVehicleClassification()
                + " " + getVehicleClassification(this.vehicleClassification));

    }

    private void setPlateID(){
        if(plateNumberCount < 10)
            this.plateID = "TAB" + 0 + plateNumberCount;
        else
            this.plateID = "TAB" + plateNumberCount;
        plateNumberCount++;
    }
    public void setVehicleClassification(int vehicleClassification) {
        if (vehicleClassification > 0 && vehicleClassification <= 4 && vehicleClassification != 2){
            this.vehicleClassification = vehicleClassification;
        }
        else {
            this.vehicleClassification = 3;
        }
    }

    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            Vehicle v = (Vehicle) obj;
            String otherVehiclePlateID = v.getPlateID();
            return this.plateID.equals(otherVehiclePlateID);
        }
        return false;
    }
}