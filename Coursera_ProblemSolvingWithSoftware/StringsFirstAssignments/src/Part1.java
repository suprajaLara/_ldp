public class Part1 {

    String findSimpleGene(String dna){
        int start = dna.indexOf("ATG");
        if(start==-1) return "";
        int stop = dna.indexOf("TAA");
        if(stop==-1) return "";
        if(dna.substring(start,stop+3).length() %3 !=0) return "";
        return dna.substring(start,stop+3);
    }
    void testSimpleGene(){
        String test="RFHBRIBCERJTAA";
        System.out.println(findSimpleGene(test));
        test = "ATGIEDHENCD";
        System.out.println(findSimpleGene(test));
        test = "UWEGDHBWQEHBDO";
        System.out.println(findSimpleGene(test));
        test = "GTATGIUEFHTAA";
        System.out.println(findSimpleGene(test));
        test = "GTATGIUEGFHTAA";
        System.out.println(findSimpleGene(test));
    }

    public static void main(String[] args) {
        Part1 p = new Part1();
        p.testSimpleGene();
    }
}
