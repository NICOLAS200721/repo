package org.uniquindio.edu.co.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tienda {

    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Venta> listaVentas = new ArrayList<>();

    // Agregar un producto al inventario
    public void agregarProducto(Producto productoAux) {
        listaProductos.add(productoAux);
    }


    // Agregar un cliente a la lista
    public void agregarCliente(Cliente clienteAux) {
        if (clienteAux != null) {
            listaClientes.add(clienteAux);
            System.out.println("Cliente agregado correctamente.");
        } else {
            System.out.println("Error: El cliente no puede ser null.");
        }
    }

    // Registrar una venta usando for normales
    public void realizarVenta(String idCliente, String codigoProducto, int cantidad) {
        Cliente cliente = null;
        Producto producto = null;

        // Buscar cliente en la lista con un bucle for
        for (Cliente clienteAux : listaClientes) {
            if (clienteAux.getIdentificacion().equals(idCliente)) {
                cliente = clienteAux;
                break; // Se encontró el cliente, no es necesario seguir buscando
            }
        }

        // Buscar producto en la lista con un bucle for
        for (Producto productoAux : listaProductos) {
            if (productoAux.getCodigo().equals(codigoProducto)) {
                producto = productoAux;
                break; // Se encontró el producto, no es necesario seguir buscando
            }
        }

        // Validaciones
        if (cliente == null) {
            System.out.println("Error: Cliente no encontrado.");
            return;
        }

        if (producto == null) {
            System.out.println("Error: Producto no encontrado.");
            return;
        }

        if (producto.getStock() < cantidad) {
            System.out.println("Error: Stock insuficiente para la venta.");
            return;
        }

        // Procesar la venta
        producto.reducirStock(cantidad);
        Venta venta = new Venta(LocalDate.now(), cliente, producto, cantidad);
        listaVentas.add(venta);

        System.out.println("Venta realizada con éxito.");
    }


    // Listar productos
    public String obtenerListaProductos() {
        if (listaProductos.isEmpty()) {
            return "No hay productos registrados.";
        }

        String resultado = "Productos en Inventario:\n";
        for (Producto productoAux : listaProductos) {
            resultado += productoAux.toString() + "\n";
        }
        return resultado;
    }


    // Listar clientes
    public String obtenerListaClientes() {
        if (listaClientes.isEmpty()) {
            return "No hay clientes registrados.";
        }

        String resultado = "Clientes Registrados:\n";
        for (Cliente clienteAux : listaClientes) {
            resultado += clienteAux.toString() + "\n"; // Concatenación de strings
        }
        return resultado;
    }

    // Listar ventas
    public String obtenerListaVentas() {
        if (listaVentas.isEmpty()) {
            return "No hay ventas registradas.";
        }

        String resultado = "Ventas Realizadas:\n";
        for (Venta ventaAux : listaVentas) {
            resultado += ventaAux.toString() + "\n"; // Concatenación de strings
        }
        return resultado;
    }


    // Eliminar cliente por ID
    public String eliminarCliente(String identificacion) {
        for (Cliente clienteAux : listaClientes) {
            if (clienteAux != null && clienteAux.getIdentificacion().equals(identificacion)) {
                listaClientes.remove(clienteAux);
                return "Cliente eliminado.";
            }
        }
        return "Cliente no encontrado.";
    }

    //Eliminar producto por codigo

    public String eliminarProducto(String codigo) {
        for (Producto productoAux : listaProductos) {
            if (productoAux != null && productoAux.getCodigo().equals(codigo)) {
                listaProductos.remove(productoAux);
                return "Producto eliminado.";
            }
        }
        return "Producto no encontrado.";
    }

    public String actualizarCliente(String identificacion, String nuevoNombre, String nuevoTelefono, String nuevaDireccion, String nuevoEmail) {
        for (Cliente clienteAux : listaClientes) { // Recorre la lista de clientes
            if (clienteAux != null && clienteAux.getIdentificacion().equals(identificacion)) {
                // Actualiza los datos del cliente
                clienteAux.setNombre(nuevoNombre);
                clienteAux.setTelefono(nuevoTelefono);
                clienteAux.setDireccion(nuevaDireccion);
                clienteAux.setEmail(nuevoEmail);
                return "Cliente actualizado correctamente.";
            }
        }
        return "Cliente no encontrado.";
    }

    public String actualizarProducto(String codigo, String nuevoNombre, double nuevoPrecio, String nuevaCategoria, int nuevoStock) {
        for (Producto productoAux : listaProductos) { // Recorre la lista de productos
            if (productoAux != null && productoAux.getCodigo().equals(codigo)) { // Busca el producto por el código

                // Actualiza los datos del producto
                productoAux.setNombre(nuevoNombre);
                productoAux.setPrecio(nuevoPrecio);
                productoAux.setCategoria(nuevaCategoria);
                productoAux.setStock(nuevoStock);
                return "Producto actualizado correctamente";
            }
        }
        return "Producto no encontrado"; // Si no se encuentra el producto
    }


}