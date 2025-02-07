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
    
    //overload Constructor
    public Vehicle(int length, int breadth, int width, int vehicleClass){
        this(length, breadth, width);
        setVehicleClassification(vehicleClass);
    }
    
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String toString(){
        return(
        "VEHICLE TANK CAPACITY: "+ getTankCapacity() + 
        " FUEL TYPE: "+ getFuelType() +
        " PLATEID : " + getPlateID() + 
        " VEHICLE CLASSIFICATION: " + getVehicleClassification() +
        " : " +
        getVehicleClassification(this.vehicleClassification)
        );
    }
    
    public String getPlateID(){
        return this.plateID;
    }
    
    //Mutator
    private void setPlateID(){
        if (plateNumberCounter<10){
            this.plateID = "TABO" + plateNumberCounter;
        }
        else{
            this.plateID="TAB"+plateNumberCounter;
        }
        
        plateNumberCounter++;
    }
    
    public int getVehicleClassification(){
        return this.vehicleClassification;
    }
    
    public String getVehicleClassification(int vClass){
        switch (vClass){
            case 1 : return "Mototcycle";
            case 3 : return "Light Motor Vehicle";
            case 4 : return "heavy Motor Vehicle";
        }
        return null;
    }
    
    public void setVehicleClassification(int value){
        if (value==1 || value==4){
            this.vehicleClassification = value;
        }
        
        else{
            this.vehicleClassification = 3;
        }
    }
    
    //Equals
    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            //Something
            Vehicle v = (Vehicle) obj;
            String otherVehiclePlateID = v.getPlateID();
            boolean result = this.plateID.equals(otherVehiclePlateID);
            return result;
        }
        return false;
    }
}