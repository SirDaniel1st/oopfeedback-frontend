public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int length, int breadth, int width){
        this.tankCapacity=length+breadth+width;
        if(tankCapacity%2==0){
            fuelType="gasoline";
            //System.out.println("nah you tweakin fo this gasss");
        }else{
            fuelType="diesel";
            //System.out.println("this is diesel lowkey tho");
        }
        setPlateID();
        setVehicleClassification(3);
    }
    
    public int getTankCapacity( ){return this.tankCapacity;}
    public String getFuelType( ){return this.fuelType;}
    


public int plateNumberCounter = 1;
    private String plateID;
    private int vehicleClassification;
    
    public String getPlateID(){return this.plateID;}
    
    public int getVehicleClassification(){return this.vehicleClassification;}
    
    public String getVehicleClassification(int vehicleClassification){
        switch(vehicleClassification){
            case 1: return "Motorcycle";
            case 2: return "Light Motor Vehicle";
            case 3: return "Heavy Motor Vehicle";
        }
        return null;
    }
    
       private void setPlateID(){
           if(plateNumberCounter<10){
        String s = "TAB";
        String plateID = s + plateNumberCounter;
        plateNumberCounter = plateNumberCounter + 1;
    }
}

public void setVehicleClassification(int value){
    if(value ==1 || value ==4){
        vehicleClassification=value;
    }
    else vehicleClassification=3;
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
    public String toString(){
        return ("VEHICLE TANK CAPACITY:" + getTankCapacity()+
        "FUEL TYPE: " + getFuelType() + "PLATE ID:" + getPlateID()
        + "CLASS:  " + getVehicleClassification(this.vehicleClassification));
    }
}