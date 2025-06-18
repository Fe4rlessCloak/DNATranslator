public class Main{
    public static void main(String[] args) {
        SequenceManager SM = new SequenceManager();
        ConsoleUI CUI = new ConsoleUI();
        String userInput = CUI.getSequence(SM);
        userInput = userInput.toLowerCase();
        boolean isDNA = SM.isDNAORRNA(userInput);
        CUI.printRNAORDNA(userInput, isDNA);

        if(isDNA==true){
            String antiDNA = SM.returnAntiDNA(userInput);
            CUI.printDNAStrands(userInput,antiDNA);

            String mRNAStrandOne = SM.returnmRNA(userInput);
            String mRNAStrandTwo = SM.returnmRNA(antiDNA);
            String[] proteinStrandOne = SM.codonSplitter(mRNAStrandOne);
            String[] proteinStrandTwo = SM.codonSplitter(mRNAStrandTwo);
            CUI.printProteinDNA(proteinStrandOne,proteinStrandTwo);

        }else{
            String mRNAStrandOne = SM.returnmRNA(userInput);
            String[] proteinStrandOne = SM.codonSplitter(mRNAStrandOne);
            CUI.printProteinmRNA(proteinStrandOne);
        }
    }
}