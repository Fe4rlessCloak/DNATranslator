

public class SequenceManager {
    public boolean isValidSequence(String sequenceToCheck) {
        if (sequenceToCheck == null || sequenceToCheck.isEmpty()) {
            return false;
        }

        // Convert to uppercase ONCE inside isValidSequence
        String upperCaseSequence = sequenceToCheck.toLowerCase(); // <<< ADD THIS LINE

        for (int i = 0; i < upperCaseSequence.length(); i++) { // <<< Loop through the uppercase version
            char base = upperCaseSequence.charAt(i);
            // Now, only check against uppercase characters
            if (base != 'a' && base != 't' && base != 'c' && base != 'g' && base != 'u') {
                return false;
            }
        }
        return true;
    }

    public boolean isDNAORRNA(String sequenceToCheck){
        boolean isDNA = true;
        sequenceToCheck = sequenceToCheck.toLowerCase();
        for (int i = 0; i < sequenceToCheck.length(); i++){
            if(sequenceToCheck.charAt(i)=='u'){
                isDNA = false;
            }
        }
        return isDNA;
    }
    public String returnAntiDNA(String DNA){
        String antiDNA = "";
        String trueAntiDNA = "";
        DNA = DNA.toLowerCase();
        for(int i = 0;i<DNA.length();i++){
            switch (DNA.charAt(i)) {
                case 'a' -> {antiDNA+="t";}
                case 't' -> {antiDNA+="a";}
                case 'g' -> {antiDNA+="c";}
                case 'c' -> {antiDNA+="g";}
            }
        }

        for (int i = antiDNA.length() - 1; i >= 0; i--) {
            trueAntiDNA += antiDNA.charAt(i);
        }
        return trueAntiDNA;
    }
    public String returnmRNA(String DNA){
        String mRNA = "";
        for(int i = 0;i<DNA.length();i++){
            if(DNA.charAt(i)=='t'){
                mRNA += 'u';
            }else{
                mRNA += DNA.charAt(i);
            }
        }
        return mRNA;
    }

