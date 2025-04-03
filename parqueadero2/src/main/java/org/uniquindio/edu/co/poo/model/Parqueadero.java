package org.uniquindio.edu.co.poo;

import java.util.ArrayList;

public class Parqueadero {
    private String nombre;
    private String ubicacion;
    private ArrayList<Vehiculo> listaVehiculos;

    public Parqueadero(String nombre, String ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaVehiculos = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }



    public String registrarVehiculo (String matricula, String color, String modelo, String marca){
        if (buscarVehiculo(matricula) != null ){
            return " Error: El vehiculo ya está registrado";
        }
        listaVehiculos.add(new Vehiculo(matricula,color,modelo,marca));
        return "El vehiculo se ha registrado con exito";

    }

    private Vehiculo buscarVehiculo(String matricula){
        for (Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo.getMatricula().equals(matricula)){
                return vehiculo;

            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Parqueadero{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }

}