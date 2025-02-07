public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private static int plateNumberCounter = 1;
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
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public void setPlateID(){
        if(plateNumberCounter<10){
            plateID = "TAB" + "0" + plateNumberCounter;
        }else{
            plateID = "TAB" + plateNumberCounter;
        }
        plateNumberCounter++;
    }
    public String getPlateID(){
        return plateID;
    }
    public int getVehicleClassification(){
        return this.vehicleClassification;
    }
    //overloaded method
    public String getVehicleClassification(int vehicleClassification){
        //if-then-else statement alternative == SWITCH CASE
        switch(vehicleClassification){
            case 1: return "Motorcycle";
            case 3: return "Light motor vehicle";
            case 4: return "Heavy motor vehicle";
        }
        return null;
    }
    public void setVehicleClassification(int value){
        if(value==1 || value==4){
            vehicleClassification = value;
        }else
        vehicleClassification=3;
    }
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() + " FUEL TYPE: "+ getFuelType() + "PLATE ID:" + getPlateID() + "VEHICLE CLASSIFICATION: " + getVehicleClassification() + " " + getVehicleClassification(this.vehicleClassification);
    }
    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            Vehicle v = (Vehicle)obj;
            String otherVehiclePlateID = v.getPlateID();
            boolean result = this.plateID.equals(otherVehiclePlateID);
            return result;
        }else
        return false;
    }
}