package org.uniquindio.edu.co.poo.model;

class Batallon {
    private List<VehiculoMilitar> flota;
    private List<Mision> misiones;

    public Batallon() {
        this.flota = new ArrayList<>();
        this.misiones = new ArrayList<>();
    }

    public void agregarVehiculo(VehiculoMilitar vehiculo) {
        flota.add(vehiculo);
    }

    public void registrarMision(Mision mision) {
        misiones.add(mision);
    }

    public List<VehiculoMilitar> obtenerVehiculosParaReemplazo() {
        List<VehiculoMilitar> aReemplazar = new ArrayList<>();
        for (VehiculoMilitar v : flota) {
            if (v.getMisionesCompletadas() > 50) {
                aReemplazar.add(v);
            }
        }
        return aReemplazar;
    }
}
