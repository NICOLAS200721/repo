package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
        String[] opciones = {"Registrar Odontólogo", "Registrar Paciente", "Actualizar Paciente", "Ver Pacientes con Revisiones Gratuitas", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Consultorio Odontológico",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0 -> registrarOdontologo(consultorio);
                case 1 -> registrarPaciente(consultorio);
                case 2 -> actualizarPaciente(consultorio);
                case 3 -> verPacientesRevisionesGratuitas(consultorio);
            }
        } while (opcion != 4);
    }

    private static void registrarOdontologo(Consultorio consultorio) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del odontólogo:"));
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del odontólogo:");
        String licencia = JOptionPane.showInputDialog("Ingrese número de licencia:");
        Especialidad especialidad = (Especialidad) JOptionPane.showInputDialog(null, "Seleccione especialidad:",
                "Especialidad", JOptionPane.QUESTION_MESSAGE, null, Especialidad.values(), Especialidad.ODONTOLOGIA_GENERAL);

        if (especialidad == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una especialidad.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        consultorio.registrarOdontologo(id, nombre, licencia, especialidad);
        JOptionPane.showMessageDialog(null, "Odontólogo registrado exitosamente.");
    }

    private static void registrarPaciente(Consultorio consultorio) {
        int historiaClinica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de historia clínica:"));
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del paciente:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad:"));
        String telefono = JOptionPane.showInputDialog("Ingrese teléfono:");
        String direccion = JOptionPane.showInputDialog("Ingrese dirección:");
        LocalDate fechaConsulta = LocalDate.parse(JOptionPane.showInputDialog("Ingrese fecha de última consulta (YYYY-MM-DD):"));
        int tratamientos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de tratamientos realizados:"));

        consultorio.registrarPaciente(historiaClinica, nombre, edad, telefono, direccion, fechaConsulta, tratamientos);
        JOptionPane.showMessageDialog(null, "Paciente registrado exitosamente.");
    }

    private static void actualizarPaciente(Consultorio consultorio) {
        int historiaClinica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de historia clínica del paciente:"));
        LocalDate nuevaFechaConsulta = LocalDate.parse(JOptionPane.showInputDialog("Ingrese nueva fecha de consulta (YYYY-MM-DD):"));
        int nuevosTratamientos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de tratamientos nuevos:"));

        consultorio.actualizarPaciente(historiaClinica, nuevaFechaConsulta, nuevosTratamientos);
        JOptionPane.showMessageDialog(null, "Paciente actualizado exitosamente.");
    }

    private static void verPacientesRevisionesGratuitas(Consultorio consultorio) {
        List<Paciente> pacientesGratis = consultorio.obtenerPacientesRevisionesGratuitas();
        if (pacientesGratis.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes con más de 5 tratamientos.");
            return;
        }

        StringBuilder mensaje = new StringBuilder("Pacientes con revisiones gratuitas:\n");
        for (Paciente p : pacientesGratis) {
            mensaje.append(p.nombre()).append(" - ").append(p.cantidadTratamientos()).append(" tratamientos\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}