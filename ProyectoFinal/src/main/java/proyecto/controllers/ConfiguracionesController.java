package proyecto.controllers;

import proyecto.application.Aplicacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto.model.Usuario;

public class ConfiguracionesController {

    Aplicacion aplicacion;



    @FXML
    private ImageView atras;

    @FXML
    private ComboBox<String> comboBoxNotificacion;

    @FXML
    private Label contrasenia;

    @FXML
    private Label guardar;

    @FXML
    private Label nombreUsuario;

    @FXML
    private Label tipoUsuario;

    @FXML
    void atrasEvent(MouseEvent event) {
        aplicacion.mostrarVentanaIniciarHerramienta();
    }

    @FXML
    void guardarAction(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert atras != null : "fx:id=\"atras\" was not injected: check your FXML file 'Configuraciones.fxml'.";
        assert comboBoxNotificacion != null : "fx:id=\"comboBoxNotificacion\" was not injected: check your FXML file 'Configuraciones.fxml'.";
        assert contrasenia != null : "fx:id=\"contrasenia\" was not injected: check your FXML file 'Configuraciones.fxml'.";
        assert guardar != null : "fx:id=\"guardar\" was not injected: check your FXML file 'Configuraciones.fxml'.";
        assert nombreUsuario != null : "fx:id=\"nombreUsuario\" was not injected: check your FXML file 'Configuraciones.fxml'.";
        assert tipoUsuario != null : "fx:id=\"tipoUsuario\" was not injected: check your FXML file 'Configuraciones.fxml'.";

        comboBoxNotificacion.getItems().addAll("Por correo", "En la aplicacion");

    }
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
}
