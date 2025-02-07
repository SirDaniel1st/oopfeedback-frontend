public class VehicleDriver {
    private String name;
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    
    public VehicleDriver(String name){
        this.name = name;
        this.vehicle1 = null;
        this.vehicle2 = null;
        
    }
    
    public boolean addVehicle(Vehicle v){
        if (v== null){
            return false;
        }
        
        if (vehicle1== null){
            vehicle1 = v;
            return true;
        }else if (vehicle2== null && !vehicle1.equals(v)){
            vehicle2 = v;
            return true;
        }
        
        return false;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString(){
        String result =name + "\n 1. ";
        
        if (vehicle1 != null){
            result += vehicle1.toString();
        }else{
            result += "No vehicle assigned";
        }
        
        result += "\n 2.";
        
        if (vehicle2 != null){
            result += vehicle2.toString();
        }else{
            result += "No vehicle assigned";
        }
        
        return result;
    }
}
