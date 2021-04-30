package Assignment7.PART1.RodentSubclasses;

import Assignment7.PART1.Rodent;

public class Mouse extends Rodent {
    public Mouse(){
        System.out.println("Inside Mouse class");
    }

    @Override
    public String getRodentType(){
        return "Mouse";
    }

    @Override
    public String getWeightRange() {
        return "150-350 grams";
    }
}
