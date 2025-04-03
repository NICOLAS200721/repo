package org.uniquindio.edu.co.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultorio {
    private String nombre;
    private String ubicacion;
    private final List<Odontologo> listaOdontologos = new ArrayList<>();
    private final List<Paciente> listaPacientes = new ArrayList<>();

    // Método para registrar un odontólogo
    public void registrarOdontologo(int id, String nombre, String numeroLicencia, Especialidad especialidad) {
        listaOdontologos.add(new Odontologo(id, nombre, numeroLicencia, especialidad));
    }

    // Método para registrar un paciente
    public void registrarPaciente(int historiaClinica, String nombre, int edad, String telefono,
                                  String direccion, LocalDate fechaUltimaConsulta, int tratamientos) {
        listaPacientes.add(new Paciente(historiaClinica, nombre, edad, telefono, direccion, fechaUltimaConsulta, tratamientos));
    }


    // Método para actualizar la información de un paciente
    public void actualizarPaciente(int historiaClinica, LocalDate nuevaFechaConsulta, int nuevosTratamientos) {
        Paciente pacienteExistente = null;
        for (Paciente pacienteAux : listaPacientes) {
            if (pacienteAux.historiaClinica() == historiaClinica) {
                pacienteExistente = pacienteAux;
                break;
            }
        }
        if (pacienteExistente != null) {
            listaPacientes.add(new Paciente(pacienteExistente.historiaClinica(), pacienteExistente.nombre(),
                    pacienteExistente.edad(), pacienteExistente.telefono(), pacienteExistente.direccion(),
                    nuevaFechaConsulta, pacienteExistente.cantidadTratamientos() + nuevosTratamientos));
        }
    }


    // Obtener los pacientes con más de 5 tratamientos
    public List<Paciente> obtenerPacientesRevisionesGratuitas() {
        List<Paciente> resultado = new ArrayList<>();
        for (Paciente pacienteAux : listaPacientes) {
            if (pacienteAux.cantidadTratamientos() > 5) {
                resultado.add(pacienteAux);
            }
        }
        return resultado;
    }

    // Obtener lista de pacientes
    public List<Paciente> obtenerListaPacientes() {
        return new ArrayList<>(listaPacientes);
    }
}