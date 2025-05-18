package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Parqueadero;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de parqueadero");

        Parqueadero parqueadero = new Parqueadero("Parqueadero UQ", "Cra 15 #12N");

        int numeroVehiculos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de vehículos a registrar"));

        for (int i = 0; i < numeroVehiculos; i++) {
            String matricula = JOptionPane.showInputDialog(null, "Ingrese la matrícula del vehículo");
            String color = JOptionPane.showInputDialog(null, "Ingrese el color del vehículo");
            String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo del vehículo");
            String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del vehículo");

            String mensaje = parqueadero.registrarVehiculo(matricula, color, modelo, marca);
            JOptionPane.showMessageDialog(null, mensaje);
        }

        // Ordenar vehículos por matrícula antes de mostrar
        parqueadero.ordenarVehiculosPorMatricula();

        JOptionPane.showMessageDialog(null, "Vehículos registrados (ordenados por matrícula):\n" + parqueadero.toString());
    }
}