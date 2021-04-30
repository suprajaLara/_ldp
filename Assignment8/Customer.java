package Assignment8;

public class Customer {
    String name;
    int bill;
    int noOfPeopleToDivideBill;
    int eachPart;
    public Customer(String name, int bill, int noOfPeopleToDivideBill){
        try{
            if(name == null || "".equals(name)){
                throw new EmptyNameException("Customer name cannot be empty");
            }
            if(bill==0){
                throw new BillZeroException("Bill cannot be zero");
            }
            //throws divide by zero exception, if denominator is zero
            this.eachPart = bill/noOfPeopleToDivideBill;
        }
        catch (EmptyNameException | BillZeroException | ArithmeticException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Customer Instance creation is called");
        }
    }
}
