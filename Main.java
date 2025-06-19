public class Main{
    public static void main(String[] args) {
        SequenceManager SM = new SequenceManager();
        ConsoleUI CUI = new ConsoleUI();
        String userInput = CUI.getSequence(SM);
        userInput = userInput.toLowerCase();
        boolean isDNA = SM.isDNAORRNA(userInput);
        CUI.printRNAORDNA(userInput, isDNA);

        if(isDNA==true){
            String reverseComplement = SM.returnAntiDNA(userInput);
            CUI.printDNAStrands(userInput,reverseComplement);

            String mRNAStrandOne = SM.returnmRNA(userInput);
            String mRNAStrandTwo = SM.returnmRNA(reverseComplement);
            CUI.printmRNAForm(mRNAStrandOne, mRNAStrandTwo);
            String[] proteinStrandOne = SM.codonSplitter(mRNAStrandOne);
            String[] proteinStrandTwo = SM.codonSplitter(mRNAStrandTwo);
            CUI.printProteinDNA(proteinStrandOne,proteinStrandTwo);

        }else{
            CUI.printDNAStrands(userInput, null);
            String mRNAStrandOne = SM.returnmRNA(userInput);
            String[] proteinStrandOne = SM.codonSplitter(mRNAStrandOne);
            CUI.printProteinmRNA(proteinStrandOne);
        }
    }
}