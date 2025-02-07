import java.util.Random;

public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private String plateID;
    private static int plateNumberCounter = 1;
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
    
    public Vehicle(int length, int breadth, int width, int classification){
        this (length, breadth, width);
        setVehicleClassification (classification);
    }
    
    
    private void setPlateID(){
        if(plateNumberCounter <0){
            this.plateID = "TAB0" + plateNumberCounter;
        
        }
        else
        {       
            this.plateID = "TAB"+ plateNumberCounter;
        
        }
        
        plateNumberCounter++;
        
    }
    
    public void setVehicleClassification(int classification){
        if(classification ==1 || classification == 4){
            vehicleClassification = classification;
        }else{
            vehicleClassification = 3;
        }
    }
    
    public String getPlateID(){
        return this.plateID;
    }
    
    public int getTankCapacity(){
        return tankCapacity;
    }
    
    public String getFuelType(){
        return fuelType;
    }
    
    public int getVehicleClassification(){
        return vehicleClassification;
    }
    
    public String getVehicleClassification(int classification){
        switch (classification){
            case 1: return "Motorcyle";
            case 2: return "Car";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehicle";
        }
        return null;
    }
    
    public boolean equals (Object obj){
        if (obj instanceof Vehicle){
            Vehicle v =  (Vehicle) obj;
            String otherVehiclePlateID = v.getPlateID();
            boolean  result = this.plateID.equals(otherVehiclePlateID);
            return result;
        }
        return false;
    }
    
    public String getVehicleClassificationDescription(){
        return getVehicleClassification(vehicleClassification);
    
    }
    
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() 
        + " FUEL TYPE: "+ getFuelType()
        + " PLATE ID: " + getPlateID()
        + " VEHICLE CLASSIFICATION: " +  getVehicleClassification()
        + " " + getVehicleClassification(this.getVehicleClassification());
      
    }
}