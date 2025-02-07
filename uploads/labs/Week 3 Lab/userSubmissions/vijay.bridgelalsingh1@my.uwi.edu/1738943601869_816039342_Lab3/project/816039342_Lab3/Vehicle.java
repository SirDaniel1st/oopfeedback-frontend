public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private String plateID;
    private static int plateNumberCounter = 1;
    private int vehicleClassification;
    
    private void setPlateID(){
        if(plateNumberCounter < 10){
            this.plateID = "TAB0" + this.plateNumberCounter;
        }
        else{
            this.plateID="TAB"+this.plateNumberCounter;
        }
        plateNumberCounter++;
    }
    
    public void setVehicleClassification(int value){
        if(value ==1 || value ==4){
            this.vehicleClassification = value;
        }
        else{
            this.vehicleClassification = 3;
        }
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            Vehicle v = (Vehicle) obj;
            String otherVehiclePlateID = v.getVehiclePlate();
            
            
            
        }
    }
    
    public String getPlateID(){return this.plateID;}
    public int getPlateNumberCounter(){return this.plateNumberCounter;}
    public int getVehicleClassification(){return this.vehicleClassification;}
    public String getVehicleClassification(int vehicleClassification){
        switch(vehicleClassification){
            case 1:return "Motorcycle";
            case 2:return "Light Motor Vehicle";
            case 3:return "Heavy Motor Vehicle";
        }
        return null;
    }
    
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        setPlateID();
        setVehicleClassification(3);
    }
    
    public Vehicle(int l, int b, int w, int vehicleClassification){
        this(l,b,w);
        setVehicleClassification(vehicleClassification);
    }
    
    public int getTankCapacity(){
        return tankCapacity;
    }
    
    public String getFuelType(){
        return fuelType;
    }
    
    public String toString(){
        return 
            "VEHICLE TANK CAPACITY: "+ getTankCapacity() + 
            " FUEL TYPE: "+ getFuelType() +
            " PLATE ID: "+ getPlateID() +
            " VEHICLE CLASSIFICATION:" + getVehicleClassification();
    }
    
}