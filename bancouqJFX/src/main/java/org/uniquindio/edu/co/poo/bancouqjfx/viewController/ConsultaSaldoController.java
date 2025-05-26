package org.uniquindio.edu.co.poo.bancouqjfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.bancouqjfx.App;
import org.uniquindio.edu.co.poo.bancouqjfx.model.CuentaBancaria;

public class ConsultaSaldoController {

    @FXML
    private TextField identificadorField;

    @FXML
    private Label saldoLabel;

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    public void consultarSaldo() {
        String id = identificadorField.getText().trim();

        if (id.isEmpty()) {
            saldoLabel.setText("Ingrese un número de cuenta válido.");
            saldoLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        CuentaBancaria cuentaEncontrada = buscarCuenta(id);

        if (cuentaEncontrada != null) {
            saldoLabel.setText("$" + String.format("%.2f", cuentaEncontrada.getSaldo()));
            saldoLabel.setStyle("-fx-text-fill: green;");
        } else {
            saldoLabel.setText("Cuenta no encontrada.");
            saldoLabel.setStyle("-fx-text-fill: red;");
        }
    }

    private CuentaBancaria buscarCuenta(String numeroCuenta) {
        for (CuentaBancaria cuenta : App.banco.getListaCuentas()) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

//    @FXML
//    public void volverAPrincipal() {
//        if (app != null) {
//            app.openViewPrincipal();
//        }
//    }
}