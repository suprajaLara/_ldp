package Assignment2;

import java.util.HashMap;

public class AlphabetChecker {
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
