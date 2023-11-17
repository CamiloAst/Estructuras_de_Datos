package proyecto.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import proyecto.application.Aplicacion;
import proyecto.exceptions.UserDoesntExistException;
import proyecto.model.Herramienta;
import proyecto.utils.ShowMessage;

import java.net.URL;
import java.util.ResourceBundle;

import static proyecto.controllers.AppController.INSTANCE;

public class RecuperarContraseniaController {


    Herramienta herramienta = INSTANCE.getHerramienta();

    @FXML
    private Button btnActualizarContrasenia;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;


    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private PasswordField txtNuevaContrasenia;

    Aplicacion aplicacion;

    public  void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }


    @FXML
    void ingresarAction(ActionEvent event) {

        aplicacion.mostrarVentanaLoginAdmin();


    }

    @FXML
    void actualizarContraseniaAction(ActionEvent event) {
        String nombreUsuario = txtNombreUsuario.getText();
        String nuevaContrasenia = txtNuevaContrasenia.getText();

        try {
            herramienta.updatePassword(nombreUsuario, nuevaContrasenia);
            ShowMessage.mostrarMensaje("Exito", "Contrasenia actualizada", "La contrasenia se ha actualizado exitosamente");
            aplicacion.mostrarVentanaLoginAdmin();
        } catch (UserDoesntExistException e) {
            ShowMessage.mostrarMensaje("Error", "Usuario no existe", "El usuario no existe");
        }
    }

    @FXML
    void initialize() {
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'RecuperarContrasenia.fxml'.";
        assert txtNombreUsuario != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'RecuperarContrasenia.fxml'.";
        assert txtNuevaContrasenia != null : "fx:id=\"txtNuevaContrasenia\" was not injected: check your FXML file 'RecuperarContrasenia.fxml'.";

    }

}

