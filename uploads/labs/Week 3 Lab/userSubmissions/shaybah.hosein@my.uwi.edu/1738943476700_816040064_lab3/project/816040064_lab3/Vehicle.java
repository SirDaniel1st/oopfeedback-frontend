public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private static int plateNumberCounter = 1;
    private String plateID;
    private int vehicleClass;
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        setPlateID();
        setVehicleClass(3);
    }
    
    //Overloaded Constructor
    public Vehicle(int l, int b, int w, int vehicleClass){
        this(l, b, w);
        setVehicleClass(vehicleClass);
    }
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String toString(){
        return (
        "VEHICLE TANK CAPACITY: "+ getTankCapacity() + 
        " FUEL TYPE: "+ getFuelType() + 
        " PLATE ID:" + getPlateID()+ 
        " VEHICLE CLASS:" + getVehicleClass()+
        " : " + getVehicleClass(this.vehicleClass)
        );
    }
    public String getPlateID(){return this.plateID;}
    public int getPlateNumberCounter(){return this.plateNumberCounter;}
    public int getVehicleClass(){return this.vehicleClass;}
    public String getVehicleClass(int vehicleClass){
        switch(vehicleClass){
            case 1: return "MotorCyle";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehivle";
        }
        return null;
    }
    private void setPlateID(){
        if(plateNumberCounter < 10){
            this.plateID = "TAB0" + this.plateNumberCounter;
        }else{
            this.plateID = "TAB"+this.plateNumberCounter;
        }
    }
    
    public void setVehicleClass(int value){
        if(value == 1 || value == 4){
            this.vehicleClass = value;
        }else{
            this.vehicleClass = 3;
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