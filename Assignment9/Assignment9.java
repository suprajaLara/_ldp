package Assignment9;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Assignment9 {
    public static void main(String[] args) {
        System.out.println("enter the sentence: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Pattern matching returns: "+
                Pattern.matches("^([A-Z])(.)*([.])$",text));
        // ^([A-Z]) -> starts with Capital
        // (.)*     -> any character in between, zero or more times
        // ([.])$   -> ends with period character(use \. or [.], to represent period)
    }
}
