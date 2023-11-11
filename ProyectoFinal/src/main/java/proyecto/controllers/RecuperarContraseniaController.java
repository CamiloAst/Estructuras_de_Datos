package proyecto.controllers;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import proyecto.application.Aplicacion;

public class RecuperarContraseniaController {
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
    private String usuario;

    public  void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }


    @FXML
    void ingresarAction(ActionEvent event) {

    }

    @FXML
    void actualizarContraseniaAction(ActionEvent event) {

    }


    @FXML
    void initialize() {
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'RecuperarContrasenia.fxml'.";
        assert txtNombreUsuario != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'RecuperarContrasenia.fxml'.";
        assert txtNuevaContrasenia != null : "fx:id=\"txtNuevaContrasenia\" was not injected: check your FXML file 'RecuperarContrasenia.fxml'.";

    }

}

