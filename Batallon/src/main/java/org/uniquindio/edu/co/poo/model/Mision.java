package org.uniquindio.edu.co.poo.model;

class Mision {
    private String fecha;
    private String ubicacion;
    private String personalAsignado;
    private List<VehiculoMilitar> vehiculosUtilizados;

    public Mision(String fecha, String ubicacion, String personalAsignado) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.personalAsignado = personalAsignado;
        this.vehiculosUtilizados = new ArrayList<>();
    }

    public void agregarVehiculo(VehiculoMilitar vehiculo) {
        vehiculo.registrarMision();
        vehiculosUtilizados.add(vehiculo);
    }
}