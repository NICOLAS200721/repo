package org.uniquindio.edu.co.poo.model;

class VehiculoApoyo extends VehiculoMilitar {
    private String tipoFuncion;

    public VehiculoApoyo(String id, String modelo, int anioFabricacion, int kilometraje, String estadoOperativo, String tipoFuncion) {
        super(id, modelo, anioFabricacion, kilometraje, estadoOperativo);
        this.tipoFuncion = tipoFuncion;
    }
}
