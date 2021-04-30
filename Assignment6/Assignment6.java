package Assignment6;

import java.util.ArrayList;
import java.util.List;

public class Assignment6 {
    public static void main(String[] args) {
        //PART-1
        int nVampires = 100;
        findVampires(nVampires);

        //PART-2
        ConstructorChain constructorChain = new ConstructorChain("Supraja");
        System.out.println("ConstructorChain data member: "+constructorChain.name);

        //PART-3
        PrintMessage[] printMessages = new PrintMessage[4];

        //PART-4
        for(int index=0;index<printMessages.length;index++){
            printMessages[index] = new PrintMessage("hello "+(index+1));
        }
    }

    private static void findVampires(int noOfVampires) {
        int i = 0, numInRange= 10, end = 100;

        while(i < noOfVampires && numInRange<end){
            if(isVampire(numInRange)) {
                i++;
            }
            numInRange++;

            // ONLY BETWEEN ODD TO EVEN POWER OF 10(LIKE 10 TO 100, 1000 TO 10000)
            if(numInRange == end){
                end = numInRange*(10*10);
                numInRange = numInRange*(10);
            }
        }
    }

    private static boolean isVampire(long num){
        List<String> permutations = getPermutations(String.valueOf(num));

        for(String number : permutations){
            if (Long.parseLong(number.substring(0,number.length()/2))*
                    Long.parseLong(number.substring(number.length()/2))==num){
                //PRINTING VAMPIRE NUMBER, WHEN FOUND
                System.out.println(num +" : "+ number.substring(0, number.length() / 2) +" * "+number.substring(number.length()/2));
                return true;
            }
        }
        return false;
    }

    private static List<String> getPermutations(String str){
        if(str.length()==0){
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        char ch = str.charAt(0);

        String restStr = str.substring(1);

        List<String> prevRes = getPermutations(restStr);

        List<String> resultList = new ArrayList<>();
        for(String s : prevRes){
            for(int i=0;i<=s.length();i++){
                String generated = s.substring(0,i)+ch+s.substring(i);
                if(!resultList.contains(generated)){
                    resultList.add(generated);
                }
            }
        }
        return resultList;
    }
}

