package org.example;

public class MutantDetector {
    // Tamaño mínimo de la secuencia para considerar una mutación
    private static final int SEQUENCE_LENGTH = 4;
    private int countstep=0;

    public boolean isMutant(String[] dna) {
        int n = dna.length;
        int countSequences = 0;

        // Convertimos el arreglo de Strings en una matriz de caracteres
        char[][] dnaMatrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            dnaMatrix[i] = dna[i].toCharArray();
        }

        MatrizPrint mp = new MatrizPrint(dnaMatrix);

        System.out.println(dnaMatrix.length);

        // Recorremos toda la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Verificamos si es posible encontrar secuencias horizontales, verticales o diagonales
                if (i==0){
                    if (checkVertical(dnaMatrix,0,j)){
                        countSequences++;
                        if (countSequences > 1) {
                            System.out.println("countstep="+countstep);
                            return true;  // Más de una secuencia encontrada
                        }
                    }
                }
                if (j==0){
                    if (checkVertical(dnaMatrix,i,0)){
                        countSequences++;
                        if (countSequences > 1) {
                            System.out.println("countstep="+countstep);
                            return true;  // Más de una secuencia encontrada
                        }
                    }
                }
                if (dnaMatrix.length-SEQUENCE_LENGTH<=i+j){
                    if(checkDiagonalRight(dnaMatrix,i,0)){
                        countSequences++;
                        if (countSequences > 1) {
                            System.out.println("countstep="+countstep);
                            return true;  // Más de una secuencia encontrada
                        }
                    }
                }
                if (dnaMatrix.length-SEQUENCE_LENGTH<=i-j+dnaMatrix.length-1) {
                    if (checkDiagonalLeft(dnaMatrix, i, j)) {
                        countSequences++;
                        if (countSequences > 1) {
                            System.out.println("countstep=" + countstep);
                            return true;  // Más de una secuencia encontrada
                        }
                    }
                }
            }
        }
        System.out.println("countstep="+countstep);
        return false;  // No se encontraron suficientes secuencias
    }

    // Verifica secuencias horizontales
    private boolean checkHorizontal(char[][] dna, int row, int col) {
        if (col + SEQUENCE_LENGTH > dna.length) return false;  // No hay suficiente espacio
        char pattern = dna[row][col];
        int counter=0;
        for (int i = 1; i < dna.length-1; i++) {
            countstep++;
            char current=dna[row][col+i];
            if (current == pattern) {
                counter++;
            }else{
                counter=0;
            }
            if (counter>=4){
                return true;
            }
            pattern=current;
        }
        return false;
    }

    // Verifica secuencias verticales
    private boolean checkVertical(char[][] dna, int row, int col) {
        if (row + SEQUENCE_LENGTH > dna.length) return false;  // No hay suficiente espacio
        char pattern = dna[row][col];
        int counter=0;
        for (int i = 1; i < dna.length-1; i++) {
            countstep++;
            char current=dna[row+i][col];
            if (current == pattern) {
                counter++;
            }else{
                counter=0;
            }
            if (counter>=4){
                return true;
            }
            pattern=current;
        }
        return false;
    }

    // Verifica secuencias diagonales de izquierda a derecha
    private boolean checkDiagonalRight(char[][] dna, int row, int col) {
        if (row + SEQUENCE_LENGTH > dna.length || col + SEQUENCE_LENGTH > dna.length) return false;  // No hay suficiente espacio
        char pattern = dna[row][col];
        int counter=0;
        for (int i = 0; i < dna.length-1; i++) {
            countstep++;
            char current=dna[row+i][col+i];
            if (current == pattern) {
                counter++;
            }else{
                counter=0;
            }
            if (counter >=4){
                return true;
            }
            pattern=current;
        }
        return false;
    }

    // Verifica secuencias diagonales de derecha a izquierda
    private boolean checkDiagonalLeft(char[][] dna, int row, int col) {
        if (row + SEQUENCE_LENGTH > dna.length || col - SEQUENCE_LENGTH + 1 < 0) return false;  // No hay suficiente espacio
        char pattern = dna[row][col];
        int counter=0;
        for (int i = 1; i < dna.length-1; i++) {
            countstep++;
            char current=dna[row+i][col-i];
            if (current == pattern) {
                counter++;
            }else{
                counter=0;
            }
            if (counter>=4){
                return true;
            }
            pattern=current;
        }
        return false;
    }
}
