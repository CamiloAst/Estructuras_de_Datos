package proyecto.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import proyecto.model.Herramienta;
import proyecto.model.Usuario;

import static proyecto.controllers.AppController.INSTANCE;

public class RegistrarseController {

    /*
    Usuario usuario = INSTANCE.getHerramienta().getListaUsiarios();

     */

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtNombreUsuario;




/*
    @FXML
    void registrarseAction(ActionEvent event) {
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasenia = txtContrasenia.getText();

        if (nombreUsuario.isEmpty() || contrasenia.isEmpty()) {
            mostrarMensaje("Error", "Campos vacios", "Por favor ingrese todos los datos", Alert.AlertType.ERROR);
        } else {
            Usuario usuario = new Usuario(nombreUsuario, contrasenia, );
            if (Herramienta.createUser(usuario)
                mostrarMensaje("Exito", "Usuario registrado", "El usuario se ha registrado exitosamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", "Usuario no registrado", "El usuario no se ha registrado", Alert.AlertType.ERROR);
            }
        }
*/





    private void mostrarMensaje(String titulo, String encabezado, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }





    @FXML
    void initialize() {
        assert btnRegistrarse != null : "fx:id=\"btnRegistrarse\" was not injected: check your FXML file 'Registrarse.fxml'.";
        assert txtContrasenia != null : "fx:id=\"txtContrasenia\" was not injected: check your FXML file 'Registrarse.fxml'.";
        assert txtNombreUsuario != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'Registrarse.fxml'.";

    }

}

