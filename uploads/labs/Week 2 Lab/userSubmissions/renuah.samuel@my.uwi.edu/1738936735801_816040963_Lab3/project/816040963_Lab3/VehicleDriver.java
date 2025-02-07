public class VehicleDriver {
    private String name;
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    
    public VehicleDriver(String name){
       this.name = name;
       this.vehicle1 = null;
       this.vehicle2 = null;
    }
    
    public String getName(){
        return name;
    }
    
    public Vehicle getVehicle1 (){
        return vehicle1;
    }
    
    public Vehicle getVehicle2 (){
        return vehicle2;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setVehicle1 (Vehicle vehicle1){
        this.vehicle1 = vehicle1;
    }
    
    public void setVehicle2 (Vehicle vehicle2){
        this.vehicle2 = vehicle2;
    }
    
    public boolean addVehicle(Vehicle vehicle){
        if (vehicle == null){
            return false;
        }
        
        if (vehicle.equals(vehicle1) || vehicle.equals(vehicle2)){
            return false;
        }
        
        if (vehicle1 == null){
            vehicle1 = vehicle;
            return true;
        }
        
        if (vehicle2 == null){
            vehicle2 = vehicle;
            return true;
        }
        return false;
    }
    
    
    public String toString(){
        return getName() + 
        "\n 1." + vehicle1.toString() +
        "\n 2." + vehicle2.toString();
    
    }
    /*public String toString(){
        String vehicle1Info, vehicle2Info;
        
        if (vehicle1 != null){
            vehicle1Info = vehicle1.toString();
        }else{
            vehicle1Info = "No vehicle assigned";
        }
        
        if(vehicle2 != null){
            vehicle2Info = vehicle2.toString();
        }else{
            vehicle2Info = "No vehicle assigned";
        }
        return getName() + "\n 1. " + vehicle1Info.toString() + "\n 2. " + vehicle2Info.toString();
    }*/
}