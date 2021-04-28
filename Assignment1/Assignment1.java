package Assignment1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Assignment1 {
    public static void main(String[] args) {
        //Get the user home directory
        String pathOfHomeDirectory = System.getProperty("user.home");

        //Get the input from user, for regex, to search for all the files
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the regular expression"); // I used "(.txt)$|(.java)$"
        String regExp = sc.nextLine();
        sc.close();

        //check if pattern is valid
        try {
            Pattern.compile(regExp);
        } catch (PatternSyntaxException exception) {
            System.err.println("Entered invalid expression: "+exception.getDescription());
            System.exit(1);
        }

        //Run the findFiles method of Assignment1.PatternSearcher, to get all the files matching the pattern
        PatternSearcher patternSearcher = new PatternSearcher(pathOfHomeDirectory);
        patternSearcher.findFiles(regExp);
    }
}
