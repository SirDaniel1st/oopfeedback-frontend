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
    
    public boolean addVehicle(Vehicle vehicle){
        if(vehicle == null)return false;
        if(vehicle1 == null){
            vehicle1 = vehicle;
            return true;
        }
        if(vehicle2 == null && !vehicle.equals(vehicle)){
            vehicle2 = vehicle;
            return true;
        }
        return false;
    }
    
    public String toString(){
        StringBuilder output = new StringBuilder("Driver: " + name + "\n");
        
        if(vehicle1 != null){
            output.append("1. ").append(vehicle1).append("\n");
        } else{
            output.append("1. No vehicle assigned\n");
        }
        if(vehicle2 != null){
            output.append("2. ").append(vehicle2).append("\n");
        } else{
            output.append("2. No vehicle assigned\n");
        }
        
        return output.toString();
    }
}
