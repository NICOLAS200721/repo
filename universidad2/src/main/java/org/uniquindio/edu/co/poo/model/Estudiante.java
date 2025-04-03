package org.uniquindio.edu.co.poo.model;


import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String identificacion;
    private ArrayList<Nota> listaNotas;

    public Estudiante(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.listaNotas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }

    public void agregarNota(Nota nota) {
        listaNotas.add(nota);
    }

    public boolean actualizarNota(String nombreNota, double nuevoValor) {
        for (Nota nota : listaNotas) {
            if (nota.getNombre().equalsIgnoreCase(nombreNota)) {
                nota.setValor(nuevoValor);
                return true;
            }
        }
        return false;
    }

    public double calcularPromedio() {
        if (listaNotas.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Nota nota : listaNotas) {
            suma += nota.getValor();
        }
        return suma / listaNotas.size();
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", listaNotas=" + listaNotas +
                '}';
    }
}