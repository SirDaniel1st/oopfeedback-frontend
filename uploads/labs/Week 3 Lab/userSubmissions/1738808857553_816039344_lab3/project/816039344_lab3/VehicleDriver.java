public class VehicleDriver {
    private String name;
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    
    public VehicleDriver(String name) {
        this.name = name;
        this.vehicle1 = null;
        this.vehicle2 = null;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return false;
        }
        
        if (vehicle1 == null) {
            vehicle1 = vehicle;
            return true;
        } else if (vehicle2 == null && !vehicle1.equals(vehicle)) {
            vehicle2 = vehicle;
            return true;
        }
        
        return false;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder(name + "\n");
        if (vehicle1 != null) {
            result.append("1. ").append(vehicle1.toString()).append("\n");
        }
        if (vehicle2 != null) {
            result.append("2. ").append(vehicle2.toString());
        }
        return result.toString();
    }
}