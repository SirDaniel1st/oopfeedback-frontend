public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    //class variable
    private static int plateNumberCounter=1;
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
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() + 
        " FUEL TYPE: "+ getFuelType() + 
        " PLATE ID: " + getPlateID() +
        " " + getVehicleClassification(this.vehicleClassification);
    }
    
    //Mutator
    private void setPlateID(){
        if(plateNumberCounter<10){
            plateID="TAB0"+plateNumberCounter;
        }
        else{
            plateID = "TAB"+plateNumberCounter;
        }
        plateNumberCounter++;
    }
    
    public void setVehicleClassification(int value){
        if (value==1 || value==4){
            vehicleClassification=value;
        }
        else vehicleClassification=3;
    }
    
    //Accessor
    public String getPlateID(){
        return plateID;
    }
    public int getVehicleClassification(){
        return this.vehicleClassification;
    }
    
    //Overloaded Accessors
    public String getVehicleClassification(int vehicleClassification){
        switch(vehicleClassification){
            case 1: return "Motorcycle";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehicle";
        }
        return null;
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            Vehicle v= (Vehicle) obj;
            String otherVehiclePlateID = v.getPlateID();
            boolean result= this.plateID.equals(otherVehiclePlateID);
            return result;
        }
        return false;
    }
}