public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    public static int plateNumberCounter = 1;
    private String plateID;
    private String ID;
    private String vehicleType;
    private int vehicleClassification;
    
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
    }
    
    public Vehicle(int length, int breadth, int width, int vehicleClassification){
        this(length,breadth,width);
        this.vehicleClassification = vehicleClassification;
    }
    
    public int getTankCapacity(){
        return tankCapacity;
    }
    
    public String getFuelType(){
        return fuelType;
    }
    
    public int getVehicleClassification(){
        return vehicleClassification;
    }
    
    public String getVehicleClassification(int vehicleClassification){
        if (vehicleClassification == 1){
            vehicleType = "Motorcycle";
        }
        else if (vehicleClassification == 3){
            vehicleType = "Light Motor Vehicle";
        }
        else{
            vehicleType = "Heavy Motor Vehicle";
        }
        return vehicleType;
    }
    
    private String setPlateID(){
        if (plateNumberCounter < 10){
            plateID = "TAB0";
        }
        else{
            plateID = "TAB";
        }
        plateID = plateID + plateNumberCounter;
        plateNumberCounter++;
        return plateID;
    }
    
    public boolean equals(Object obj){
        if (obj instanceof Vehicle){
            Vehicle v = (Vehicle) obj;
            String otherVehiclePlateID = v.getPlateID();
            boolean result = this.plateID.equals(otherVehiclePlateID);
            return result;
        }
        return false;
    }
    
    public String getPlateID(){
        ID = setPlateID();
        return ID;
    }
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() + " FUEL TYPE: "+ getFuelType() + " PLATE ID: " + getPlateID()
        + " VEHICLE CLASSIFICATION : " + getVehicleClassification() + " " + getVehicleClassification(this.vehicleClassification);
    }
    
}