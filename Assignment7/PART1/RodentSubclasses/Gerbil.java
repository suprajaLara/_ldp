package Assignment7.PART1.RodentSubclasses;

import Assignment7.PART1.Rodent;

public class Gerbil extends Rodent {

    public Gerbil(){
        System.out.println("Inside Gerbil class");
    }

    @Override
    public String getRodentType() {
        return "Gerbil";
    }

    @Override
    public String getWeightRange() {
        return "100-180 grams";
    }
}
