package proyecto.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import proyecto.controllers.*;
import proyecto.model.Herramienta;

import java.io.IOException;

public class Aplicacion extends Application {

    private Stage primaryStage;



    Herramienta herramienta = new Herramienta ("herrammienta Estu y yo");

    public void mostrarVentanaLoginRegular() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("LoginRegular.fxml"));

            AnchorPane rootLayout = (AnchorPane)loader.load();

            LoginRegularController loginRegularController = loader.getController();
            loginRegularController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void mostrarVentanaLoginAdmin() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("Login.fxml"));

            AnchorPane rootLayout = loader.load();

            LoginController loginController = loader.getController();
            loginController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("herrammienta Estu y yo");

        mostrarVentanaIniciarHerramienta();

    }


    public void mostrarVentanaIniciarHerramienta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("Acceder.fxml"));

            AnchorPane rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void mostrarVentanaRecuperarContrasenia() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("RestablecerContrasenia.fxml"));

            AnchorPane rootLayout = (AnchorPane)loader.load();

            RecuperarContraseniaController recuperarContraseniaController = loader.getController();
            recuperarContraseniaController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void mostrarVentanaProcesosUsuario(String usuario) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("RedPrincipal.fxml"));

            AnchorPane rootLayout = (AnchorPane)loader.load();

            ProcesosAdminController procesosUsuarioController = loader.getController();
            procesosUsuarioController.setAplicacion(this);
            procesosUsuarioController.setUsuario(usuario);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean verificarUsuario(String NombreUsuario, String contrasenia) {
        return Herramienta.existeUsuario(NombreUsuario);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

