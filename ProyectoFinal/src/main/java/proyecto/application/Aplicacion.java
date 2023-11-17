package proyecto.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import proyecto.controllers.*;
import proyecto.model.Actividad;
import proyecto.model.Herramienta;
import proyecto.model.Proceso;
import proyecto.model.Usuario;

import java.io.IOException;

import static proyecto.controllers.AppController.INSTANCE;

public class Aplicacion extends Application {

    private static Stage primaryStage;
    Herramienta herramienta = INSTANCE.getHerramienta();

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
        if (primaryStage != null) {
            primaryStage.setScene(newScene);
            primaryStage.show();
        } else {
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
            loader.setLocation(Aplicacion.class.getResource("RecuperarContrasenia.fxml"));

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




    public void mostrarVentanaProcesosAdmin(Usuario usuario) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("ProcesosAdmin.fxml"));

            AnchorPane rootLayout = loader.load();

            ProcesosAdminController procesosAdminController = loader.getController();
            procesosAdminController.setAplicacion(this);
            procesosAdminController.setUsuario(usuario);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void mostrarVentanaActividadesAdmin() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("ActividadesAdmin.fxml"));

            AnchorPane rootLayout = loader.load();

            ActividadesAdminController actividadesAdminController = loader.getController();
            actividadesAdminController.setAplicacion(this);


            Scene scene = new Scene(rootLayout);
            changeWindow(scene);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public void mostrarVentanaTareasAdmin() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("TareasAdmin.fxml"));

            AnchorPane rootLayout = loader.load();

            TareasAdminController tareasAdminController = loader.getController();
            tareasAdminController.setAplicacion(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
