package org.uniquindio.edu.co.poo.model;

public class transporteTropas extends Vehiculo {
    private int capacidadSoldados;

    public transporteTropas(String id, String modelo, int añoFabricacion,
                            int kilometraje, String estadoOperativo, int capacidadSoldados) {
        super(id, modelo, añoFabricacion, kilometraje, estadoOperativo); // Llamamos al constructor de la clase base
        this.capacidadSoldados = capacidadSoldados;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidad de soldados: " + capacidadSoldados;
    }
}