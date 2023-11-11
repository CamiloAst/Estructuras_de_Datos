package proyecto.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import proyecto.controllers.*;
import proyecto.model.Herramienta;
import proyecto.model.Usuario;

import java.io.IOException;

public class Aplicacion extends Application {

    private static Stage primaryStage;
    Herramienta herramienta = new Herramienta ("herrammienta Estu y yo");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Aplicacion.primaryStage = primaryStage;
        Aplicacion.primaryStage.setTitle("herrammienta Estu y yo");

        mostrarVentanaIniciarHerramienta();
    }

    public void changeWindow(Scene newScene) {
        if(primaryStage != null){
            primaryStage.setScene(newScene);
            primaryStage.show();
        }else{
            System.out.println("primaryStage es null");
        }
    }

    public void mostrarVentanaIniciarHerramienta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("Acceder.fxml"));

            AnchorPane rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void mostrarVentanaLoginRegular() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("LoginRegular.fxml"));

            AnchorPane rootLayout = loader.load();


            Scene scene = new Scene(rootLayout);
            changeWindow(scene);
            LoginRegularController loginRegularController = loader.getController();
            loginRegularController.setAplicacion(this);
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
            changeWindow(scene);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void mostrarVentanaRecuperarContrasenia() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("RestablecerContrasenia.fxml"));

            AnchorPane rootLayout = loader.load();

            RecuperarContraseniaController recuperarContraseniaController = loader.getController();
            recuperarContraseniaController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void mostrarVentanaProcesosUsuario(Usuario usuario) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("RedPrincipal.fxml"));

            AnchorPane rootLayout = (AnchorPane)loader.load();

            ProcesosAdminController procesosUsuarioController = loader.getController();
            procesosUsuarioController.setAplicacion(this);
            procesosUsuarioController.setUsuario(usuario);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

