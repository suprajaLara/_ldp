import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class GladLibMap {
    private HashMap<String,ArrayList<String>> myMap;
    private HashMap<String,Integer> wordsMap;
    private ArrayList<String> usedWordsList;

    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "src/datalong";

    public GladLibMap() throws IOException {
        myMap = new HashMap<String,ArrayList<String>>();
        wordsMap = new HashMap<String,Integer>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public GladLibMap(String source) throws IOException {
        myMap = new HashMap<String,ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) throws IOException {
        ArrayList<String> category = new ArrayList<String>(Arrays.asList("adjective",
                                                                        "noun",
                                                                        "color",
                                                                        "country",
                                                                        "name",
                                                                        "animal",
                                                                        "timeframe",
                                                                        "verb",
                                                                        "fruit"));
        for (String categoryName : category) {
            myMap.put(categoryName, readIt(source + "/" + categoryName + ".txt"));
        }
        usedWordsList = new ArrayList<String>();
    }

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if(myMap.containsKey(label)) {
            return randomFrom(myMap.get(label));
        }
        return "**UNKNOWN**";
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        if(usedWordsList.contains(sub)){
            while(usedWordsList.contains(sub)) {
                sub = getSubstitute(w.substring(first + 1, last));
            }
        }
        if(wordsMap.containsKey(w.substring(first+1,last))){
            wordsMap.put(w.substring(first+1,last),wordsMap.get(w.substring(first+1,last))+1);
        }
        else{
            wordsMap.put(w.substring(first+1,last),1);
        }
        usedWordsList.add(sub);

        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) throws IOException {
        String story = "";
        if (source.startsWith("http")) {
//            URLResource resource = new URLResource(source);
//            for(String word : resource.words()){
//                story = story + processWord(word) + " ";
//            }
        }
        else {
            List<String> resource = Files.readAllLines(Paths.get(source), StandardCharsets.UTF_8);
            String[] lines = resource.toArray(new String[resource.size()]);
            for(String line : lines) {
                String[] words = line.split(" ");
                for (String word : words) {
                    story = story + processWord(word) + " ";
                }
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
//            URLResource resource = new URLResource(source);
//            for(String line : resource.lines()){
//                list.add(line);
//            }
        }
        else {
            List<String> resource = Files.readAllLines(Paths.get(source), StandardCharsets.UTF_8);
            String[] lines = resource.toArray(new String[resource.size()]);
            for(String line : lines){
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory() throws IOException {
        usedWordsList.clear();
        System.out.println("\n");
        String story = fromTemplate("src/datalong/madtemplate2.txt");
        printOut(story, 60);
    }

    public int totalWordsInMap(){
        int count = 0;
        for(Map.Entry<String, ArrayList<String>> map : myMap.entrySet()){
            count+=map.getValue().size();
        }
        return count;
    }

    public int totalWordsConsidered(){
        int count = 0;
        for(Map.Entry<String, Integer> map : wordsMap.entrySet()){
            count+=map.getValue();
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        GladLibMap g = new GladLibMap();
        g.makeStory();
        System.out.println("\n\nNumber of replaced words: "+ g.usedWordsList.size());
        System.out.println("Total words available: "+ g.totalWordsInMap());
        System.out.println("Total words considered: "+ g.totalWordsConsidered());
    }

}
