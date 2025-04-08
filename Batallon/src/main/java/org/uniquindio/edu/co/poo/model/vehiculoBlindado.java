package org.uniquindio.edu.co.poo.model;

public class vehiculoBlindado extends Vehiculo {
    private String nivelBlindaje;

    public vehiculoBlindado(String id, String modelo, int añoFabricacion,
                            int kilometraje, String estadoOperativo, String nivelBlindaje) {
        super(id, modelo, añoFabricacion, kilometraje, estadoOperativo); // Llamamos al constructor de la clase base
        this.nivelBlindaje = nivelBlindaje;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nivel de blindaje: " + nivelBlindaje;
    }
}