package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Universidad;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Uniquindío", "Calle 12N");

        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:\n" +
                            "1. Registrar Estudiante\n" +
                            "2. Agregar Nota\n" +
                            "3. Actualizar Nota\n" +
                            "4. Calcular Promedio\n" +
                            "5. Salir",
                    "Menú de Opciones",
                    JOptionPane.QUESTION_MESSAGE
            );

            switch (opcion) {
                case "1":
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante:");
                    String identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante:");
                    String mensajeRegistro = universidad.registrarEstudiante(nombre, identificacion);
                    JOptionPane.showMessageDialog(null, mensajeRegistro);
                    break;

                case "2":
                    String idEstudiante = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante:");
                    String nombreNota = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nota:");
                    double valorNota;
                    try {
                        valorNota = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de la nota:"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
                        continue;
                    }
                    String mensaje = universidad.agregarNota(idEstudiante, nombreNota, valorNota);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "3":
                    String idActualizar = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante:");
                    String nombreNotaActualizar = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nota a actualizar:");
                    double nuevoValor;
                    try {
                        nuevoValor = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el nuevo valor de la nota:"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
                        break;
                    }
                    String mensajeActualizar = universidad.actualizarNota(idActualizar, nombreNotaActualizar, nuevoValor);
                    JOptionPane.showMessageDialog(null, mensajeActualizar);
                    break;

                case "4":
                    String idPromedio = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante:");
                    String mensajePromedio = universidad.calcularPromedioEstudiante(idPromedio);
                    JOptionPane.showMessageDialog(null, mensajePromedio);
                    break;

                case "5":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, intente de nuevo.");
            }
        }
    }
}