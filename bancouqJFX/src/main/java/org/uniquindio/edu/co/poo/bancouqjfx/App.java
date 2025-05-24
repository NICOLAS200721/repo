package org.uniquindio.edu.co.poo.bancouqjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import org.uniquindio.edu.co.poo.bancouqjfx.model.Cliente;
import org.uniquindio.edu.co.poo.bancouqjfx.model.Banco;
import org.uniquindio.edu.co.poo.bancouqjfx.viewController.*;

public class App extends Application {

    private Stage primaryStage;
    public static Banco banco = new Banco("UQ");

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestión de Clientes y Transacciones");
        openViewPrincipal();
    }

    public void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/org/uniquindio/edu/co/poo/bancouqjfx/primary.fxml"));
            AnchorPane rootLayout = loader.load();

            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/org/uniquindio/edu/co/poo/bancouqjfx/crudCliente.fxml"));
            AnchorPane rootLayout = loader.load();

            // Aquí asignamos la referencia app al controlador para que pueda usar openViewPrincipal()
            ClienteViewController controller = loader.getController();
            controller.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openTransaccionView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/org/uniquindio/edu/co/poo/bancouqjfx/transaccionview.fxml"));
            AnchorPane rootLayout = loader.load();

            TransaccionController controller = loader.getController();
            controller.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCuentaView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/org/uniquindio/edu/co/poo/bancouqjfx/agregarCuenta.fxml"));
            AnchorPane rootLayout = loader.load();

            CuentaController controller = loader.getController();
            controller.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openEmpleadoView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/org/uniquindio/edu/co/poo/bancouqjfx/empleado.fxml"));
            AnchorPane rootLayout = loader.load();

            // Aquí obtienes el controlador y le pasas la instancia 'app'
            EmpleadoController controller = loader.getController();
            controller.setApp(this);  // IMPORTANTE para que el botón volver funcione

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openConsultaSaldoView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/org/uniquindio/edu/co/poo/bancouqjfx/consultaSaldo.fxml"));

            // CAMBIO: usar VBox si ese es el contenedor raíz
            VBox rootLayout = loader.load();

            ConsultaSaldoController controller = loader.getController();
            controller.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Consulta de Saldo");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inicializarData() {
        Cliente cliente = new Cliente("Juan", "Pérez", "1223", "juanp@gmail.com", "254695");
        banco.agregarCliente(cliente);
    }

    public static void main(String[] args) {
        launch();
    }
}