    public String[] codonSplitter(String DNA){
        System.out.println(DNA);
        GeneticDatabase GD = new GeneticDatabase();
        String codonToSearch = "";
        String Frame1 = "";
        String Frame2 = "";
        String Frame3 = "";
        boolean isTranslating = false;
        boolean didFindStopCodon = false;
        
        
       
                // 0,1,2
                // | | | 
                // 3,4,5
                // | | |
                // 6,7,8
        int i = 0;
        int j = 1;
        int k = 2;

        for (; i < DNA.length(); i+=3) {
            if(DNA.length()-i>2){
                if(DNA.charAt(i)=='a' && DNA.charAt(i+1) == 'u' && DNA.charAt(i+2)=='g'){
                    isTranslating = true; 
                }
            
            if(((DNA.charAt(i)=='u' && DNA.charAt(i+1) == 'a' && DNA.charAt(i+2)=='g') || (DNA.charAt(i)=='u' && DNA.charAt(i+1) == 'g' && DNA.charAt(i+2)=='a') || (DNA.charAt(i)=='u' && DNA.charAt(i+1) == 'a' && DNA.charAt(i+2)=='a')) && isTranslating == true){
                    didFindStopCodon = true;
                    isTranslating = false;
                    codonToSearch = "";
                    Frame1 += "-";
            }
            if(isTranslating==true){
                    try {
                        codonToSearch += DNA.charAt(i);
                        codonToSearch += DNA.charAt(i+1);
                        codonToSearch += DNA.charAt(i+2);
                        
                        codonToSearch = codonToSearch.toUpperCase();
                        Frame1 += GD.returnCodonTranslated(codonToSearch);
                        codonToSearch = "";
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Out of bounds");
                }
            }
        }
        
        }
        
        if(Frame1.length()==0){
            Frame1+= "No ORF Found";
        }else if(didFindStopCodon==true){
            Frame1+=" (Complete)";
        }else{
            Frame1+= "(Incomplete)";
        }


        isTranslating = false;
        didFindStopCodon = false;
        for (; j < DNA.length(); j+=3) {
            System.out.println(j);
            if(DNA.length()-j>2){
                if(DNA.charAt(j)=='a' && DNA.charAt(j+1) == 'u' && DNA.charAt(j+2)=='g'){
                    isTranslating = true;
                }
            
            if(((DNA.charAt(j)=='u' && DNA.charAt(j+1) == 'a' && DNA.charAt(j+2)=='g') || (DNA.charAt(j)=='u' && DNA.charAt(j+1) == 'g' && DNA.charAt(j+2)=='a') || (DNA.charAt(j)=='u' && DNA.charAt(j+1) == 'a' && DNA.charAt(j+2)=='a')) && isTranslating == true){
                    didFindStopCodon = true;
                    isTranslating = false;
                    codonToSearch = "";
                    Frame2 += "-";
            }
            if(isTranslating==true){
                
                    try {
                        
                        codonToSearch += DNA.charAt(j);
                        codonToSearch += DNA.charAt(j+1);
                        codonToSearch += DNA.charAt(j+2);
                        
                        codonToSearch = codonToSearch.toUpperCase();
                        Frame2 += GD.returnCodonTranslated(codonToSearch);
                        codonToSearch = "";
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Out of bounds");
                }
            }
            }
        }

        if(Frame2.length()==0){
            Frame2+= "No ORF Found";
        }else if(didFindStopCodon==true){
            Frame2+=" (Complete)";
        }else{
            Frame2+= " (Incomplete)";
        }


        isTranslating = false;
        didFindStopCodon = false;
        for (; k < DNA.length(); k+=3) {
            
            if(DNA.length()-k>2){
                if(DNA.charAt(k)=='a' && DNA.charAt(k+1) == 'u' && DNA.charAt(k+2)=='g'){
                    isTranslating = true;
                }
            
                if(((DNA.charAt(k)=='u' && DNA.charAt(k+1) == 'a' && DNA.charAt(k+2)=='g') || (DNA.charAt(k)=='u' && DNA.charAt(k+1) == 'g' && DNA.charAt(k+2)=='a') || (DNA.charAt(k)=='u' && DNA.charAt(k+1) == 'a' && DNA.charAt(k+2)=='a')) && isTranslating == true){
                        didFindStopCodon = true;
                        isTranslating = false;
                        codonToSearch = "";
                        Frame3 += "-";
                }
                if(isTranslating==true){
                        try {
                            System.out.println(j);
                            codonToSearch += DNA.charAt(k);
                            codonToSearch += DNA.charAt(k+1);
                            codonToSearch += DNA.charAt(k+2);
                            
                            codonToSearch = codonToSearch.toUpperCase();
                            Frame3 += GD.returnCodonTranslated(codonToSearch);
                            codonToSearch = "";
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Out of bounds");
                    }
            }
            }
        }

        if(Frame3.length()==0){
            Frame3+= "No ORF Found";
        }else if(didFindStopCodon==true){
            Frame3+=" (Complete)";
        }else{
            Frame3+= " (Incomplete)";
        }




    /* 
        for (int i = 0; i < DNA.length(); i++) {
            System.out.println(i);
            if(DNA.length()-i>2){
                if(DNA.charAt(i)=='a' && DNA.charAt(i+1) == 'u' && DNA.charAt(i+2)=='g'){
                    startLocation = i;
                    isTranslating = true;
                }
                if((DNA.charAt(i)=='u' && DNA.charAt(i+1) == 'a' && DNA.charAt(i+2)=='g') || (DNA.charAt(i)=='u' && DNA.charAt(i+1) == 'g' && DNA.charAt(i+2)=='a') || (DNA.charAt(i)=='u' && DNA.charAt(i+1) == 'a' && DNA.charAt(i+2)=='a') && isTranslating == true){
                    didFindStopCodon = true;
                    stopLocation = i;
                    isTranslating = false;
                    codonToSearch = "";
                    Frame1 += ".";
                    for(int a = startLocation+1; a < stopLocation+2 ;a++){
                        if(DNA.length()-a>2){
                            try {
                                codonToSearch += DNA.charAt(a);
                                codonToSearch += DNA.charAt(a+1);
                                codonToSearch += DNA.charAt(a+2);
        
                                codonToSearch = codonToSearch.toUpperCase();
                                Frame2 += GD.returnCodonTranslated(codonToSearch);
                                codonToSearch = "";
                                a+=2;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Out of bounds");
                            }
                        }
                    }
                    for(int a = startLocation+2; a < stopLocation+3 ;a++){
                        if(DNA.length()-a>2){
                            try {
                                System.out.println(i);
                                codonToSearch += DNA.charAt(a);
                                codonToSearch += DNA.charAt(a+1);
                                codonToSearch += DNA.charAt(a+2);
        
                                codonToSearch = codonToSearch.toUpperCase();
                                Frame3 += GD.returnCodonTranslated(codonToSearch);
                                codonToSearch = "";
                                a+=2;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Out of bounds");
                            }
                        }
                    }
                }
                if(isTranslating==true){
                    try {
                        System.out.println(i);
                        codonToSearch += DNA.charAt(i);
                        codonToSearch += DNA.charAt(i+1);
                        codonToSearch += DNA.charAt(i+2);
                        
                        codonToSearch = codonToSearch.toUpperCase();
                        Frame1 += GD.returnCodonTranslated(codonToSearch);
                        codonToSearch = "";
                        i+=2;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Out of bounds");
                    }
                    
                }
            }
            
        }*/
        
        String[] readingFrames = new String[3];
        readingFrames[0] = Frame1;
        readingFrames[1] = Frame2;
        readingFrames[2] = Frame3;
        return readingFrames;
    
    }
}
