package Assignment5.supraja.assignment.data;

public class DataMemberInitializer {
    int intVariable;
    char charVariable;
    public void printDataMembers(){
        System.out.println("integer variable: "+intVariable+" character variable: "+charVariable);
    }
    public void printLocalVariables(){
        int intVariable;
        char charVariable;
        //local variables must be initialized, before using them.
        //Produces error when used before initialization.
        //System.out.println("integer variable: "+intVariable+" character variable: "+charVariable);
    }
}
