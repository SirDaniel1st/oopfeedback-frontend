public class FuelStation{
    
    // define the attributes
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    // createing a constructor : use the key word public folllowed by the class name,() and {} 
    //public classname(){
        
        public FuelStation(){
            this.fuelType = "gasoline";// used when refering to an attribute
            this.fuelVolume=7500;
            this.fuelRate=2.00;
            this.fuelSales=0.0;
        }
        //Accessors(getters)- allow the object to display oor return its attribute values
        //Mutators(setters)- these are method that allow other objects or classes to set values to private attribute
        
        public String getFuelType(){return this.fuelType;}
        public double getFuelVolume(){return this.fuelVolume;}
        public double getFuelRate(){return this.fuelRate;}
        public double getFuelSales(){return this.fuelSales;}
      //question 1 part d  
        public String toString(){
            return(
            "FUEL : " +this.fuelType+
            "VOL :" +String.format("%.01f", this.fuelVolume)+
            "L PRICE PER L : "+String.format("%.02f",this.fuelRate)+
            "SALES : "+ String.format ("%.02f", this.fuelSales)
            );
        }
        
        private boolean sellFuel (double volume){ // private because we only want it accesssable in this class as changes are made to the fuel station
         if (this.fuelVolume > volume){
             this.fuelVolume-=volume;
             this.fuelSales+=(volume+this.fuelRate);
             return true;
         }
         
         return false;
        }
        
        public boolean canDispenseFuelType(String fuelType){
            if(fuelType!=null){
                return fuelType.equals(getFuelType()/*this.fuelType*/ );
                //the equals method is used instead of == because to strings cant be compared like this
            }
            return false;
        }
            
        public boolean dispense(String fuelType, double volume){
          if(canDispenseFuelType(fuelType)){
              return sellFuel(volume);
            }
            return false;
        }
        
}


            
        
