package proyecto.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import proyecto.application.Aplicacion;
import proyecto.model.Proceso;
import proyecto.model.Usuario;
import javafx.scene.control.TableView;
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
    private Label abrirActividades;

    @FXML
    private Label actualizarProceso;

    @FXML
    private Label cerrarSesion;

    @FXML
    private TableColumn<Proceso, String> columnId;

    @FXML
    private TableColumn<Proceso, String> columnNombre;

    @FXML
    private TableColumn<Proceso, String> columnTiempoMaximo;

    @FXML
    private TableColumn<Proceso, String> columnTiempoMinimo;

    @FXML
    private Label crearProceso;

    @FXML
    private Label eliinarProceso;

    @FXML
    private ImageView iconCerrarSesion;

    @FXML
    private TableView<?> tableProcesos;

    @FXML
    private TextField txtIdProceso;

    @FXML
    private TextField txtNombreProceso;

    @FXML
    private TextField txtTiempoMaximo;

    @FXML
    private TextField txtTiempoMinimo;


    ObservableList<Proceso> listaProcesosData = FXCollections.observableArrayList();




    @FXML
    void abiriActiviadesAction(MouseEvent event) {
        aplicacion.mostrarVentanaActividadesAdmin(null);

    }

    @FXML
    void cerrarSesionAction(MouseEvent event) {

        aplicacion.mostrarVentanaIniciarHerramienta();

    }

    @FXML
    void crearProcesoAction(MouseEvent event) {



    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }



    @FXML
    void elimiarProcesoAction(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert abrirActividades != null : "fx:id=\"abrirActividades\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert actualizarProceso != null : "fx:id=\"actualizarProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert cerrarSesion != null : "fx:id=\"cerrarSesion\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert columnNombre != null : "fx:id=\"columnNombre\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert columnTiempoMaximo != null : "fx:id=\"columnTiempoMaximo\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert columnTiempoMinimo != null : "fx:id=\"columnTiempoMinimo\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert crearProceso != null : "fx:id=\"crearProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert eliinarProceso != null : "fx:id=\"eliinarProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert iconCerrarSesion != null : "fx:id=\"iconCerrarSesion\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert tableProcesos != null : "fx:id=\"tableProcesos\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert txtIdProceso != null : "fx:id=\"txtIdProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert txtNombreProceso != null : "fx:id=\"txtNombreProceso\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert txtTiempoMaximo != null : "fx:id=\"txtTiempoMaximo\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";
        assert txtTiempoMinimo != null : "fx:id=\"txtTiempoMinimo\" was not injected: check your FXML file 'ProcesosAdmin.fxml'.";

    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
