package proyecto.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import proyecto.application.Aplicacion;
import proyecto.model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;



public class ProcesosAdminController {

    Aplicacion aplicacion;

    Usuario usuario;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnAbrirProceso;

        @FXML
        private Button btnConsultarDuracionProceso;

        @FXML
        private Button btnCrearProceso;

        @FXML
        private Button btnEliminarProceso;

        @FXML
        private Label cerrarSesion;

        @FXML
        private ImageView iconCerrarSesion;

        @FXML
        private TableView<?> tableProcesos;

        @FXML
        private TextField txtIdProceso;

        @FXML
        private TextField txtNombreProceso;

        @FXML
        void abrirProcesoAction(ActionEvent event) {

        }

        @FXML
        void cerrarSesionAction(MouseEvent event) {

        }

        @FXML
        void consultarDireccionAction(ActionEvent event) {

        }

        @FXML
        void crearProcesoAction(ActionEvent event) {

        }

        @FXML
        void eliminarProcesoAction(ActionEvent event) {

        }

        @FXML
        void initialize() {
            assert btnAbrirProceso != null : "fx:id=\"btnAbrirProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
            assert btnConsultarDuracionProceso != null : "fx:id=\"btnConsultarDuracionProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
            assert btnCrearProceso != null : "fx:id=\"btnCrearProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
            assert btnEliminarProceso != null : "fx:id=\"btnEliminarProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
            assert cerrarSesion != null : "fx:id=\"cerrarSesion\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
            assert iconCerrarSesion != null : "fx:id=\"iconCerrarSesion\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
            assert tableProcesos != null : "fx:id=\"tableProcesos\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
            assert txtIdProceso != null : "fx:id=\"txtIdProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
            assert txtNombreProceso != null : "fx:id=\"txtNombreProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";

        }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
