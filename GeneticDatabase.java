import java.util.HashMap;
import java.util.Map;

public class GeneticDatabase {
    private static final Map<String, String> codonToAminoAcid = new HashMap<>();



    public String returnCodonTranslated(String toTranslate){
        // Phenylalanine (F)
        codonToAminoAcid.put("UUU", "F");
        codonToAminoAcid.put("UUC", "F");

        // Leucine (L)
        codonToAminoAcid.put("UUA", "L");
        codonToAminoAcid.put("UUG", "L");
        codonToAminoAcid.put("CUU", "L");
        codonToAminoAcid.put("CUC", "L");
        codonToAminoAcid.put("CUA", "L");
        codonToAminoAcid.put("CUG", "L");

        // Isoleucine (I)
        codonToAminoAcid.put("AUU", "I");
        codonToAminoAcid.put("AUC", "I");
        codonToAminoAcid.put("AUA", "I");

        // Methionine (M) - Start Codon
        codonToAminoAcid.put("AUG", "M"); // Also the start codon

        // Valine (V)
        codonToAminoAcid.put("GUU", "V");
        codonToAminoAcid.put("GUC", "V");
        codonToAminoAcid.put("GUA", "V");
        codonToAminoAcid.put("GUG", "V");

        // Serine (S)
        codonToAminoAcid.put("UCU", "S");
        codonToAminoAcid.put("UCC", "S");
        codonToAminoAcid.put("UCA", "S");
        codonToAminoAcid.put("UCG", "S");
        codonToAminoAcid.put("AGU", "S");
        codonToAminoAcid.put("AGC", "S");

        // Proline (P)
        codonToAminoAcid.put("CCU", "P");
        codonToAminoAcid.put("CCC", "P");
        codonToAminoAcid.put("CCA", "P");
        codonToAminoAcid.put("CCG", "P");

        // Threonine (T)
        codonToAminoAcid.put("ACU", "T");
        codonToAminoAcid.put("ACC", "T");
        codonToAminoAcid.put("ACA", "T");
        codonToAminoAcid.put("ACG", "T");

        // Alanine (A)
        codonToAminoAcid.put("GCU", "A");
        codonToAminoAcid.put("GCC", "A");
        codonToAminoAcid.put("GCA", "A");
        codonToAminoAcid.put("GCG", "A");

        // Tyrosine (Y)
        codonToAminoAcid.put("UAU", "Y");
        codonToAminoAcid.put("UAC", "Y");

        // Stop Codons
        codonToAminoAcid.put("UAA", "-");
        codonToAminoAcid.put("UAG", "-");
        codonToAminoAcid.put("UGA", "-"); // Also Tryptophan for some non-standard codes, but for standard it's STOP

        // Histidine (H)
        codonToAminoAcid.put("CAU", "H");
        codonToAminoAcid.put("CAC", "H");

        // Glutamine (Q)
        codonToAminoAcid.put("CAA", "Q");
        codonToAminoAcid.put("CAG", "Q");

        // Asparagine (N)
        codonToAminoAcid.put("AAU", "N");
        codonToAminoAcid.put("AAC", "N");

        // Lysine (K)
        codonToAminoAcid.put("AAA", "K");
        codonToAminoAcid.put("AAG", "K");

        // Aspartic Acid (D)
        codonToAminoAcid.put("GAU", "D");
        codonToAminoAcid.put("GAC", "D");

        // Glutamic Acid (E)
        codonToAminoAcid.put("GAA", "E");
        codonToAminoAcid.put("GAG", "E");

        // Cysteine (C)
        codonToAminoAcid.put("UGU", "C");
        codonToAminoAcid.put("UGC", "C");

        // Tryptophan (W)
        codonToAminoAcid.put("UGG", "W");

        // Arginine (R)
        codonToAminoAcid.put("CGU", "R");
        codonToAminoAcid.put("CGC", "R");
        codonToAminoAcid.put("CGA", "R");
        codonToAminoAcid.put("CGG", "R");
        codonToAminoAcid.put("AGA", "R");
        codonToAminoAcid.put("AGG", "R");

        // Glycine (G)
        codonToAminoAcid.put("GGU", "G");
        codonToAminoAcid.put("GGC", "G");
        codonToAminoAcid.put("GGA", "G");
        codonToAminoAcid.put("GGG", "G");

        return codonToAminoAcid.get(toTranslate);
    }
}
