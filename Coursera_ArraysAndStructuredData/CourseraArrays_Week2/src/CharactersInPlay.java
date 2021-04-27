import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> count;
    CharactersInPlay(){
        names=new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    public void update(String person){
        if(names.contains(person)){
            count.set(names.indexOf(person),count.get(names.indexOf(person)));
        }
        else{
            names.add(person);
            count.add(1);
        }
    }
    public void findAllCharacters() throws IOException {
        names.clear();count.clear();
        List<String> list = Files.readAllLines(Paths.get("src/macbethSmall.txt"), StandardCharsets.UTF_8);
        String[] lines = list.toArray(new String[list.size()]);
        for (String line : lines){
            String[] sublines = line.split("\\.");
            for (String subline : sublines){
                String[] words = subline.split(" ");
                String name = words[words.length-1];
                update(name.toLowerCase());
            }
        }
        int maxind=0,maxVal=-1;
        for (int i=0;i<names.size();i++){
//            System.out.println("Main character: "+names.get(i)+" "+"No. of speaking parts: "+count.get(i));
            if(maxVal<count.get(i)){
                maxind=i;
                maxVal=count.get(i);
            }
        }
        System.out.println("Main character: "+names.get(maxind)+" "+"No. of speaking parts: "+count.get(maxind));
    }

    public static void main(String[] args) throws IOException {
        CharactersInPlay c = new CharactersInPlay();
        c.findAllCharacters();
    }
}
