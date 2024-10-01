package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MutantDetector detector = new MutantDetector();

        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTAGGT",
                "AGGAGG",
                "CGCGTA",
                "TTTTGG"};

        System.out.println(detector.isMutant(dna));  // Debería imprimir true

        // Matriz de ejemplo
        char[][] matriz = {
                {'A', 'B', 'C', 'D'},
                {'E', 'F', 'G', 'H'},
                {'I', 'J', 'K', 'L'},
                {'M', 'N', 'Ñ', 'O'}
        };

        // Crear una instancia de MatrizPrint
        MatrizPrint mp = new MatrizPrint(matriz);

        // Imprimir la matriz sin resaltado
        System.out.println("Matriz sin resaltado:");
        mp.print();

        // Coordenadas a resaltar
        int[][] coords = {{0, 0}, {1, 1}, {2, 2}, {3, 2}};

        // Imprimir la matriz con resaltado
        System.out.println("\nMatriz con resaltado:");
        mp.highlight(coords);
    }
}