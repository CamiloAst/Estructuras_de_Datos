package proyecto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import proyecto.application.Aplicacion;
import proyecto.model.Herramienta;
import proyecto.model.TipoUsuario;
import proyecto.utils.ShowMessage;

import static proyecto.controllers.AppController.INSTANCE;

public class RegistrarseController {

    Herramienta herramienta = INSTANCE.getHerramienta();

    Aplicacion aplicacion;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtNombreUsuario;
    @FXML
    private TextField txtEmail;





    @FXML
    void registrarseAction(ActionEvent event) {
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        String email = txtEmail.getText();

        if (nombreUsuario.isEmpty() || contrasenia.isEmpty()) {
            ShowMessage.mostrarMensaje("Error", "Campos vacios", "Por favor ingrese todos los datos");
        } else {
            herramienta.createUser(nombreUsuario, contrasenia, TipoUsuario.REGULAR, email);
            ShowMessage.mostrarMensaje("Exito", "Usuario registrado", "El usuario se ha registrado exitosamente");
            aplicacion.mostrarVentanaIniciarHerramienta();
        }
    }


    @FXML
    void initialize() {

    }
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

}

