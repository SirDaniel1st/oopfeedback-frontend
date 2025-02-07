import java.util.Random;

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
    }
    
    //overloaded constructor
    public Vehicle(int length, int breadth, int width, int vehicleClass){
        this(length, breadth,width);
        setvehicleClassification(vehicleClass);
    }
    
    //this.attribute refers to instance of an attribute and this.method refers to method with this class and this() is constructoritself
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String getPlateID(){
        return this.plateID;
    }
    public int getvehicleClassification(){
        return this.vehicleClassification;
    }
    public String getvehicleClassification(int vClass){
        switch(vClass){
            case 1: return "Motorcycle";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehicle";
        }
        return null;
    }
    
    public String toString(){
        return( 
        "VEHICLE TANK CAPACITY: "+ getTankCapacity() + 
        " FUEL TYPE: "+ getFuelType() + 
        " PLATE ID: " + getPlateID() +
        " VEHICLE CLASSIFICATION: " + getvehicleClassification() +
        " : " + getvehicleClassification(this.vehicleClassification)
        );
    }
    
    private void setPlateID(){       
        if(plateNumberCounter < 10){
            this.plateID = "TAB0" + plateNumberCounter;
        }
        else{
            this.plateID = "TAB" + plateNumberCounter;
        }
        plateNumberCounter++;
    }
    
    public void setvehicleClassification(int value){
        if(value == 1|| value==4){
            this.vehicleClassification = value;
        }
        else{
            this.vehicleClassification = 3;
        }
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Vehicle){
            Vehicle v = (Vehicle) obj;
            String  otherVehiclePlateID = v.getPlateID();
            boolean result = this.plateID.equals(otherVehiclePlateID);
            return result;
        }
        return false;
    }
}