import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordLengths {
    void countWordLengths(String[] files, int[] counts){
        for(String line : files) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() < counts.length) {
                    int i;
                    for(i=0;i<word.length();i++){
                        if(Character.isAlphabetic(word.charAt(i))){
                            word = word.substring(i);
                            break;
                        }
                    }
                    if(i==word.length())continue;;
                    for(i=word.length()-1;i>=0;i--){
                        if(!Character.isLetter(word.charAt(i))){
                            word = word.substring(0,i);
                        }
                        else{
                            break;
                        }
                    }
                    counts[word.length()]++;
                }
            }
        }
        for(int i=0;i<counts.length;i++){
            System.out.println("counts["+i+"] : "+counts[i]);
        }
        System.out.println("most common words are of length: "+indexOfMax(counts));
    }
    int indexOfMax(int[] arr){
        int max = -1,maxin=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                maxin=i;
            }
        }
        return maxin;
    }
    public static void main(String[] args) throws IOException {
        WordLengths w = new WordLengths();
        List<String> list = Files.readAllLines(Paths.get("src/manywords.txt"), StandardCharsets.UTF_8);
        String[] lines = list.toArray(new String[list.size()]);
        w.countWordLengths(lines, new int[9]);
    }
}
