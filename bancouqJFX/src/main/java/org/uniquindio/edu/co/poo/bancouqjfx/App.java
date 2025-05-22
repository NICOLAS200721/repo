package org.uniquindio.edu.co.poo.bancouqjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import org.uniquindio.edu.co.poo.bancouqjfx.model.Cliente;
import org.uniquindio.edu.co.poo.bancouqjfx.model.Banco;
import org.uniquindio.edu.co.poo.bancouqjfx.viewController.CuentaController;
import org.uniquindio.edu.co.poo.bancouqjfx.viewController.PrimaryController;
import org.uniquindio.edu.co.poo.bancouqjfx.viewController.TransaccionController;

public class App extends Application {

    private Stage primaryStage;
    public static Banco banco = new Banco("UQ");

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestión de Clientes y Transacciones");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            AnchorPane rootLayout = loader.load(); // 👈 CAMBIO AQUÍ

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
            loader.setLocation(App.class.getResource("crudCliente.fxml"));
            AnchorPane rootLayout = loader.load();
            // ClienteViewController controller = loader.getController();
            // controller.setApp(this);

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
            loader.setLocation(App.class.getResource("transaccionview.fxml"));
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

    public void inicializarData() {
        Cliente cliente = new Cliente("Juan", "Pérez", "1223", "juanp@gmail.com", "254695");
        banco.agregarCliente(cliente);
    }
    public void openCuentaView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("cuenta.fxml"));
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

    public static void main(String[] args) {
        launch();
    }
}