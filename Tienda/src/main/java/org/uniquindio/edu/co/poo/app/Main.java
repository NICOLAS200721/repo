package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú de Tienda\n\n" +
                            "1. Agregar Producto\n" +
                            "2. Agregar Cliente\n" +
                            "3. Realizar Venta\n" +
                            "4. Listar Productos\n" +
                            "5. Listar Clientes\n" +
                            "6. Listar Ventas\n" +
                            "7. Eliminar Producto\n" +
                            "8. Eliminar Cliente\n" +
                            "9. Actualizar Producto\n" +
                            "10. Actualizar Cliente\n" +
                            "11. Salir\n\n" +
                            "Ingrese una opción:");

            if (opcion == null) continue;

            switch (opcion) {
                case "1":
                    agregarProducto(tienda);
                    break;
                case "2":
                    agregarCliente(tienda);
                    break;
                case "3":
                    realizarVenta(tienda);
                    break;
                case "4":
                    listarProductos(tienda);
                    break;
                case "5":
                    listarClientes(tienda);
                    break;
                case "6":
                    listarVentas(tienda);
                    break;
                case "7":
                    eliminarProducto(tienda);
                    break;
                case "8":
                    eliminarCliente(tienda);
                    break;
                case "9":
                    actualizarProducto(tienda);
                    break;
                case "10":
                    actualizarCliente(tienda);
                    break;
                case "11":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void agregarProducto(Tienda tienda) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String codigo = JOptionPane.showInputDialog("Ingrese el código del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
        String categoria = JOptionPane.showInputDialog("Ingrese la categoría del producto:");
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock disponible:"));

        tienda.agregarProducto(new Producto(nombre, codigo, precio, categoria, stock));
        JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");
    }

    private static void agregarCliente(Tienda tienda) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String id = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");
        String email = JOptionPane.showInputDialog("Ingrese el email del cliente:");

        tienda.agregarCliente(new Cliente(nombre, id, direccion, telefono, email));
        JOptionPane.showMessageDialog(null, "Cliente agregado con éxito.");
    }

    private static void realizarVenta(Tienda tienda) {
        String idCliente = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        String codigoProducto = JOptionPane.showInputDialog("Ingrese el código del producto:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a comprar:"));

        tienda.realizarVenta(idCliente, codigoProducto, cantidad);
    }

    private static void listarProductos(Tienda tienda) {
        JOptionPane.showMessageDialog(null, tienda.obtenerListaProductos());
    }

    private static void listarClientes(Tienda tienda) {
        JOptionPane.showMessageDialog(null, tienda.obtenerListaClientes());
    }

    private static void listarVentas(Tienda tienda) {
        JOptionPane.showMessageDialog(null, tienda.obtenerListaVentas());
    }

    private static void eliminarProducto(Tienda tienda) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del producto a eliminar:");
        JOptionPane.showMessageDialog(null, tienda.eliminarProducto(codigo));
    }

    private static void eliminarCliente(Tienda tienda) {
        String id = JOptionPane.showInputDialog("Ingrese la identificación del cliente a eliminar:");
        JOptionPane.showMessageDialog(null, tienda.eliminarCliente(id));
    }

    private static void actualizarProducto(Tienda tienda) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del producto a actualizar:");
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto:");
        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del producto:"));
        String nuevaCategoria = JOptionPane.showInputDialog("Ingrese la nueva categoría:");
        int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock:"));

        JOptionPane.showMessageDialog(null, tienda.actualizarProducto(codigo, nuevoNombre, nuevoPrecio, nuevaCategoria, nuevoStock));
    }

    private static void actualizarCliente(Tienda tienda) {
        String id = JOptionPane.showInputDialog("Ingrese la identificación del cliente a actualizar:");
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente:");
        String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono:");
        String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección:");
        String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email:");

        JOptionPane.showMessageDialog(null, tienda.actualizarCliente(id, nuevoNombre, nuevoTelefono, nuevaDireccion, nuevoEmail));
    }
}
