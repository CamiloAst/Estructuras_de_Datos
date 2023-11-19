package proyecto.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import proyecto.application.Aplicacion;
import proyecto.exceptions.IncompleteDataException;
import proyecto.exceptions.IncorrectDataException;
import proyecto.model.Herramienta;
import proyecto.model.TipoNotificacion;
import proyecto.model.TipoUsuario;
import proyecto.model.Usuario;
import proyecto.utils.ShowMessage;

import static proyecto.controllers.AppController.INSTANCE;

public class ConfiguracionesController {


    Usuario usuario = INSTANCE.getUsuarioActual();
    Aplicacion aplicacion;
    @FXML
    public ComboBox<TipoNotificacion> comboBoxNotificacion;
    @FXML
    public ComboBox<TipoUsuario> comboBoxTipoUsuario;
    @FXML
    private Label guardar;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtnombre;

    @FXML
    void atrasEvent(MouseEvent event) {
        aplicacion.mostrarVentanaIniciarHerramienta();
    }

    @FXML
    void guardarAction(MouseEvent event) {
        try{
            if(txtCorreo.getText().isEmpty() || txtPassword.getText().isEmpty() || txtnombre.getText().isEmpty())
                throw new IncompleteDataException();
            if(comboBoxTipoUsuario.getValue() == null || comboBoxNotificacion.getValue() == null)
                throw new IncompleteDataException();
            if (usuario.getContrasenia().equals(txtPassword.getText())) {
                usuario.setNombreUsuario(txtnombre.getText());
                usuario.setCorreo(txtCorreo.getText());
                usuario.setTipoUsuario(comboBoxTipoUsuario.getValue());
                usuario.setTipoNotificacion(comboBoxNotificacion.getValue());
                aplicacion.mostrarVentanaIniciarHerramienta();
            } else {
                throw new IncorrectDataException();
            }
        } catch (IncompleteDataException e) {
            ShowMessage.mostrarMensaje("Error", "Datos incompletos", "Por favor ingrese todos los datos");
        } catch (IncorrectDataException e) {
            ShowMessage.mostrarMensaje("Error", "Datos incorrectos", "La contraseña es incorrecta");
        }
    }

    @FXML
    void initialize() {

        comboBoxTipoUsuario.getItems().addAll(TipoUsuario.values());
        comboBoxNotificacion.getItems().addAll(TipoNotificacion.values());

    }
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
}
