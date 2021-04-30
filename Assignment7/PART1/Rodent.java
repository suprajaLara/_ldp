package Assignment7.PART1;

public abstract class Rodent {
    public Rodent(){
        System.out.println("Inside Rodent class");
    }
    public boolean haveTeeth(){
        return true;
    }
    public abstract String getRodentType();
    public abstract String getWeightRange();
}
