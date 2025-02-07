public class VehicleDriver {
    private String name;
    private Vehicle vehicle1;
    private Vehicle vehicle2;

    public VehicleDriver(String name){
        this.name = name;
        vehicle1=null;
        vehicle2=null;
    }
    
    public String getName(){
        return getName() +
        "\n 1. " + vehicle1.toString() +
        "\n 2. " + vehicle2.toString();
    }
    
    public boolean addVehicle(Vehicle suppliedVehicle){
        if (suppliedVehicle!=null){
            if(this.vehicle1==null){
                vehicle1 = suppliedVehicle;
                return true;
            }
            if ((this.vehicle2==null) && (!vehicle1.equals(suppliedVehicle))){
                this.vehicle2=suppliedVehicle;
                return true;
            }
        }
        return false;
    }
}