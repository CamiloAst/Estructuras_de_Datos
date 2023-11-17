package proyecto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import proyecto.application.Aplicacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    public void registrarseAction(MouseEvent mouseEvent) {
        aplicacion.mostrarVentanaRegistrarse();
    }

    @FXML
    void initialize() {
        assert btnAdministrador != null : "fx:id=\"btnAdministrador\" was not injected: check your FXML file 'Acceder.fxml'.";
        assert btnRegular != null : "fx:id=\"btnRegular\" was not injected: check your FXML file 'Acceder.fxml'.";
        assert registrarse != null : "fx:id=\"registrarse\" was not injected: check your FXML file 'Acceder.fxml'.";

    }


}

