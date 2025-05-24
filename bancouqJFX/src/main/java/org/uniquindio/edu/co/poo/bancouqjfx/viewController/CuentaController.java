package org.uniquindio.edu.co.poo.bancouqjfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.bancouqjfx.App;
import org.uniquindio.edu.co.poo.bancouqjfx.model.Banco;
import org.uniquindio.edu.co.poo.bancouqjfx.model.CuentaBancaria;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CuentaController {

    @FXML private TextField txtNumeroCuenta;
    @FXML private TextField txtSaldo;
    @FXML private Label lblMensaje;
    @FXML private ListView<CuentaBancaria> listaCuentas;

    private Banco banco;
    private App app; // 👈 Atributo que necesitas

    // 👇 Este método es necesario para poder usar controller.setApp(this)
    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    public void initialize() {
        this.banco = App.banco;
        actualizarVistaCuentas();
    }

    @FXML
    public void agregarCuenta() {
        String numero = txtNumeroCuenta.getText().trim();
        double saldo;

        try {
            saldo = Double.parseDouble(txtSaldo.getText().trim());
        } catch (NumberFormatException e) {
            lblMensaje.setText("❌ Saldo inválido.");
            return;
        }

        CuentaBancaria cuenta = new CuentaBancaria(numero, saldo);

        if (banco.agregarCuenta(cuenta)) {
            lblMensaje.setText("✅ Cuenta agregada.");
            limpiarCampos();
            actualizarVistaCuentas();
        } else {
            lblMensaje.setText("❌ La cuenta ya existe.");
        }
    }

    @FXML
    public void eliminarCuenta() {
        String numero = txtNumeroCuenta.getText().trim();

        if (banco.eliminarCuentas(numero)) {
            lblMensaje.setText("✅ Cuenta eliminada.");
            limpiarCampos();
            actualizarVistaCuentas();
        } else {
            lblMensaje.setText("❌ Cuenta no encontrada.");
        }
    }

    @FXML
    public void actualizarCuenta() {
        String numero = txtNumeroCuenta.getText().trim();
        double saldo;

        try {
            saldo = Double.parseDouble(txtSaldo.getText().trim());
        } catch (NumberFormatException e) {
            lblMensaje.setText("❌ Saldo inválido.");
            return;
        }

        CuentaBancaria actualizada = new CuentaBancaria(numero, saldo);

        if (banco.actualizarCuentas(numero, actualizada)) {
            lblMensaje.setText("✅ Cuenta actualizada.");
            limpiarCampos();
            actualizarVistaCuentas();
        } else {
            lblMensaje.setText("❌ Cuenta no encontrada.");
        }
    }

    @FXML
    public void seleccionarCuenta(MouseEvent event) {
        CuentaBancaria cuenta = listaCuentas.getSelectionModel().getSelectedItem();
        if (cuenta != null) {
            txtNumeroCuenta.setText(cuenta.getNumeroCuenta());
            txtSaldo.setText(String.valueOf(cuenta.getSaldo()));
        }
    }

    private void actualizarVistaCuentas() {
        ObservableList<CuentaBancaria> cuentas = FXCollections.observableArrayList(banco.getListaCuentas());
        listaCuentas.setItems(cuentas);
    }

    private void limpiarCampos() {
        txtNumeroCuenta.clear();
        txtSaldo.clear();
        listaCuentas.getSelectionModel().clearSelection();
    }
    @FXML
    public void volverAPrincipal() {
        if (app != null) {
            app.openViewPrincipal();
        }
    }
}
