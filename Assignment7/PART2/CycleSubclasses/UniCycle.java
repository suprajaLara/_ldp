package Assignment7.PART2.CycleSubclasses;

import Assignment7.PART2.Cycle;

public class UniCycle extends Cycle {
    public void balance(){
        System.out.println("Balancing Unicycle");
    }

    @Override
    public void ride(){
        System.out.println("Riding Unicycle");
    }
}
