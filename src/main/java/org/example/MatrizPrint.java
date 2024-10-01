package org.example;

import java.util.HashSet;
import java.util.Set;

public class MatrizPrint {

    private char[][] matriz;

    // Constructor que recibe la matriz de caracteres
    public MatrizPrint(char[][] matriz) {
        this.matriz = matriz;
    }

    // Método que imprime la matriz sin resaltar
    public void print() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método que imprime la matriz resaltando las celdas dadas por los tuples (coordenadas)
    public void highlight(int[][] coords) {
        // Convertir el array de coordenadas en un Set para fácil acceso
        Set<String> highlightCoords = new HashSet<>();
        for (int[] coord : coords) {
            highlightCoords.add(coord[0] + "," + coord[1]);
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // Si la celda está en las coordenadas a resaltar, la mostramos con []
                if (highlightCoords.contains(i + "," + j)) {
                    System.out.print("[" + matriz[i][j] + "] ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
