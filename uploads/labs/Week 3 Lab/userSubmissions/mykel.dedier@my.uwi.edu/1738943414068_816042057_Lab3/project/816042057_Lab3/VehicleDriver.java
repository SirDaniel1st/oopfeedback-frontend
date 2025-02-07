public class VehicleDriver {
    private String name;
    private Vehicle v1;
    private Vehicle v2;
    
    public VehicleDriver(String name){
        this.name = name;
        this.v1 = null;
        this. v2 = null;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean addVehicle (Vehicle v) {
        if (v != null) {
            if (v1 == null) {
                v1 = v;
                return true;
            }
            else {
                if ((v2 == null) && !v1.equals(v)) {
                    v2 = v;
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public String toString() {
        return getName() +
        "\n 1. " + v1.toString() +
        "\n 2. " + v2.toString();
    }
}
