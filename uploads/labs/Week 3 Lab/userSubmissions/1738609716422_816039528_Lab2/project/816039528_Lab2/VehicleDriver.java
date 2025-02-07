public class VehicleDriver {
    private String name;
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    
    
    public VehicleDriver(String name){
        this.name = name;
    }
    
    public boolean addVehicle(Vehicle vehicle){
        if (vehicle1 == null || vehicle2 == null){
            if (vehicle1 == null){
                vehicle1 = vehicle;
            }
            else{
                vehicle2 = vehicle;
            }
            return true;
        }
        return false;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString(){
        return getName() +
        "\n 1. " + vehicle1.toString() +
        "\n 2. " + vehicle2.toString();
    }
    
}
