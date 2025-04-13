package org.uniquindio.edu.co.poo.model;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;

    public Cliente(String nombre, String identificacion, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return nombre + " (ID: " + identificacion + ")";
    }
}