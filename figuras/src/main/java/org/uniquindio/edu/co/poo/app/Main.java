package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Circulo;

import org.uniquindio.edu.co.poo.model.Cuadrado;
import org.uniquindio.edu.co.poo.model.Figura;
import org.uniquindio.edu.co.poo.model.TrianguloEquilatero;


import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        int opcion;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "Seleccione la figura:\n1. Círculo\n2. Cuadrado\n3. Triángulo Equilátero\n4. Salir"));

                Figura figura = null;

                switch (opcion) {
                    case 1:
                        double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio del círculo:"));
                        figura = new Circulo(radio);
                        break;
                    case 2:
                        double ladoCuadrado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado del cuadrado:"));
                        figura = new Cuadrado(ladoCuadrado);
                        break;
                    case 3:
                        double ladoTriangulo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado del triángulo equilátero:"));
                        figura = new TrianguloEquilatero(ladoTriangulo);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                }

                if (figura != null) {
                    String resultado = "Figura: " + figura.getClass().getSimpleName() + "\n" +
                            String.format("Área: %.2f\n", figura.calcularArea()) +
                            String.format("Perímetro: %.2f", figura.calcularPerimetro());
                    JOptionPane.showMessageDialog(null, resultado);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese un número válido.");
                opcion = 0;
            }
        } while (opcion != 4);
    }
}