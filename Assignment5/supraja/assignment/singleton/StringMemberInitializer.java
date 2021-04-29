package Assignment5.supraja.assignment.singleton;

public class StringMemberInitializer {
    String stringMember;

    public StringMemberInitializer(String member){
        this.stringMember = member;
    }
    public static StringMemberInitializer initializeStringMember(String member){
       return new StringMemberInitializer(member);
    }

    public String getMember() {
        return stringMember;
    }
}
