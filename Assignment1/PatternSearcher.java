package Assignment1;

import java.io.File;
import java.util.regex.Pattern;

public class PatternSearcher {
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

    private static boolean isFileNameMatched (String patternToMatch, String fileNameToMatch){
            return Pattern.compile(patternToMatch, Pattern.CASE_INSENSITIVE).matcher(fileNameToMatch).find();
    }

}
