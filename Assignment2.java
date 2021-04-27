import java.util.HashMap;

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

class AlphabetChecker{
    boolean containsAllAlphabets(String textToCheck){
        //Time complexity is O(n) ; Space complexity is O(1)

        textToCheck = textToCheck.toLowerCase();
        HashMap<Character,Boolean> alphabetMap = new HashMap<>();

        //consider checking, only if characters are more than 25
        if(textToCheck.length()>25){
            for(char eachChar : textToCheck.toCharArray()){
                if(eachChar>='a' && eachChar<='z') {
                    alphabetMap.put(eachChar, true);
                    //if all the characters are found return the value as true
                    if (alphabetMap.size() == 26) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
