package Assignment7;

import Assignment7.PART1.Rodent;
import Assignment7.PART1.RodentSubclasses.Gerbil;
import Assignment7.PART1.RodentSubclasses.Hamster;
import Assignment7.PART1.RodentSubclasses.Mouse;
import Assignment7.PART2.Cycle;
import Assignment7.PART2.CycleSubclasses.BiCycle;
import Assignment7.PART2.CycleSubclasses.TriCycle;
import Assignment7.PART2.CycleSubclasses.UniCycle;
import Assignment7.PART3.ChildClass;
import Assignment7.PART3.MainClass;
import Assignment7.PART4.CycleFactory;
import Assignment7.PART5.FirstOuterClass;
import Assignment7.PART5.SecondOuterClass;

public class Assignment7 {

    public static void main(String[] args) {

        //PART-1
        Rodent[] rodents = new Rodent[3];

        rodents[0] = new Mouse();
        rodents[1] = new Gerbil();
        rodents[2] = new Hamster();

        for(Rodent rodent : rodents){
            System.out.println("Rodent type : "+rodent.getRodentType());
            System.out.println("Rodent has teeth : "+rodent.haveTeeth());
            System.out.println("Weight range of rodent : "+rodent.getWeightRange());
        }

        System.out.println();

        //PART-2
        Cycle[] cycles = new Cycle[3];
        cycles[0] = new UniCycle();
        cycles[1] = new BiCycle();
        cycles[2] = new TriCycle();

        // COMPILE TIME ERROR CYCLE HAS NO METHOD balance
        /*for(Cycle cycle : cycles){
            cycle.balance();
        }*/

        UniCycle uniCycle = (UniCycle) cycles[0];
        uniCycle.balance();

        BiCycle biCycle = (BiCycle) cycles[1];
        biCycle.balance();

        System.out.println();

        //PART-3
        MainClass mainClass = new MainClass();
        ChildClass childClass = new ChildClass();
        mainClass.meth1(childClass);
        mainClass.meth2(childClass);
        mainClass.meth3(childClass);
        mainClass.meth4(childClass);

        System.out.println();

        //PART-4
        new CycleFactory().getCycleObject("unicycle").noOfWheels();
        new CycleFactory().getCycleObject("bicycle").noOfWheels();
        new CycleFactory().getCycleObject("tricycle").noOfWheels();

        System.out.println();

        //PART-5
        FirstOuterClass.FirstInnerClass firstOutToIn =
                new FirstOuterClass().new FirstInnerClass("hello first class");

        firstOutToIn.method();

        FirstOuterClass.FirstInnerClass parentRefSecondOutToIn =
                new SecondOuterClass().new SecondInnerClass("hello second class");

        parentRefSecondOutToIn.method();

    }
}
