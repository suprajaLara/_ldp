public class CaesarCipher {
    String caeser(String input, int key1,int key2){
        StringBuilder encrypt = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        Character curChar,newChar;
        int ind ;
        for(int i=0;i<encrypt.length();i++){
            curChar=encrypt.charAt(i);
            ind = alphabet.indexOf(Character.toUpperCase(curChar));
            if(ind!=-1) {
                if(i%2==0) {
                    newChar = shiftedAlphabet1.charAt(ind);
                }
                else{
                    newChar = shiftedAlphabet2.charAt(ind);
                }
                if(Character.isLowerCase(curChar)){
                    encrypt.setCharAt(i, Character.toLowerCase(newChar));
                }
                else {
                    encrypt.setCharAt(i, newChar);
                }
            }
        }
        return encrypt.toString();
    }
    public static void main(String[] args) {
        CaesarCipher c = new CaesarCipher();
        int key1=8,key2=21;
        String input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted = c.caeser(input,key1,key2);
        String decrypted = c.caeser(encrypted,26-key1,26-key2);
        System.out.println("encrypted: "+encrypted);
        System.out.println("decrypted: "+decrypted );
    }
}
