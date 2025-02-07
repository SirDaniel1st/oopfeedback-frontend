public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private static int plateNumberCounter  = 1;
    private String plateID;
    private int vehicleClassification;
    
    public Vehicle(int length, int breadth, int width){
        this(length, breadth, width, 3);
    }
    
    public Vehicle(int length, int breadth, int width, int classification){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        vehicleClassification = classification;
        setPlateID();
    }
    
    private void setPlateID(){
        plateID = "TAB" + String.format("%02d", plateNumberCounter++);
    }
    
    public String getPlateID(){
        return plateID;
    }
    
    public int getVehicleClassification(){
        return vehicleClassification;
    }
    
    public String getVehicleClassification(int classification){
        switch(classification){
            case 1: return "Motorcycle";
            case 3: return "Light motor vehicle";
            case 4: return "Heavy motor vehicle";
            default: return "Unknown Classification";
        }
    }
    
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() + " FUEL TYPE: "+ getFuelType() + " PLATE ID: " + getPlateID();
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            Vehicle v = (Vehicle) obj;
            String otherVehiclePlateID = v.getPlateID();
            boolean result = this.plateID.equals(otherVehiclePlateID);
            return result;
        }
        return false;
    }
    
}