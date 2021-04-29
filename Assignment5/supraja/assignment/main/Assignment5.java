package Assignment5.supraja.assignment.main;

import Assignment5.supraja.assignment.data.DataMemberInitializer;
import Assignment5.supraja.assignment.singleton.StringMemberInitializer;

//PART-3
public class Assignment5 {
    public static void main(String[] args) {

        //PART-1
        DataMemberInitializer dataMemberInitializer = new DataMemberInitializer();
        dataMemberInitializer.printDataMembers();
        //Below line produces error
        //dataMemberInitializer.printLocalVariables();

        //PART-2
        System.out.println(StringMemberInitializer.initializeStringMember("zemoso").getMember());
        System.out.println(StringMemberInitializer.initializeStringMember("intern").getMember());
    }
}
