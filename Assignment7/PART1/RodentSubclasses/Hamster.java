package Assignment7.PART1.RodentSubclasses;

import Assignment7.PART1.Rodent;

public class Hamster extends Rodent {

    public Hamster(){
        System.out.println("Inside Hamster class");
    }
    @Override
    public String getRodentType() {
        return "Hamster";
    }

    @Override
    public String getWeightRange() {
        return "400-500 grams";
    }
}
