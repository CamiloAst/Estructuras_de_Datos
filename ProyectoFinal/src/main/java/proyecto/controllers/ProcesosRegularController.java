package proyecto.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto.application.Aplicacion;
import proyecto.model.Usuario;

public class ProcesosRegularController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnAbrirProceso;

        @FXML
        private Button btnConsultarDuracionProceso;

        @FXML
        private Button btnEliminarProceso;

        @FXML
        private TableColumn<?, ?> columnId;

        @FXML
        private TableColumn<?, ?> columnNombreProceso;

        @FXML
        private ImageView iconUsuario;

        @FXML
        private TableView<?> tableProcesos;
        private Usuario usuario;
        private Aplicacion aplicacion;

        @FXML
        void abrirProcesoAction(ActionEvent event) {

        }

        @FXML
        void consultarDuracionAction(ActionEvent event) {

        }

        @FXML
        void eliminarProcesoAction(ActionEvent event) {

        }

        @FXML
        void usuarioEvent(MouseEvent event) {

        }

        @FXML
        void initialize() {
                assert btnAbrirProceso != null : "fx:id=\"btnAbrirProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
                assert btnConsultarDuracionProceso != null : "fx:id=\"btnConsultarDuracionProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
                assert btnEliminarProceso != null : "fx:id=\"btnEliminarProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
                assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
                assert columnNombreProceso != null : "fx:id=\"columnNombreProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
                assert iconUsuario != null : "fx:id=\"iconUsuario\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
                assert tableProcesos != null : "fx:id=\"tableProcesos\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";

        }




        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }

        public void setAplicacion(Aplicacion aplicacion) {
                this.aplicacion = aplicacion;
        }
}
