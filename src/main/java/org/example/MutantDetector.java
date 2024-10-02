package org.example;

public class MutantDetector {
    private static final int SEQUENCE_LENGTH = 4;
    private String[] dna;
    private char[][] dnaMatrix;
    private int N;
    private int countstep;
    MatrizPrint mp = new MatrizPrint(dnaMatrix);

    // Constructor initializes the dna, dnaMatrix, and N
    public MutantDetector(String[] dna) {
        this.dna = dna;
        this.N = dna.length;

        // Convert dna Strings to a character matrix
        this.dnaMatrix = new char[N][N];
        for (int i = 0; i < N; i++) {
            dnaMatrix[i] = dna[i].toCharArray();
        }
    }

    public int recorrer(int[] inicio, int[] direccion) {
        char pattern = '\0';  // Initialize with a null character
        int c = 0;
        int found = 0;
        int[] coordinate = {inicio[0], inicio[1]};  // Copy of the starting coordinate

        // Traverse while the coordinates are within bounds
        while (coordinate[0] < N && coordinate[1] < N) {
            char currentChar = dnaMatrix[coordinate[0]][coordinate[1]];
            countstep++;
            // Check if the current character matches the pattern
            if (currentChar == pattern) {
                c++;  // Increment the match count
            } else {
                pattern = currentChar;  // Update pattern to the current character
                c = 1;  // Reset the match count
            }

            // If a sequence of SEQUENCE_LENGTH is found
            if (c == SEQUENCE_LENGTH) {
                found++;  // Increment found sequences
                c = 0;    // Reset count for new sequences
            }

            // Update the coordinates based on the direction
            coordinate[0] += direccion[0];
            coordinate[1] += direccion[1];
        }

        return found;  // Return the number of sequences found
    }

    public boolean isMutant() {
        int countSequences = 0;
        System.out.println(dnaMatrix.length);

        // Recorremos toda la matriz
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int[] inicio = {i, j};
                // Verificamos si es posible encontrar secuencias horizontales, verticales o diagonales
                if (i == 0) {
                    int[] direccion = {1, 0};
                    countSequences += recorrer(inicio, direccion);
                    if (countSequences > 1) {
                        System.out.println("countstep=" + countstep);
                        return true;  // Más de una secuencia encontrada
                    }
                }
                if (j == 0) {

                    if (dnaMatrix.length - SEQUENCE_LENGTH <= i + j) {

                        if (dnaMatrix.length - SEQUENCE_LENGTH <= i - j + dnaMatrix.length - 1) {

                        }
                    }
                }
                System.out.println("countstep=" + countstep);
                return false;  // No se encontraron suficientes secuencias
            }

        }
        return false;
    }
}