package proyecto.controllers;

import javafx.scene.control.*;
import proyecto.application.Aplicacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import proyecto.exceptions.IncompleteDataException;
import proyecto.exceptions.UserDoesntExistException;
import proyecto.model.Herramienta;

import static proyecto.controllers.AppController.INSTANCE;

public class LoginRegularController {


    private Aplicacion aplicacion;


     Herramienta herramienta = INSTANCE.getHerramienta();
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnIngresar;

        @FXML
        private Label olvidoContrasenia;

        @FXML
        private PasswordField txtContrasenia;

        @FXML
        private TextField txtNombreUsuario;

        @FXML
        void actionIngresar(ActionEvent event) {

            String usuario = "";
            String contrasenia = "";

            usuario = txtNombreUsuario.getText();
            contrasenia = txtContrasenia.getText();

            try {
                if (datosValidos(usuario, contrasenia)) {

                    if (herramienta.existeUsuario(usuario)) {
                        aplicacion.mostrarVentanaProcesosUsuario(herramienta.buscarUsuario(usuario));
                    } else {
                        throw new UserDoesntExistException();
                    }
                } else {
                    throw new IncompleteDataException();
                }
            } catch (UserDoesntExistException e) {
                herramienta.mostrarMensaje("Notificacion Inicio sesion", "Usuario no existe", "Los datos ingresados no corresponde a un usuario valido", Alert.AlertType.INFORMATION);
            } catch (IncompleteDataException e) {
                herramienta.mostrarMensaje("Notificacion Inicio sesion", "Datos Incompletos", "Debe ingresar los datos correctamente, despues de 3 intentos se bloqueara el usuario", Alert.AlertType.WARNING);
            }

        }


    private boolean datosValidos(String usuario, String contrasenia) {
        return !usuario.isEmpty() && !contrasenia.isEmpty();
    }



    @FXML
    void olvidoContraseniaAction(MouseEvent event) {
        olvidoContrasenia.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
            aplicacion.mostrarVentanaRecuperarContrasenia();
        });
    }

        @FXML
        void initialize() {
            assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
            assert olvidoContrasenia != null : "fx:id=\"olvidoContrasenia\" was not injected: check your FXML file 'Login.fxml'.";
            assert txtContrasenia != null : "fx:id=\"txtContrasenia\" was not injected: check your FXML file 'Login.fxml'.";
            assert txtNombreUsuario != null : "fx:id=\"txtNombreAdministrador\" was not injected: check your FXML file 'Login.fxml'.";

        }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
}
