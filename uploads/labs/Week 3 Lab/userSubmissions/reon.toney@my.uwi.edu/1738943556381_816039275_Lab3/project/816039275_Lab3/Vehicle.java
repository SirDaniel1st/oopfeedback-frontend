public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    private static int plateNumberCounter =1;
    private String plateID;
    private int vehicleClassification;
    
    private void setPlateID(){
        if(plateNumberCounter  < 10){
            this.plateID = "TAB0" + this.plateNumberCounter;
        }
        else{this.plateID = "TAB" + this.plateNumberCounter;}
        plateNumberCounter++;
    }
    
    public String getPlateID(){return this.plateID;}
    public int getVehicleClassification(){return this. VehicleClassification;}
    public String getVehicleClassification( int vehicleClassification){
        switch(vehicleClassification){
            case 1: return "Motorcycle";
            case 3: return "Light Motor Vehicle";
            case 4: return "Heavy Motor Vehicle";
        }
        reutrn null;
    }
    
    public Vehicle(int l, int w ,int b){
        this.tankCapacity = l * w * b;
        if(this.tankCapacity%2==0){
            this.fuelType="gasoline";
        }
        else{
            this.fuelType ="diesel";
        }
        setPlateID();
        setVehicleClassification(3);
    }
    
    public Vehicle(int l, int w ,int b, int vehicleClassification){
        this(l,b,w);
        setVehicleClassification(vehicleClassification);
    }
    
    public int getTankCapacity(){return this.tankCapacity;}
    public String getFuelType(){return this.fuelType;}
    
    public String toString(){
        return ("VEHICLE TANK CAPACITY: "+this.tankCapacity+
        "FUEL TYPE: "+this.fuelType+
         "PLATE ID: "+getPlateID()+ 
         getVehicleClassification);
    }
    public void setVehicleClassification(int value){
        if(value ==1 ||value ==4){
            this.vehicleClassification = value;
        }
        else{
            this.vehicleClassification= 3;    
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