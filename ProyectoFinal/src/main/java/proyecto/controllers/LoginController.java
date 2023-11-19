package proyecto.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto.application.Aplicacion;
import proyecto.exceptions.IncompleteDataException;
import proyecto.exceptions.UserDoesntExistException;
import proyecto.model.Herramienta;
import proyecto.utils.ShowMessage;

import java.net.URL;
import java.util.ResourceBundle;

import static proyecto.controllers.AppController.INSTANCE;

public class LoginController {

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
    private TextField txtNombreAdministrador;
    private Aplicacion aplicacion;

    @FXML
    private ImageView atras;


    @FXML
    void atrasAction(MouseEvent event) {
        aplicacion.mostrarVentanaIniciarHerramienta();
    }
    @FXML
    void actionIngresar(ActionEvent event) {
    String nombre = "";
    String contrasenia = "";

    nombre = txtNombreAdministrador.getText();
    contrasenia = txtContrasenia.getText();

    try {
        if (datosValidos(nombre, contrasenia)) {
            if (herramienta.userExist(nombre) && herramienta.searchUser(nombre).getContrasenia().equals(contrasenia)) {
                INSTANCE.setUsuarioActual(herramienta.searchUser(nombre));
                aplicacion.mostrarVentanaProcesosAdmin();
            } else {
                throw new UserDoesntExistException();
            }
        } else {
            throw new IncompleteDataException();
        }
    } catch (IncompleteDataException e) {
        ShowMessage.mostrarMensaje("Notificacion Inicio sesion", "Datos Incompletos", "Debe ingresar los datos correctamente, despues de 3 intentos se bloqueara el usuario");
    } catch (UserDoesntExistException e) {
        ShowMessage.mostrarMensaje("Notificacion Inicio sesion", "Usuario no existe", "El usuario no existe o la contrasenia es incorrecta");
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
        assert txtNombreAdministrador != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'Login.fxml'.";

    }

    public void setAplicacion(Aplicacion aplicacion) {
            this.aplicacion = aplicacion;
        }


    public void olvidoContrasenia(MouseEvent mouseEvent) {

    }
}


