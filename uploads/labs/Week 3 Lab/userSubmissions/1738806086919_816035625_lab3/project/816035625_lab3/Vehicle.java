public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private static int plateNumberCounter=1;
    private String plateID;
    private int vehicleClassification;
    
    
    //Constructors
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
    
    //Setters
    private void setPlateID(){
        if(plateNumberCounter >9){
            plateID = "Tab" + plateNumberCounter;
        }
        else{
            plateID = "Tab0" + plateNumberCounter;
        }
        plateNumberCounter++;
    }
    private void setVehicleClassification(int vehicleClassification){
        switch(vehicleClassification){
            case 1:
            case 3:
            case 4:
                this.vehicleClassification = vehicleClassification;
                break;
            default:
                this.vehicleClassification = 3;
                //System.out.println("Error: Invalid vehicle classification given \nDefualted to 3");
                
        }
        this.vehicleClassification = vehicleClassification;
    }
    private void setPlateId(){
        this.vehicleClassification = 3;
    }
    
    //Getters
    public int getVehicleClassification(){
        return vehicleClassification;
    }
    public String getVehicleClassification(int vehicleClassification){
        switch(vehicleClassification){
            case 1:
                return "Motorcycle";
            case 3:
                return "Light motor vehicle";
            case 4:
                return "Heavy motor vehicle";
            default:
                return "Error: Unreachable";
        }
    }
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String getPlateID(){
        return this.plateID;
    }
    
    
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() 
        + " FUEL TYPE: "+ getFuelType()
        + " PLATE ID: " + getPlateID()
        + " CLASSFICATION: " + getVehicleClassification(this.vehicleClassification);
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