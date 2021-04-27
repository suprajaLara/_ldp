public class Part3 {
    Boolean twoOccurrences(String stringa, String stringb){
        int index = stringb.indexOf(stringa);
        if(index!=-1){
            index = stringb.indexOf(stringa,index+stringa.length());
            return index != -1;
        }
        return false;
    }
    String lastPart(String stringa, String stringb){
        int index = stringb.indexOf(stringa);
        if(index != -1)
                return stringb.substring(index+stringa.length(),stringb.length());
        return stringb;
    }
    void  testing(){
        String stringa="mon",stringb="monkey monday";
        System.out.println(twoOccurrences(stringa,stringb)+" "+lastPart(stringa,stringb));
        stringa = "helo"; stringb = "good morning";
        System.out.println(twoOccurrences(stringa,stringb)+" "+lastPart(stringa,stringb));
    }

    public static void main(String[] args) {
        Part3 p = new Part3();
        p.testing();
    }
}
