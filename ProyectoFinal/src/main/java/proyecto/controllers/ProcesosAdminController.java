package proyecto.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import proyecto.application.Aplicacion;
import proyecto.model.Usuario;

public class ProcesosAdminController {

    Aplicacion aplicacion;

    Usuario usuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBuscarProceso;

    @FXML
    private Button btnConsultarDuracionProceso;

    @FXML
    private Button btnCrearProceso;

    @FXML
    private Button btnEliminarProceso;

    @FXML
    private TableView<?> tableProcesos;

    @FXML
    void buscarProcesoAction(ActionEvent event) {

    }

    @FXML
    void crearProcesoAction(ActionEvent event) {

    }

    @FXML
    void eliminarProcesoAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnBuscarProceso != null : "fx:id=\"btnBuscarProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
        assert btnConsultarDuracionProceso != null : "fx:id=\"btnConsultarDuracionProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
        assert btnCrearProceso != null : "fx:id=\"btnCrearProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
        assert btnEliminarProceso != null : "fx:id=\"btnEliminarProceso\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";
        assert tableProcesos != null : "fx:id=\"tableProcesos\" was not injected: check your FXML file 'ProcesosUsuario.fxml'.";

    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void setUsuario(String usuario) {
    }
}
