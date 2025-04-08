package org.uniquindio.edu.co.poo.model;

public class vehiculoApoyo extends Vehiculo {
    private String tipoFuncion;

    public vehiculoApoyo(String id, String modelo, int añoFabricacion,
                         int kilometraje, String estadoOperativo, String tipoFuncion) {
        super(id, modelo, añoFabricacion, kilometraje, estadoOperativo); // Llamamos al constructor de la clase base
        this.tipoFuncion = tipoFuncion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de función: " + tipoFuncion;
    }
}