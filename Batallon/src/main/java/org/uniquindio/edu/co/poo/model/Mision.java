package org.uniquindio.edu.co.poo.model;

import java.util.Date;
import java.util.List;

public class Mision {
    private Date fecha;
    private String ubicacion;
    private String personalAsignado;
    private List<Vehiculo> listaVehiculos;

    public Mision(Date fecha, String ubicacion, String personalAsignado, List<Vehiculo> listaVehiculos) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.personalAsignado = personalAsignado;
        this.listaVehiculos = listaVehiculos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }
}