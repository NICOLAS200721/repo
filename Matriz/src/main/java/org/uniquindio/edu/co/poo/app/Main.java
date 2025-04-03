package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.ManejadorMatriz;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas:"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas:"));
        int giros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de giros hacia la derecha:"));

        ManejadorMatriz matriz = new ManejadorMatriz(filas, columnas);
        JOptionPane.showMessageDialog(null, "Matriz Original:\n" + matriz.mostrarMatriz());

        matriz.rotarDerecha(giros);
        JOptionPane.showMessageDialog(null, "Matriz Rotada:\n" + matriz.mostrarMatriz());
    }
}