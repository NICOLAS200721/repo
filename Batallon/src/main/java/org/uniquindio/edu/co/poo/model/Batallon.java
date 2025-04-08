package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;
import java.util.List;


public class Batallon {
    private String nombre;
    private String ubicacion;
    private List<Vehiculo> listaVehiculos;
    private List<Mision> listaMisiones;

    public Batallon(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaVehiculos = new ArrayList<>();
        this.listaMisiones = new ArrayList<>();
    }

    public boolean registrarVehiculo(Vehiculo nuevoVehiculo) {
        for (Vehiculo vehiculoAux : listaVehiculos) {
            if (vehiculoAux.getId().equals(nuevoVehiculo.getId())) {
                return false; // El vehículo ya está registrado
            }
        }
        listaVehiculos.add(nuevoVehiculo);
        return true;
    }

    public void registrarMision(Mision mision) {
        listaMisiones.add(mision);
    }

    public List<Vehiculo> obtenerVehiculosMas50Misiones() {
        List<Vehiculo> vehiculosConMas50Misiones = new ArrayList<>();
        for (Vehiculo vehiculo : listaVehiculos) {
            int contadorMisiones = 0;
            for (Mision mision : listaMisiones) {
                if (mision.getListaVehiculos().contains(vehiculo)) {
                    contadorMisiones++;
                }
            }
            if (contadorMisiones > 50) {
                vehiculosConMas50Misiones.add(vehiculo);
            }
        }
        return vehiculosConMas50Misiones;
    }


    /*
    //Metodo para obtener vehiculo con mayor numero de misiones

    public Vehiculo obtenerVehiculoMayorMisiones(){
        Vehiculo vehiculoMayorMisiones = null;
        int mayor = 0
        for(Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumMisiones() > mayor) {
                mayor = vehiculo.getNumMisiones();
                vehiculoMayorMisiones = vehiculo;


            }
        }
        return vehiculoMayorMisiones;
    }
    */

    public void listarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            for (Vehiculo vehiculo : listaVehiculos) {
                System.out.println(vehiculo.toString());
            }
        }
    }

    // Método getListaVehiculos agregado
    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
}