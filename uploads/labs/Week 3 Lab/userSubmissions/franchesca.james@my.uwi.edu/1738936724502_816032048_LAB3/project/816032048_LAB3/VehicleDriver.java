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
        return (
        getName() + 
        "\n 1. " + vehicle1.toString() +
        "\n 2. " + vehicle2.toString()
        );
    }
    
    public boolean addVehicle(Vehicle v){
        if(v != null){
            if(this.vehicle1 == null){
                this.vehicle1 = v;
                return true;
            }
            //checking if vehicle2 has been set and v1 is not the same supplied vehicle
            if((this.vehicle2 == null) && !this.vehicle1.equals(v)){
                this.vehicle2 = v;
                return true;
            }
        }
        return false;
    }
}
