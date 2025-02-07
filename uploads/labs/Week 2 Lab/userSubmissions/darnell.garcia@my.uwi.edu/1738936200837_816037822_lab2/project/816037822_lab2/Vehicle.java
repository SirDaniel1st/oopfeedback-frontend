public class Vehicle {
    private int tankCapacity;
    private String fuelType;

    public Vehicle(int length, int width, int breadth){
        this.tankCapacity = length * width * breadth;
        if(this.tankCapacity % 2 == 0)
            this.fuelType = "gasoline";
        else
            this.fuelType = "diesel";
    }

    public String toString (){
        return(
                this.fuelType + " : " +
                String.format("%d", this.tankCapacity)
        );
    }

    public int getTankCapacity(){
        return this.tankCapacity;
    }

    public String getFuelType(){
        return this.fuelType;
    }

}
