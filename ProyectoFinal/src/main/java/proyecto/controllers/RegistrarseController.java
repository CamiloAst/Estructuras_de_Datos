package proyecto.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrarseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    void ingresarContraseniaAction(ActionEvent event) {

    }

    @FXML
    void ingresarNombreUsuarioAction(ActionEvent event) {

    }

    @FXML
    void registrarseAction(ActionEvent event) {



    }

    @FXML
    void initialize() {
        assert btnRegistrarse != null : "fx:id=\"btnRegistrarse\" was not injected: check your FXML file 'Registrarse.fxml'.";
        assert txtContrasenia != null : "fx:id=\"txtContrasenia\" was not injected: check your FXML file 'Registrarse.fxml'.";
        assert txtNombreUsuario != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'Registrarse.fxml'.";

    }

}

