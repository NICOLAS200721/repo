package org.uniquindio.edu.co.poo.model;

import java.util.Arrays;

public class ManejadorMatriz {
    private int[][] matriz;

    public ManejadorMatriz(int filas, int columnas) {
        matriz = new int[filas][columnas];
        llenarMatriz();
    }

    private void llenarMatriz() {
        int valor = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = valor++;
            }
        }
    }

    public void rotarDerecha(int giros) {
        for (int k = 0; k < giros; k++) {
            int filas = matriz.length;
            int columnas = matriz[0].length;
            int[][] nuevaMatriz = new int[columnas][filas];

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    nuevaMatriz[j][filas - 1 - i] = matriz[i][j];
                }
            }
            matriz = nuevaMatriz;
        }
    }

    public String mostrarMatriz() {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : matriz) {
            sb.append(Arrays.toString(fila)).append("\n");
        }
        return sb.toString();
    }
}