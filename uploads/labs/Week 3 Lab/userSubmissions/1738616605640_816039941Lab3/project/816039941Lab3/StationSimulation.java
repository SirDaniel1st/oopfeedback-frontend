import java.util.ArrayList;
/*
public class StationSimulation{
    public static void main(String[] args){
        Fuelstation fStation=new Fuelstation();
        
        System.out.println(fStation);
        
        try{
            File dataFile=new File("Vehicles.txt");
            Scanner sc=new Scanner(dataFile);
            String carData="";
            
            while(sc.hasNextLine()){
                carData=sc.nextLine();
                Vehicle v=createVehicle(carData.split(","));
                serviceVehicle(v,fStation);
            }
        }catch(Exception e){
            System.out.println(">>>" +e.toString());
        }
    }
    
    public static Vehicle createVehicle(String[] dimensions){
        int l=Integer.parseInt(dimensions[0]);
        int b=Integer.parseInt(dimensions[1]);
        int w=Integer.parseInt(dimensions[2]);
        Vehicle v=new Vehicle(l,b,w);
        return v;
    }
    
    public static void serviceVehicle(Vehicle v, Fuelstation f){
        System.out.println(v);
        System.out.println(
        "Filled Up: " + f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
    }
} */
public class StationSimulation{
public static void main(String[] args){
    for(int i=0;i<10;i++){
        Vehicle v = new Vehicle(
         StationSimulation.getRandomNumber(1,20),
         StationSimulation.getRandomNumber(1,20),
         StationSimulation.getRandomNumber(1,20)
        );
        
        System.out.println(v);
    }
    
    
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    for(int i=0;i<10;i++){
        Vehicle v = new Vehicle(
         StationSimulation.getRandomNumber(1,20),
         StationSimulation.getRandomNumber(1,20),
         StationSimulation.getRandomNumber(1,20)
        );
    }
    ArrayList<VehicleDriver> drivers = new ArrayList<VehicleDriver>();
    String[] names = {"Lou","Sue","Drew","Koo","Murphy"};
    for(int i=0;i<10;i++){
        drivers.add(new VehicleDriver(names[i]));
    }
    for(VehicleDriver driver : drivers){
        int index = StationSimulation.getRandomNumber(0,10);
        Vehicle v = vehicles.get(index);
        driver.addVehicle(v);
        do{
            index = StationSimulation.getRandomNumber(0,10);
            v=vehicles.get(index);
        }while(driver.addVehicle(v));
        System.out.println(driver);
    }
}
    public static int getRandomNumber(int min, int max){
        return((int) (Math.random()*(max-min)) + min);
    }
}
