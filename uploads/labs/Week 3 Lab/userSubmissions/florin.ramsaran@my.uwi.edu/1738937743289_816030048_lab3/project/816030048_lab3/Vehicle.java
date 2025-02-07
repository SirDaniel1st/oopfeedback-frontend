public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        setPlateID();
        setVehicleClassification(3);
    }
    
    //Accessors
    
    public int getTankCapacity(){
        return tankCapacity;
    }
    
    public String getFuelType(){
        return fuelType;
    }
    
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() 
        + " FUEL TYPE: "+ getFuelType()
        + " PLATE ID: " + getPlateID();
    }
    
    //new variables
    int plateNumberCounter = 1;
    String plateID;
    private int vehicleClassification;
    //new private muttator to make plate
    private void setPlateID(){
        if(plateNumberCounter<10){
            this.plateID = "TAB0" + plateNumberCounter;
        }
        else{
            this.plateID = "TAB0" + plateNumberCounter;
        }
        plateNumberCounter++ ;
    }
    // new accesssor
    public String getPlateID(){
        return this.plateID;
    }
    
    public int setVehicleClassification(int value){
        if(value==1 || value==4){
            this.vehicleClassification = value;
        }
        else{this.vehicleClassification = 3;
    }
    return vehicleClassification;
    }
    
    public String getVehicleClassiciation(int vClass){
        switch(vClass){
            case 1: return "Motorcycle";
            case 3: return "Light Moter Vehicle";
            case 4: return "Heavy Moter Vehicle";

        }
        return null;
    }

    
    //Equals
    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            Vehicle v = (Vehicle) obj;
            String otherVehiclePlateID;
            boolean result = this.plateID.equals(otherVehiclePlateID);
            return result;
        }
        return false;
    }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
