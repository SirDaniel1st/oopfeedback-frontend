public class VehicleDriver {
    private String name;
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    
    public VehicleDriver(String name){
        this.name = name;
        vehicle1 = null;
        vehicle2 = null;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString(){
        return this.getName() + 
        "\n 1. " + vehicle1.toString() +
        "\n 2. " + vehicle2.toString();
    }
    
    public boolean addVehicle(Vehicle v){
        if(v == null) return false;
        
        if(this.vehicle1 == null){
            this.vehicle1 = v;
            return true;
        }
        
        if(this.vehicle2 == null && !(v.equals(this.vehicle1)) ){
            this.vehicle2 = v;
            return true;
        }
        return false;
    }
}
