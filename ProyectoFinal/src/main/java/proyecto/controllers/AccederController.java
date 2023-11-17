package proyecto.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import proyecto.application.Aplicacion;

public class AccederController {
        private final Aplicacion aplicacion = new Aplicacion();

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnAdministrador;

        @FXML
        private Button btnRegular;

        @FXML
        private Label registrarse;

        @FXML
        void ingresarAdminAction(ActionEvent event) {
            aplicacion.mostrarVentanaLoginAdmin();

        }
        @FXML
        void ingresarRegularAction(ActionEvent event) {
            aplicacion.mostrarVentanaLoginAdmin();
        }


        @FXML
        void registrarseAction(ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("../views/Registrarse.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Registro");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();

        }



    @FXML
        void initialize() {
            assert btnAdministrador != null : "fx:id=\"btnAdministrador\" was not injected: check your FXML file 'Acceder.fxml'.";
            assert btnRegular != null : "fx:id=\"btnRegular\" was not injected: check your FXML file 'Acceder.fxml'.";
            assert registrarse != null : "fx:id=\"registrarse\" was not injected: check your FXML file 'Acceder.fxml'.";

        }


    }

