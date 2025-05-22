package org.uniquindio.edu.co.poo.bancouqjfx.model;

import java.util.Collection;
import java.util.LinkedList;

public class Cajero extends Persona {

    private Collection<Cliente> clientes;

    public Cajero(String nombre, String apellido, String cedula, Collection<Cliente> clientes) {
        super(nombre, apellido, cedula);
        clientes = new LinkedList<>();

    }


    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
}
