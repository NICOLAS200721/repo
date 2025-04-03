package org.uniquindio.edu.co.poo.model;


public class Nota {

    private String nombre;
    private double valor;

    public Nota(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}