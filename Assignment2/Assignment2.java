package Assignment2;

public class Assignment2 {
    public static void main(String[] args) {
        AlphabetChecker alphabetChecker = new AlphabetChecker();
        String testString1 = "Hello World";
        String testString2 = "The quick brown fox jumps over the lazy dog";
        String testString3 = "1234567891011121314151617181920";
        System.out.println(testString1+" - "+alphabetChecker.containsAllAlphabets(testString1));
        System.out.println(testString2+" - "+alphabetChecker.containsAllAlphabets(testString2));
        System.out.println(testString3+" - "+alphabetChecker.containsAllAlphabets(testString3));
    }
}