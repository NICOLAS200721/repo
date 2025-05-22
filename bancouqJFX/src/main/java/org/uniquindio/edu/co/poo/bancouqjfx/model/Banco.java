package org.uniquindio.edu.co.poo.bancouqjfx.model;

import java.util.*;
import org.uniquindio.edu.co.poo.bancouqjfx.model.GestorTransacciones;
import org.uniquindio.edu.co.poo.bancouqjfx.model.GestorTransacciones.Transaccion;

public class Banco {
    public String nombre;
    public Collection<Cliente> clientes;
    public List<Transaccion> historialTransacciones;
    public Collection<CuentaBancaria> listaCuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
        historialTransacciones = new ArrayList<>();
        listaCuentas = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
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

    public Collection<CuentaBancaria> getListaCuentas() {
        return listaCuentas;
    }

    public boolean agregarCuenta(CuentaBancaria cuenta) {
        boolean centinela = false;
        if (!verificarcuenta(cuenta.getNumeroCuenta())) {
            listaCuentas.add(cuenta);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarCuentas(String numeroCuenta) {
        boolean centinela = false;
        for (CuentaBancaria cuentaBancaria : listaCuentas) {
            if (cuentaBancaria.getNumeroCuenta().equals(numeroCuenta)) {
                listaCuentas.remove(cuentaBancaria);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCuentas(String numeroCuenta, CuentaBancaria actualizada) {
        boolean centinela = false;
        for (CuentaBancaria cuentaBancaria : listaCuentas) {
            if (cuentaBancaria.getNumeroCuenta().equals(numeroCuenta)) {
                cuentaBancaria.setNumeroCuenta(actualizada.getNumeroCuenta());
                cuentaBancaria.setSaldo(actualizada.getSaldo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarcuenta(String numeroCuenta) {
        boolean centinela = false;
        for (CuentaBancaria cuentaBancaria : listaCuentas) {
            if (cuentaBancaria.getNumeroCuenta().equals(numeroCuenta)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean agregarTransaccion(Transaccion nuevaTransaccion) {
        if (!verificarTransaccion(nuevaTransaccion.getCuentaOrigen(), nuevaTransaccion.getCuentaDestino())) {
            historialTransacciones.add(nuevaTransaccion);
            return true;
        }
        return false;
    }

    public boolean eliminarTransaccion(String cuentaOrigen, String cuentaDestino) {
        for (Transaccion transaccion : historialTransacciones) {
            if (transaccion.getCuentaOrigen().equals(cuentaOrigen) &&
                    transaccion.getCuentaDestino().equals(cuentaDestino)) {
                historialTransacciones.remove(transaccion);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarTransaccion(String cuentaOrigen, String cuentaDestino, Transaccion actualizada) {
        for (Transaccion transaccion : historialTransacciones) {
            if (transaccion.getCuentaOrigen().equals(cuentaOrigen) &&
                    transaccion.getCuentaDestino().equals(cuentaDestino)) {
                transaccion.setCuentaOrigen(actualizada.getCuentaOrigen());
                transaccion.setCuentaDestino(actualizada.getCuentaDestino());
                transaccion.setMonto(actualizada.getMonto());
                transaccion.setFechaHora(actualizada.getFechaHora());
                return true;
            }
        }
        return false;
    }

    public boolean verificarTransaccion(String cuentaOrigen, String cuentaDestino) {
        for (Transaccion transaccion : historialTransacciones) {
            if (transaccion.getCuentaOrigen().equals(cuentaOrigen) &&
                    transaccion.getCuentaDestino().equals(cuentaDestino)) {
                return true;
            }
        }
        return false;
    }
}