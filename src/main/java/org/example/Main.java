package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] dna = {
                "AAAAGTCGA",
                "TTTGTGCTT",
                "GTTTGAGTG",
                "TTTCTGATG",
                "TGCCGATTC",
                "TCAGGGAGA",
                "ATTCGAGCC",
                "CTAGTGTCC",
                "CTTATGGTC"
        };

        ADN adn = new ADN(16);  // Create a random NxN matrix of 'A', 'C', 'G', 'T'

        // Create the MutantDetector with the generated matrix
        MutantDetector detector = new MutantDetector(adn.getDnaMatrix());
        boolean isMutant = detector.isMutant();
        System.out.println("Is mutant? " + isMutant);
    }
}