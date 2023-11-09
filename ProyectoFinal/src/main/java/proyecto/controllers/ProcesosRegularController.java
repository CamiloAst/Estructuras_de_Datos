package proyecto.controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

    public class ProcesosRegularController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnAbrirProceso;

        @FXML
        private Button btnBuscarProceso;

        @FXML
        private Button btnConsultarDuracionProceso;

        @FXML
        private Button btnEliminarProceso;

        @FXML
        private TableView<?> tableProcesos;

        @FXML
        void abrirProcesoAction(ActionEvent event) {



        }

        @FXML
        void buscarProcesoAction(ActionEvent event) {

        }

        @FXML
        void consultarDireccionAction(ActionEvent event) {

        }

        @FXML
        void eliminarProcesoAction(ActionEvent event) {

        }

        @FXML
        void initialize() {
            assert btnAbrirProceso != null : "fx:id=\"btnAbrirProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
            assert btnBuscarProceso != null : "fx:id=\"btnBuscarProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
            assert btnConsultarDuracionProceso != null : "fx:id=\"btnConsultarDuracionProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
            assert btnEliminarProceso != null : "fx:id=\"btnEliminarProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
            assert tableProcesos != null : "fx:id=\"tableProcesos\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";

        }

    }
