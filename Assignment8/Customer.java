package Assignment8;

public class Customer {
    String name;
    int bill;
    String mobileNo;
    public Customer(String name, int bill, String mobileNo){
        try{
            if(name == null || "".equals(name)){
                throw new EmptyNameException("Customer name cannot be empty");
            }
            if(bill==0){
                throw new BillZeroException("Bill cannot be zero");
            }
            if(mobileNo==null || mobileNo.length()!=10 ||
                    !mobileNo.chars().allMatch( Character::isDigit )){
                throw new MobileNumberFormatException("Mobile number should be 10-digit numeric string");
            }
        }
        catch (EmptyNameException | BillZeroException | MobileNumberFormatException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Customer Instance creation is called");
        }
    }
}
