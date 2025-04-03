package org.uniquindio.edu.co.poo.app;


import org.uniquindio.edu.co.poo.Parqueadero;


import javax.swing.*;

public class Main {
    private static JOptionPane JoptionPane;

    public static void main(String[] args){
        JoptionPane.showMessageDialog(null,"Bienvenido al sistema de parqueadero");

        Parqueadero parqueadero  = new Parqueadero ("Parqueadero uq", "Cra 15 #12N");

        int numeroVehiculos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de vehiculos a registrar"));

        for(int i = 0; i< numeroVehiculos; i++){

            String matricula = JOptionPane.showInputDialog(null,"Ingrese la matricula del vehiculo");
            String color = JOptionPane.showInputDialog(null,"Ingrese la color del vehiculo");
            String modelo = JOptionPane.showInputDialog(null,"Ingrese la modelo de vehiculo");
            String marca = JOptionPane.showInputDialog(null,"Ingrese la marca de vehiculo");


            String mensaje = parqueadero.registrarVehiculo(matricula,color,modelo,marca);
            JOptionPane.showMessageDialog(null,mensaje);

        }

        JOptionPane.showMessageDialog(null,"Vehiculos registrados en el Parqueadero:\n" + parqueadero.toString());



    }
}