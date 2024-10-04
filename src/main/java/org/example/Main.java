package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] dna = {
                "AAAAG",
                "TTTGA",
                "TTGTG",
                "TTAAG",
                "TTCCT",
        };

        MutantDetector detector = new MutantDetector(dna);
        boolean isMutant = detector.isMutant();
        System.out.println("Is mutant? " + isMutant);

    }
}