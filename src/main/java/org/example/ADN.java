package org.example;

import java.util.Random;

public class ADN {
    private char[][] dnaMatrix;
    private int N;
    private static final char[] NUCLEOTIDES = {'A', 'C', 'G', 'T'};

    // Constructor that takes N and generates a random NxN matrix
    public ADN(int N) {
        this.N = N;
        this.dnaMatrix = new char[N][N];
        fillRandomMatrix();
    }

    // Method to fill the matrix with random 'A', 'C', 'G', or 'T'
    private void fillRandomMatrix() {
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dnaMatrix[i][j] = NUCLEOTIDES[random.nextInt(NUCLEOTIDES.length)];
            }
        }
    }

    // Getter for the dnaMatrix
    public char[][] getDnaMatrix() {
        return dnaMatrix;
    }
}