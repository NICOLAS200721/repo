package org.uniquindio.edu.co.poo.model;

import java.time.LocalDate;

public record Paciente(int historiaClinica, String nombre, int edad,
                       String telefono, String direccion, LocalDate fechaUltimaConsulta,
                       int cantidadTratamientos) {}