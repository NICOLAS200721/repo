package org.uniquindio.edu.co.poo.model;

import java.util.List;

public abstract class Vehiculo {
    protected String id;
    protected String modelo;
    protected int añoFabricacion;
    protected int kilometraje;
    protected String estadoOperativo;
    protected List<Mision> listaMisiones;
    protected int misionesCompletadas;  // Campo para contar las misiones

    public Vehiculo(String id, String modelo, int añoFabricacion,
                    int kilometraje, String estadoOperativo) {
        this.id = id;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.kilometraje = kilometraje;
        this.estadoOperativo = estadoOperativo;
        this.misionesCompletadas = 0;  // Inicializamos a 0
    }

    // Getter y setter para misionesCompletadas
    public int getMisionesCompletadas() {
        return misionesCompletadas;
    }

    public void incrementarMisiones() {
        this.misionesCompletadas++;
    }

    // Otros getters y setters
    public String getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public String getEstadoOperativo() {
        return estadoOperativo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Modelo: " + modelo + ", Año: " + añoFabricacion +
                ", Kilometraje: " + kilometraje + ", Estado: " + estadoOperativo +
                ", Misiones Completadas: " + misionesCompletadas;
    }
}