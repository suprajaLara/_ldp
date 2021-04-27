import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GladLib {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private ArrayList<String> usedWordsList;

    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "src/datalong";

    public GladLib() throws IOException {
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public GladLib(String source) throws IOException {
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) throws IOException {
        adjectiveList= readIt(source+"/adjective.txt");
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");
        verbList = readIt(source+"/timeframe.txt");
        fruitList = readIt(source+"/timeframe.txt");
        usedWordsList = new ArrayList<String>();
    }

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }
        if (label.equals("verb")){
            return randomFrom(verbList);
        }
        if (label.equals("fruit")){
            return randomFrom(fruitList);
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
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
        else {List<String> resource = Files.readAllLines(Paths.get(source), StandardCharsets.UTF_8);
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

    public static void main(String[] args) throws IOException {
        GladLib g = new GladLib();
        g.makeStory();
        System.out.println("\n\nNumber of replaced words: "+ g.usedWordsList.size());
    }

}