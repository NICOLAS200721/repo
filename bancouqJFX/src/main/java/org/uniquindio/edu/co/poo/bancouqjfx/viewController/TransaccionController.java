package org.uniquindio.edu.co.poo.bancouqjfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.bancouqjfx.App;
import org.uniquindio.edu.co.poo.bancouqjfx.model.*;

import java.util.HashMap;
import java.util.Map;

public class TransaccionController {

    @FXML private TextField txtCuentaOrigen;
    @FXML private TextField txtCuentaDestino;
    @FXML private TextField txtMonto;
    @FXML private Button btnTransferir;
    @FXML private Button btnEliminar;
    @FXML private Label lblResultado;
    @FXML private TextArea areaHistorial;

    private Map<String, CuentaBancaria> cuentas = new HashMap<>();
    private GestorTransacciones gestor = new GestorTransacciones();

    public void initialize() {
        // Cuentas de prueba
        cuentas.put("123", new CuentaBancaria("123", 1000.0));
        cuentas.put("456", new CuentaBancaria("456", 500.0));
    }

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    public void realizarTransaccion() {
        String origen = txtCuentaOrigen.getText().trim();
        String destino = txtCuentaDestino.getText().trim();
        double monto;

        try {
            monto = Double.parseDouble(txtMonto.getText().trim());
        } catch (NumberFormatException e) {
            lblResultado.setText("❌ Monto inválido.");
            return;
        }

        CuentaBancaria cuentaOrigen = cuentas.get(origen);
        CuentaBancaria cuentaDestino = cuentas.get(destino);

        boolean exito = gestor.realizarTransaccion(cuentaOrigen, cuentaDestino, monto);

        if (exito) {
            lblResultado.setText("✅ Transacción exitosa.");
        } else {
            lblResultado.setText("❌ Transacción fallida.");
        }

        actualizarHistorial();
    }

    @FXML
    public void eliminarTransaccion() {
        String origen = txtCuentaOrigen.getText().trim();
        String destino = txtCuentaDestino.getText().trim();

        // Se elimina desde el gestor
        boolean eliminado = gestor.getHistorialTransacciones().removeIf(t ->
                t.getCuentaOrigen().equals(origen) && t.getCuentaDestino().equals(destino)
        );

        if (eliminado) {
            lblResultado.setText("✅ Transacción eliminada.");
        } else {
            lblResultado.setText("❌ No se encontró la transacción.");
        }

        actualizarHistorial();
    }

    private void actualizarHistorial() {
        areaHistorial.clear();
        for (GestorTransacciones.Transaccion t : gestor.getHistorialTransacciones()) {
            areaHistorial.appendText(t.toString() + "\n");
        }
    }
    @FXML
    public void actualizarTransaccion() {
        String origen = txtCuentaOrigen.getText().trim();
        String destino = txtCuentaDestino.getText().trim();
        double monto;

        try {
            monto = Double.parseDouble(txtMonto.getText().trim());
        } catch (NumberFormatException e) {
            lblResultado.setText("❌ Monto inválido.");
            return;
        }

        for (GestorTransacciones.Transaccion t : gestor.getHistorialTransacciones()) {
            if (t.getCuentaOrigen().equals(origen) && t.getCuentaDestino().equals(destino)) {
                t.setMonto(monto);
                t.setFechaHora(java.time.LocalDateTime.now());
                lblResultado.setText("✅ Transacción actualizada.");
                actualizarHistorial();
                return;
            }
        }

        lblResultado.setText("❌ Transacción no encontrada para actualizar.");
    }
//    @FXML
//    public void volverAPrincipal() {
//        if (app != null) {
//            app.openViewPrincipal();
//        }
//    }
}