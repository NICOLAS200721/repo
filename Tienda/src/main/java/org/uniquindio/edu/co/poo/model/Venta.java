package org.uniquindio.edu.co.poo.model;

import java.time.LocalDate;

public class Venta {
    private LocalDate fecha;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private double montoTotal;

    public Venta(LocalDate fecha, Cliente cliente, Producto producto, int cantidad) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.montoTotal = cantidad * producto.getPrecio();
    }

    @Override
    public String toString() {
        return "Venta - Fecha: " + fecha + ", Cliente: " + cliente.getNombre() +
                ", Producto: " + producto.getNombre() + ", Cantidad: " + cantidad +
                ", Total: $" + montoTotal;
    }
}