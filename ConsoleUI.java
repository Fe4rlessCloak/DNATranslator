import java.util.Scanner;

public class ConsoleUI {
    Scanner input = new Scanner(System.in);



    public String getSequence(SequenceManager SM){
    System.out.println("Kindly enter the DNA/RNA sequence:");
    String sequenceToCheck = input.nextLine();

    boolean isValid = SM.isValidSequence(sequenceToCheck); // Pass the original input here
    if(!isValid){ // Simplified check
        while (true) {
            System.out.println("Enter a valid input please");
            sequenceToCheck = input.nextLine();
            
            isValid = SM.isValidSequence(sequenceToCheck);
            if(isValid){
                break;
            }
        }
    }

     return sequenceToCheck.toUpperCase(); 
    }   
    public void printRNAORDNA(String inputSequence, boolean isDNA){
        
        if(isDNA == true){
            System.out.println("The sequence you entered is of type DNA");
        }else {
            System.out.println("The sequence you entered is of type RNA");
        }
    }
    public void printProteinDNA(String[] mRNAStrandOne, String[] mRNAStrandTwo){
        System.out.println("5'3' Frame 1: " + mRNAStrandOne[0]);
        System.out.println("5'3' Frame 2: " + mRNAStrandOne[1]);
        System.out.println("5'3' Frame 3: " + mRNAStrandOne[2]);
        System.out.println("3'5' Frame 1: " + mRNAStrandTwo[0]);
        System.out.println("3'5' Frame 2: " + mRNAStrandTwo[1]);
        System.out.println("3'5' Frame 3: " + mRNAStrandTwo[2]);
    }
    public void printProteinmRNA(String[] mRNAStrandOne){
        System.out.println("5'3' Frame 1: " + mRNAStrandOne[0]);
        System.out.println("5'3' Frame 2: " + mRNAStrandOne[1]);
        System.out.println("5'3' Frame 3: " + mRNAStrandOne[2]);
    }


    public void printDNAStrands(String DNA, String antiDNA){
        if(antiDNA==null){
            System.out.println("RNA Strand:\t5'-"+DNA+"-3'");
        }else{
            System.out.println("Strand 1:\t5'-"+DNA+"-3'");
            System.out.println("Strand 2 (Reverse Complement):\t5'-"+antiDNA+"-3'");
        }
        
    }
    public void printmRNAForm(String StrandOne, String StrandTwo){
        if(StrandTwo!=null){
            System.out.println("Converting both DNA strands to mRNA");
            System.out.println("Strand 1:\t5'-"+StrandOne+"-3'");
            System.out.println("Strand 2:\t5'-"+StrandTwo+"-3");
        }
    }


}
