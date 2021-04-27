import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Part4 {
    void getUrls(String filename) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        Scanner s = new Scanner(fis);
        while (s.hasNextLine()){
            String line = s.nextLine();
            String lowercase = line.toLowerCase();
            int pos = lowercase.indexOf("youtube.com");
            if(pos!=-1){
                int start = line.lastIndexOf("\"",pos); // last index - searches upto pos
                int end = line.indexOf("\"",pos+1);  // first index - searches from pos+1
                System.out.println(line.substring(start+1,end));
            }
        }
        s.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Part4 p = new Part4();
        File file = new File("src/Computer Science Articles.txt");
        System.out.println(file.exists());
        p.getUrls("src/Computer Science Articles.txt");
    }
}
