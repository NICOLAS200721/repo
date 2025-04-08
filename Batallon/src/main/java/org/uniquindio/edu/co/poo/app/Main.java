package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Batallon batallon = new Batallon("Batallón 1", "Ubicación A");
        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "----- Menú -----\n" +
                            "1. Registrar vehículo\n" +
                            "2. Registrar misión\n" +
                            "3. Listar vehículos registrados\n" +
                            "4. Mostrar vehículos con más de 50 misiones\n" +
                            "5. Salir\n" +
                            "Elige una opción:");

            switch (opcion) {
                case "1":
                    registrarVehiculo(batallon);
                    break;
                case "2":
                    registrarMision(batallon);
                    break;
                case "3":
                    listarVehiculos(batallon);
                    break;
                case "4":
                    mostrarVehiculosMas50Misiones(batallon);
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, intenta nuevamente.");
            }
        }
    }

    private static void registrarVehiculo(Batallon batallon) {
        String id = JOptionPane.showInputDialog("ID del vehículo:");
        String modelo = JOptionPane.showInputDialog("Modelo del vehículo:");
        int añoFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Año de fabricación:"));
        int kilometraje = Integer.parseInt(JOptionPane.showInputDialog("Kilometraje:"));
        String estadoOperativo = JOptionPane.showInputDialog("Estado operativo:");

        String tipoVehiculo = JOptionPane.showInputDialog(
                "Tipo de vehículo (1. Transporte de tropas, 2. Vehículo blindado, 3. Vehículo de apoyo):");

        Vehiculo vehiculo = null;
        switch (tipoVehiculo) {
            case "1":
                int capacidadSoldados = Integer.parseInt(JOptionPane.showInputDialog("Capacidad de soldados:"));
                vehiculo = new transporteTropas(id, modelo, añoFabricacion, kilometraje, estadoOperativo, capacidadSoldados);
                break;
            case "2":
                String nivelBlindaje = JOptionPane.showInputDialog("Nivel de blindaje:");
                vehiculo = new vehiculoBlindado(id, modelo, añoFabricacion, kilometraje, estadoOperativo, nivelBlindaje);
                break;
            case "3":
                String tipoFuncion = JOptionPane.showInputDialog("Tipo de función:");
                vehiculo = new vehiculoApoyo(id, modelo, añoFabricacion, kilometraje, estadoOperativo, tipoFuncion);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de vehículo no válido.");
                return;
        }

        if (batallon.registrarVehiculo(vehiculo)) {
            JOptionPane.showMessageDialog(null, "Vehículo registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "El vehículo ya está registrado.");
        }
    }

    private static void registrarMision(Batallon batallon) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = JOptionPane.showInputDialog("Fecha de la misión (en formato YYYY-MM-DD):");
            Date fecha = sdf.parse(fechaString);

            String ubicacion = JOptionPane.showInputDialog("Ubicación de la misión:");
            String personalAsignado = JOptionPane.showInputDialog("Personal asignado:");

            List<Vehiculo> vehiculosSeleccionados = new ArrayList<>();
            List<Vehiculo> listaVehiculos = batallon.getListaVehiculos();
            for (int i = 0; i < listaVehiculos.size(); i++) {
                JOptionPane.showMessageDialog(null, (i + 1) + ". " + listaVehiculos.get(i));
            }

            String vehiculosSeleccionadosStr = JOptionPane.showInputDialog("Introduce los números de los vehículos (separados por comas):");
            String[] vehiculosIds = vehiculosSeleccionadosStr.split(",");

            for (String id : vehiculosIds) {
                try {
                    int indice = Integer.parseInt(id.trim()) - 1;
                    if (indice >= 0 && indice < listaVehiculos.size()) {
                        vehiculosSeleccionados.add(listaVehiculos.get(indice));
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Número de vehículo inválido.");
                }
            }

            Mision mision = new Mision(fecha, ubicacion, personalAsignado, vehiculosSeleccionados);
            batallon.registrarMision(mision);
            JOptionPane.showMessageDialog(null, "Misión registrada con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la fecha o entrada.");
        }
    }

    private static void listarVehiculos(Batallon batallon) {
        StringBuilder sb = new StringBuilder();
        List<Vehiculo> vehiculos = batallon.getListaVehiculos();
        for (Vehiculo vehiculo : vehiculos) {
            sb.append(vehiculo).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No hay vehículos registrados.");
    }

    private static void mostrarVehiculosMas50Misiones(Batallon batallon) {
        List<Vehiculo> vehiculosConMas50Misiones = batallon.obtenerVehiculosMas50Misiones();
        if (vehiculosConMas50Misiones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos con más de 50 misiones.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Vehiculo vehiculo : vehiculosConMas50Misiones) {
                sb.append(vehiculo).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}