import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique() throws IOException {
        myWords.clear();
        myFreqs.clear();
        List<String> list = Files.readAllLines(Paths.get("src/testwordfreqs.txt"), StandardCharsets.UTF_8);
        String[] lines = list.toArray(new String[list.size()]);
        for (String line : lines){
            String[] words = line.split(" ");
            for (String word :words) {
                word=word.toLowerCase();
                if (myWords.contains(word)) {
                    myFreqs.set(myWords.indexOf(word), myFreqs.get(myWords.indexOf(word)) + 1);
                } else {
                    myWords.add(word);
                    myFreqs.add(1);
                }
            }
        }
        System.out.println("Number of unique words: "+myWords.size());
        for(int i=0;i<myFreqs.size();i++){
            System.out.println(myFreqs.get(i)+" "+myWords.get(i));
        }
    }
    public int findIndexOfMax(){
        int maxind=0,maxsofar=-1;
        for(int i=0;i<myFreqs.size();i++){
            if (maxsofar < myFreqs.get(i)) {
                maxind = i;
                maxsofar = myFreqs.get(i);
            }
        }
        return maxind;
    }

    public static void main(String[] args) throws IOException {
        WordFrequencies w = new WordFrequencies();
        w.findUnique();
        int ind = w.findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "+w.myWords.get(ind)+" "+ w.myFreqs.get(ind));
    }
}
