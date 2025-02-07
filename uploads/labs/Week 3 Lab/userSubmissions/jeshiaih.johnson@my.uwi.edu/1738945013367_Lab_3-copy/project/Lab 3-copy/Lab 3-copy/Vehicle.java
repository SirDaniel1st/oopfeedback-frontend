public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    
    
    private static int PlateNumberCounter=1;
    private String PlateID;
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
        setPlateID():
    }
    public static int getRandomNumber(int min,int max){
        return(int) ((Math.random() * (max - min)) +min);
    }
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String getPlateID(){
      return this.PlateID;
    }
    
    private voidd setPlateID(){
        if(PlateNumberCounter<10){
            this.PlateID="TAB0"+PlateNumberCounter;
        }else
        this.PlateID="TAB"+PlateNumberCounter;
    }
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() + " FUEL TYPE: "+ getFuelType()+"PLATE ID"+ getPlateID();
    }
    public coid setVehicleClasification(int value){
        if(value==1 || value==4){
    }
    
}