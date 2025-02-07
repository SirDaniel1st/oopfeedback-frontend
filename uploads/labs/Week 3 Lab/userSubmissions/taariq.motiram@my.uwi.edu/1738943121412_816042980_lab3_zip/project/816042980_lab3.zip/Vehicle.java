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
    //this.attribute -> this instance of that attribute
    //this.method() -> refers to this object's method
    //this() -> calling its own constructor
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
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() 
        + " FUEL TYPE: "+ getFuelType()
        + " PLATE ID: "+ getPlateID()
        + " VEHICLE CLASSIFICATION: "+ getVehicleClassification()
        + " : " + getVehicleClassification(this.vehicleClassification);
    }
    public int getPlateNumberCounter(){return this.plateNumberCounter;}
    public String getPlateID(){return this.plateID;}
    public int getVehicleClassification(){return this.vehicleClassification;}
    public String getVehicleClassification(int vehicleClassification){
        switch(vehicleClassification){
            case 1: return "Motorcycle";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehicle";
        }
        return null;
    }
    
    private void setPlateID(){
        if(plateNumberCounter < 10){
            this.plateID = "TAB0"+this.plateNumberCounter;
        }
        else{
            this.plateID = "TAB"+this.plateNumberCounter;
        }
        plateNumberCounter++;
    }
    public void setVehicleClassification(int value){
        if (value == 1 || value == 4){
            this.vehicleClassification = value;
        }
        else{
            this.vehicleClassification = 3;
        }
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