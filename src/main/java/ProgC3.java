public class ProgC3 {

    public static void main(String[] args) {
        DNA dna = new DNA();
        dna.str = "AGCTCGAATATGC";
        System.out.println(dna.getLevenshteinDistance("ACTGAAGAGC"));
    }
}

