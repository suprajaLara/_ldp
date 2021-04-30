package Assignment11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment11 {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the filename: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();

        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        Map<Character,Integer> characterIntegerMap = new HashMap<>();
        String line;
        while( (line = bufferedReader.readLine() ) != null){
            for(int i=0;i<line.length();i++){
                if(characterIntegerMap.containsKey(line.charAt(i))){
                    characterIntegerMap.put(line.charAt(i),characterIntegerMap.get(line.charAt(i)) + 1);
                }
                else{
                    characterIntegerMap.put(line.charAt(i),1);
                }
            }
        }
        bufferedReader.close();

        String newFileName = file.getAbsolutePath().split("[.]")[0]+"CharMap.txt";
        FileWriter newFile = new FileWriter(newFileName);

        for(Character ch : characterIntegerMap.keySet()){
            String eachLine = ch+" : "+characterIntegerMap.get(ch);
            newFile.write(eachLine+"\n");
        }
        System.out.println("Character frequency map written to "+newFileName);
        newFile.close();
    }
}
