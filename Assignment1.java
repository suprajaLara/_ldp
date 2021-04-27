import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Assignment1 {
    public static void main(String[] args) {
        //Get the user home directory
        String pathOfHomeDirectory = System.getProperty("user.home");

        //Get the input from user, for regex, to search for all the files
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the regular expression"); // I used "(.txt)$|(.java)$"
        String regExp = sc.nextLine();

        //Run the findFiles method of PatternSearcher, to get all the files matching the pattern
        PatternSearcher patternSearcher = new PatternSearcher(pathOfHomeDirectory);
        patternSearcher.findFiles(regExp);
    }
}

class PatternSearcher{
    public String path;
    public File directoryPath;

    public PatternSearcher(String path){
        this.path=path;
    }

    public void findFiles(String fileNamePattern){
        //set directoryPath to latest directory we are searching in, to list all files under it
        this.directoryPath = new File(path);

        if(directoryPath.listFiles()!=null) {
            for (File file : directoryPath.listFiles()) {

                //if file matches the pattern, print to console
                if (isFileNameMatched(fileNamePattern, file.getName()) && !file.isDirectory()) {
                    System.out.println("MATCHING FILE FOUND: " + file.getAbsolutePath());
                }

                //if the path refers to directory, call findFiles for all the files under the directory
                if (file.isDirectory()) {
                    this.path = file.getAbsolutePath();
                    findFiles(fileNamePattern);
                }
            }
        }
    }

    private static boolean isFileNameMatched(String patternToMatch, String fileNameToMatch){
        return Pattern.compile(patternToMatch, Pattern.CASE_INSENSITIVE).matcher(fileNameToMatch).find();
    }
}