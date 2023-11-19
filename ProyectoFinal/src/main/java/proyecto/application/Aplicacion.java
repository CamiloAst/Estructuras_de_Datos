package proyecto.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import proyecto.controllers.*;
import proyecto.model.Herramienta;

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

            INSTANCE.setUsuarioActual(null);

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




    public void mostrarVentanaProcesosAdmin() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("ProcesosAdmin.fxml"));

            AnchorPane rootLayout = loader.load();

            ProcesosController procesosController = loader.getController();
            procesosController.setAplicacion(this);


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

            ActividadesController actividadesController = loader.getController();
            actividadesController.setAplicacion(this);


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
            loader.setLocation(Aplicacion.class.getResource("Tareas.fxml"));

            AnchorPane rootLayout = loader.load();

            TareasController tareasController = loader.getController();
            tareasController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaConfiguracion() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("Configuraciones.fxml"));

            AnchorPane rootLayout = loader.load();

            ConfiguracionesController configuracionesController = loader.getController();
            configuracionesController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mostrarVentanaRegistrarse() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("Registrarse.fxml"));

            AnchorPane rootLayout = loader.load();

            RegistrarseController registrarseController = loader.getController();
            registrarseController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
