import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
//import edu.duke.*;

public class VigenereBreaker {
    private int[] validKey;
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slice = new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            slice.append(message.charAt(i));
        }
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker caesarCracker = new CaesarCracker();
        for(int i=0;i<klength;i++){
            String sliceEach = sliceString(encrypted,i,klength);
            key[i]=caesarCracker.getKey(sliceEach);
        }
        return key;
    }


    public void breakVigenere () throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get("src/data/secretmessage3.txt")));
        String dict =  new String(Files.readAllBytes(Paths.get("src/dictionaries/English")));
        HashSet<String> dictionary = readDictionary("src/athens_keyflute.txt");

        /* CODE FOR ASSIGNMENT 1 */
//        int[] keyToApply = tryKeyLength(fileContent,5,'e');
//        VigenereCipher vignere = new VigenereCipher(keyToApply);
//        System.out.println(vignere.decrypt(fileContent));

        /* CODE FOR ASSIGNMENT 2 */
//        String perfectDecryption = breakForLanguage(fileContent, dictionary);
//        System.out.println(perfectDecryption);

        /* CODE FOR ASSIGNMENT 3 */

        langList();
        breakForAllLangs(fileContent, langList());
    }

    public HashSet<String> readDictionary(String fr) throws IOException {
        /* this method creates a hashset, adding every word of the fr file, which
         * will be a dictionary, as a String and returns the hashset created.
         */
        HashSet<String> dictionaryList = new HashSet<String>();
        List<String> file = Files.readAllLines(Paths.get(fr), StandardCharsets.UTF_8);
        String[] lines = file.toArray(new String[file.size()]);
        for (String line : lines) {
            String lineLower = line.toLowerCase();
            dictionaryList.add(lineLower);
        }
        return dictionaryList;
    }

    public int countWords(String message, HashSet<String> dictionary){
        String[] messageSplit = message.split("\\W+");
        int commonWords = 0;
        for(int i=0; i < messageSplit.length; i++){
            String word = messageSplit[i].toLowerCase();
            if (dictionary.contains(word)){
                commonWords++;
            }
        }
        return commonWords;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int max = 0;
        String perfectDecrypted = "";
        for(int i=1; i<=100; i++){
            int[] keys = tryKeyLength(encrypted, i, mostCommonCharIn(dictionary));
            VigenereCipher vignere = new VigenereCipher(keys);
            String decrypted = vignere.decrypt(encrypted);
            int wordsCounted = countWords(decrypted, dictionary);
            if(wordsCounted > max){
                max = wordsCounted;
                perfectDecrypted = decrypted;
                validKey = keys;
            }
        }
        System.out.println("This file contains " + max + " valid words.");
        return perfectDecrypted;
    }

    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
                'p','q','r','s','t','u','v','w','x','y','z'};
        for (char aChar : chars) {
            characters.put(aChar, 0);
        }
        for (String word : dictionary){
            for( char s : characters.keySet()){
                if (word.contains(Character.toString(s))){
                    characters.put(s, characters.get(s)+1);
                }
            }
        }
        int maxValue = 0;
        for(char s : characters.keySet()){
            int value = characters.get(s);
            if (value > maxValue){
                maxValue = value;
            }
        }
        for(char s : characters.keySet()){
            if (characters.get(s) == maxValue){
                return s;
            }
        }
        return 'a';
    }

    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages){
        for (String s : languages.keySet()){
            HashSet<String> lang = languages.get(s);
            String decrypted = breakForLanguage(encrypted,lang);
            int wordCount = countWords(decrypted, lang);
            System.out.println("LANGUAGE CHOSEN = " + s);
            System.out.println("Decrypted message  ="+ decrypted);
            System.out.println("Words counted = "+ wordCount);
        }
    }

    private HashMap<String, HashSet<String>> langList() throws IOException {
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        languages.put("English", readDictionary("dictionaries/English"));
        languages.put("Danish", readDictionary("dictionaries/Danish"));
        languages.put("Dutch", readDictionary("dictionaries/Dutch"));
        languages.put("French", readDictionary("dictionaries/French"));
        languages.put("German", readDictionary("dictionaries/German"));
        languages.put("Italian", readDictionary("dictionaries/Italian"));
        languages.put("Portuguese", readDictionary("dictionaries/Portuguese"));
        languages.put("Spanish", readDictionary("dictionaries/Spanish"));

        return languages;
    }

    public static void main(String[] args) throws IOException {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
        vigenereBreaker.breakVigenere();
    }

}
