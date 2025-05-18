package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;

public class Parqueadero {
    private String nombre;
    private String ubicacion;
    private ArrayList<Vehiculo> listaVehiculos;

    public Parqueadero(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaVehiculos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre; }

    public String getUbicacion() {
        return ubicacion; }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion; }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos; }
    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos; }

    public String registrarVehiculo(String matricula, String color, String modelo, String marca) {
        if (buscarVehiculo(matricula) != null) {
            return "Error: El vehículo ya está registrado";
        }
        listaVehiculos.add(new Vehiculo(matricula, color, modelo, marca));
        return "El vehículo se ha registrado con éxito";
    }

    private Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    public void ordenarVehiculosPorMatricula() {
        int n = listaVehiculos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Vehiculo v1 = listaVehiculos.get(j);
                Vehiculo v2 = listaVehiculos.get(j + 1);

                if (v1.getMatricula().compareTo(v2.getMatricula()) > 0) {
                    // Intercambiar
                    listaVehiculos.set(j, v2);
                    listaVehiculos.set(j + 1, v1);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parqueadero: ").append(nombre)
                .append(" - Ubicación: ").append(ubicacion)
                .append("\nVehículos registrados:\n");

        for (Vehiculo v : listaVehiculos) {
            sb.append(v).append("\n");
        }
        return sb.toString();
    }
}