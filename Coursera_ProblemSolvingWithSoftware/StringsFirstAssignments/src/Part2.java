public class Part2 {
    String findSimpleGene(String dna, String startCodon, String stopCodon){
        int start = dna.indexOf(startCodon);
        if(start==-1) return "";
        int stop = dna.indexOf(stopCodon);
        if(stop==-1) return "";
        if(dna.substring(start,stop+3).length() %3 !=0) return "";
        return dna.substring(start,stop+3);
    }
    void testSimpleGene(){
        String test="RFHBRIBCETRJTAA";
        System.out.println(findSimpleGene(test,"RFH","TRJ"));
        test = "atggwduahtaa";
        System.out.println(findSimpleGene(test,"atg","taa"));
//        test = "UWEGDHBWQEHBDO";
//        System.out.println(findSimpleGene(test));
//        test = "GTATGIUEFHTAA";
//        System.out.println(findSimpleGene(test));
//        test = "GTATGIUEGFHTAA";
//        System.out.println(findSimpleGene(test));
    }

    public static void main(String[] args) {
        Part2 p = new Part2();
        p.testSimpleGene();
    }
}
