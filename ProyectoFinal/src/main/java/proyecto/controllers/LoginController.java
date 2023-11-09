package proyecto.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import proyecto.application.Aplicacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnIngresar;

        @FXML
        private Button btnRegistrarse;

        @FXML
        private Label olvidoContrasenia;

        @FXML
        private PasswordField txtContrasenia;

        @FXML
        private TextField txtNombreUsuario;
        private Aplicacion aplicacion;

    @FXML
        void actionIngresar(ActionEvent event) {
        String usuario = "";
        String contrasenia = "";

        usuario = txtNombreUsuario.getText();
        contrasenia = txtContrasenia.getText();

        if(datosValidos(usuario,contrasenia)){

            boolean usuarioValido = aplicacion.verificarUsuario(usuario,contrasenia);
            if(usuarioValido){
                aplicacion.mostrarVentanaProcesosUsuario(usuario);
            }else{
                mostrarMensaje("Notificaci�n Inicio sesion", "Usuario no existe", "Los datos ingresados no corresponde a un usuario valido", Alert.AlertType.INFORMATION);

            }
        }else{
            mostrarMensaje("Notificaci�n Inicio sesion", "Datos Incompletos", "Debe ingresar los datos correctamente, despues de 3 intentos se bloqueara el usuario", Alert.AlertType.WARNING);

        }

    }
    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private boolean datosValidos(String usuario, String contrasenia) {
        if(usuario.equals("") || contrasenia.equals("")){
            return false;
        }
        return true;
    }


        @FXML
        void olvidoContrasenia(MouseEvent event) {
            olvidoContrasenia.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
                aplicacion.mostrarVentanaRecuperarContrasenia();
            });
        }



        @FXML
        void registrarseAction(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("../views/Registro.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Registro");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();

        }

        @FXML
        void initialize() {
            assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
            assert btnRegistrarse != null : "fx:id=\"btnRegistrarse\" was not injected: check your FXML file 'Login.fxml'.";
            assert olvidoContrasenia != null : "fx:id=\"olvidoContrasenia\" was not injected: check your FXML file 'Login.fxml'.";
            assert txtContrasenia != null : "fx:id=\"txtContrasenia\" was not injected: check your FXML file 'Login.fxml'.";
            assert txtNombreUsuario != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'Login.fxml'.";

        }

        public void setAplicacion(Aplicacion aplicacion) {
            this.aplicacion = aplicacion;
        }
    }


