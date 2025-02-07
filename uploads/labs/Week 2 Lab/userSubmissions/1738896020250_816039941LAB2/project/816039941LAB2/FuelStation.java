
public class FuelStation{
        
        private String fuelType ;
        private double fuelVolume ;
        private double fuelRate  ;
        private double fuelSales ;
        //no-argument constructor
        public FuelStation(){
            fuelType = "gasoline";
            fuelVolume = 75000;
            fuelRate = 2.0;
            fuelSales = 0;
        }
        //accessors
        public String getfuelType() {return fuelType;}
        public double getfuelVolume(){return fuelVolume;}
        public double getfuelRate(){return fuelRate;}
        public double getfuelSales(){return fuelSales;}
        
        //Mutators
    public void setFuel(String fuelType){
        if(fuelType==null);
        this.fuelType="gasoline";
    }
    public void setVolume(double fuelVolume){
        if(fuelVolume==0);
        this.fuelVolume=75000;
    }
    public void setRate(double fuelRate){
        if(fuelRate==0);
        this.fuelRate=2;
    }
    public void setSales(double fuelSales){
        if(fuelSales==0);
        this.fuelSales=0;
    }
        //toString
        public String toString(){
            return ("FUEL:" + fuelType + "VOL: " + fuelVolume + "PRICE PER L:$" + String.format("%.02f",fuelRate) + "SALES:$" +  String.format("%.02f",fuelSales));
        }
        
        private boolean sellFuel(double volume){
            if(fuelVolume > volume){
                fuelVolume = fuelVolume = volume;
                fuelSales = volume * fuelRate;
                return true;
            }
            return false;
        }
        
        public boolean canDispenseFuelType(String fuelType){
            if(fuelType != null){
                return fuelType.equals(this.fuelType);
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