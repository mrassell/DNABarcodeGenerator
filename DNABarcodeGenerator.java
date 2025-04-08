// Maheen Rassell mr6761
import java.util.Scanner;
public class DNABarcodeGenerator {
    private static int L; 
    public static void main(String[] args) {
        // Maheen Rassell mr6761
        // ask for N and L 
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many sequences of DNA Barcodes would you like to generate?");
        int N = scanner.nextInt();
        System.out.println("What is the length of the DNA barcode?");
        int L = scanner.nextInt();

        generateAllBarcodes(N, L);

        scanner.close();
    }

    //loop generate Barcode N times 
    public static void generateAllBarcodes(int N, int L) {
        for (int i = 0; i < N; i++) {
            String barcode = generateBarcode();
            System.out.println("barcode" + (i + 1) + ": " + barcode);
        }
    }   

    //generate barcode
    public static String generateBarcode() {
        // add random generated nucleotide chars to barcode, while making sure satisfies requirements
        String barcode = "";
        do {
            for (int i = 0; i < L; i++) {
                char nucleotide = generateLetter();
                barcode += nucleotide;
            }
        } while (!satisfyRequirements(barcode));
        return barcode;
    }

    //make sure it satisfies conditions or else make a new one 
    public static boolean satisfyRequirements(String barcode) {
        return !isRestrictedList(barcode) && validateGCCount(barcode) && !isRedundantBarcode(barcode);
    }
       

    public static char generateLetter() {
        //generate random int 0-3 inclusive and assign a char value
        int randomInt = (int)(Math.random()*4); {
        switch(randomInt) {
            case 0:
                return 'A';
            case 1:
                return 'C';
            case 2: 
                return 'G';
            default: 
                return 'T';
            }
        }
    }
    
    //method to check if there are 3 consecutive nucleotides
    public static boolean isRedundantBarcode(String barcode) {
        for (int i = 0; i < barcode.length() - 2; i++) {
            if (barcode.charAt(i) == barcode.charAt(i + 1) && barcode.charAt(i) == barcode.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    //method to validate gc count
    // if G or C increase count, and divide by total length to get percentage represented as double, between 0.4 and 0.6 
    public static boolean validateGCCount(String barcode) {
        int gcCount = 0;
        int barcodeLength = barcode.length();
        for (int i = 0; i < barcodeLength; i++) {
            char nucleotide = barcode.charAt(i);
            if (nucleotide == 'G' || nucleotide == 'C') {
                gcCount++;
            }
        }
        double gcContent = (double) gcCount / barcodeLength;
        return gcContent >= 0.4 && gcContent <= 0.6;
    }

    //method to check if barcode is in restricted list or not
    public static boolean isRestrictedList(String barcode) {
        //set restricted barcodes:
        final String RESTRICTED_1 = "ACCGGT";
        final String RESTRICTED_2 = "GGCGCGCC";
        final String RESTRICTED_3 = "GGATCC"; 
        final String RESTRICTED_4 = "CCTGCAGG";
        for (int i = 0; i < barcode.length(); i++) {
            if (barcode.charAt(i) == (RESTRICTED_1.charAt(i)) || barcode.charAt(i) == (RESTRICTED_2.charAt(i)) || barcode.charAt(i) == (RESTRICTED_3.charAt(i)) || barcode.charAt(i) == (RESTRICTED_4.charAt(i)) ){
                return true;
            } 
        }
        return false;    
    }
}
