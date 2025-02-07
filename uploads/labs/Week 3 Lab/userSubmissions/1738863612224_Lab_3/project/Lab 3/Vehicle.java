public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private static int plateNumberCounter = 1;
    private String plateID;
    private int vehicleClassification;

    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity % 2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
            setPlateID();
            setVehicleClassification(3);
    }
    
    //overloaded constructor
    public Vehicle(int length, int breadth, int width, int vehicleClassification) {
       this(length,breadth,width);
       setVehicleClassification(vehicleClassification);
    }
    
    public String getFuelType(){
        return fuelType;
    }
    
    //accessor
    public String getPlateID() {
        return this.plateID;
    }
    public int getTankCapacity(){
        return tankCapacity;
    }
    
    //overloaded accessor
    public String getVehicleClassification (int value){
        switch(value) {
            case 1: return "Motorcycle";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehicle";
        }
        return null;
    }
    
    //mutator
    private int setPlateID() {
        if(this.plateNumberCounter < 10){
            this.plateID = "TAB0" + this.plateNumberCounter;
        }
        else{ 
            this.plateID="TAB" + this.plateNumberCounter;
        }
        this.plateNumberCounter++;
        return this.plateNumberCounter;
    }
    
     public void setVehicleClassification(int value) {
        if (value == 1 || value == 4) {
            this.vehicleClassification = value;
        } else {
            this.vehicleClassification = 3;
        }
    }    
    
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            String otherVehiclePlateID = v.getPlateID(); 
            return this.plateID.equals(otherVehiclePlateID);
        }
        return false;
    }
    
      public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() 
        + " FUEL TYPE: "+ getFuelType()
        + " PLATE ID: " + getPlateID()
        + " VEHICLE CLASSIFICATION: "+ getVehicleClassification(this.vehicleClassification);
    }
}
