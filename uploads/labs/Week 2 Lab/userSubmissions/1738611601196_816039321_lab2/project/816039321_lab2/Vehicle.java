public class Vehicle
{
    private int tankCapacity;
    private String fuelType;
    
    //constructor
    public Vehicle(int l, int w, int b)
    {
      this.tankCapacity = l * b * w;
      if (tankCapacity % 2 == 0) //even
      {
          this.fuelType = "gasoline";
      }
      else 
      {
          this.fuelType = "diesel";
      }
    }
    
    //accessors
    public int getTankCapacity()
    {
        return this.tankCapacity;
    }
    public String getFuelType()
    {
        return this.fuelType;
    }
    
    public String toString()
    {
        return ("VEHICLE TANK CAPACITY: " + this.tankCapacity + 
        " FUEL TYPE: " + this.fuelType);
    }
}