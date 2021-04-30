package Assignment7.PART4;

public class CycleFactory {
    public Cycle getCycleObject(String type){
        if(type.equalsIgnoreCase("UNICYCLE")){
            return new Unicycle();
        }
        else if(type.equalsIgnoreCase("BICYCLE")){
            return new Bicycle();
        }
        else if(type.equalsIgnoreCase("TRICYCLE")){
            return new Tricycle();
        }
        else{
            return null;
        }
    }
}
