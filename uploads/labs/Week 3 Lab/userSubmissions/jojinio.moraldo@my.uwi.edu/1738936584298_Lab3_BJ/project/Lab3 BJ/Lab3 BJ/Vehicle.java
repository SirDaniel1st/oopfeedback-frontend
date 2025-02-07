public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    
    //----NEW CODE
    private static int plateNumberCounter=1;
    private String plateID;
    
    
    
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        setPlateID();
        setVehicleClassification(3);
    }
    
    //overloaded constructor
    public Vehicle(int length, int bredth, int width, int vehicleClass){
        this(length, bredth,width);
        setVehicleClassification(vehicleClass);
    }
    
    /*this.attribute-> this instance of an at attribute
    this.method()-> the method within this class
    this()-> the constructor in itself */
    public int getTankCapacity(){
        return tankCapacity;
    }
    
    public String getFuelType(){
        return fuelType;
    }
    public String toString(){
        return(
        "VEHICLE TANK CAPACITY: "+ getTankCapacity() + " FUEL TYPE: "+ getFuelType();
        "FUEL TYPE: "+ getFuelType()+
        "PLATEID:"+ getPlateID()+
        "VEHICLE CLASSIFCICATION:"+ vehicleClassification()+" ";
    }
    
    //Accessors
    public String getPlateID(){
        return this.plateID;
    }
    public int getVehicleClassification(){
        return this.vehicleClassification;
    }
    
    public String getVehicleClassification(int vClass){
        switch(vClass){
            case 1: return "Motorcysle";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehicle";
        }
    }
    
    //Mutator
    private void setPlateID(){
        if(plateNumberCounter<10){
            this.plateID= "TAB0"+plateNumberCounter;
        }
        else{
            this.plateID="TAB"+plateNumberCounter;
        }
        plateNumberCounter++;
    }
    
    public void setVehicleClassification(int value){
        if (value==1 || value==4){
            this.vehicleClassification=value;
        }
        else{
            this.vehicleClassification=3;
        }
    }
    
    //Equals
    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            //some thing
            Vehicle v=( Vehicle) obj;
            String otherVehiclePlateID= v.getPlateID();
            boolean results= this.plateID.equals(otherVehiclePlateID);
            return results;
        }
        return false;
        
    }
}