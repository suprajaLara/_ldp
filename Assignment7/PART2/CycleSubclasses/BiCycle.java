package Assignment7.PART2.CycleSubclasses;

import Assignment7.PART2.Cycle;

public class BiCycle extends Cycle {
    public void balance(){
        System.out.println("Balancing Bicycle");
    }

    @Override
    public void ride(){
        System.out.println("Riding Bicycle");
    }
}
