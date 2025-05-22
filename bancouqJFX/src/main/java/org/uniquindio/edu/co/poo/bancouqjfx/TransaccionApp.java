package org.uniquindio.edu.co.poo.bancouqjfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.bancouqjfx.model.CuentaBancaria;
import org.uniquindio.edu.co.poo.bancouqjfx.model.GestorTransacciones;

import java.util.HashMap;
import java.util.Map;

public class TransaccionApp extends Application {

    private Map<String, CuentaBancaria> cuentas = new HashMap<>();
    private GestorTransacciones gestor = new GestorTransacciones();

    @Override
    public void start(Stage primaryStage) {
        // Cuentas de prueba
        cuentas.put("123", new CuentaBancaria("123", 1000.0));
        cuentas.put("456", new CuentaBancaria("456", 500.0));

        // Controles de la interfaz
        TextField txtCuentaOrigen = new TextField();
        txtCuentaOrigen.setPromptText("Cuenta origen");

        TextField txtCuentaDestino = new TextField();
        txtCuentaDestino.setPromptText("Cuenta destino");

        TextField txtMonto = new TextField();
        txtMonto.setPromptText("Monto");

        Button btnTransferir = new Button("Transferir");

        Label lblResultado = new Label();
        TextArea areaHistorial = new TextArea();
        areaHistorial.setEditable(false);

        btnTransferir.setOnAction(e -> {
            String origen = txtCuentaOrigen.getText().trim();
            String destino = txtCuentaDestino.getText().trim();
            double monto;

            try {
                monto = Double.parseDouble(txtMonto.getText());
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Monto inválido.");
                return;
            }

            CuentaBancaria cuentaOrigen = cuentas.get(origen);
            CuentaBancaria cuentaDestino = cuentas.get(destino);

            boolean exito = gestor.realizarTransaccion(cuentaOrigen, cuentaDestino, monto);

            if (exito) {
                lblResultado.setText("✅ Transacción exitosa.");
                areaHistorial.clear();
                for (GestorTransacciones.Transaccion t : gestor.getHistorialTransacciones()) {
                    areaHistorial.appendText(t.toString() + "\n");
                }
            } else {
                lblResultado.setText("❌ Transacción fallida.");
            }
        });

        VBox root = new VBox(10,
                new Label("Cuenta Origen:"), txtCuentaOrigen,
                new Label("Cuenta Destino:"), txtCuentaDestino,
                new Label("Monto:"), txtMonto,
                btnTransferir,
                lblResultado,
                new Label("Historial de transacciones:"),
                areaHistorial
        );
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setTitle("Transacciones Bancarias");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}