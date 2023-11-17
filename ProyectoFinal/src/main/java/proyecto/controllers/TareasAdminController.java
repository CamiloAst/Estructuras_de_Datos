package proyecto.controllers;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto.application.Aplicacion;
import proyecto.model.Actividad;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;

import java.net.URL;
import java.util.ResourceBundle;

import static proyecto.controllers.AppController.INSTANCE;

public class TareasAdminController {
    Aplicacion aplicacion;

    Actividad actividad = INSTANCE.getHerramienta().getActividadActual();

    @FXML
    private ComboBox<String> comboBoxObligatoria;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label actualizarProceso;

    @FXML
    private Label cerrarSesion;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnNombre;

    @FXML
    private TableColumn<?, ?> columnTiempoMaximo;

    @FXML
    private TableColumn<?, ?> columnTiempoMinimo;

    @FXML
    private Label crearTarea;

    @FXML
    private Label eliminarTarea;

    @FXML
    private ImageView iconActualizar;

    @FXML
    private ImageView iconCerrarSesion;

    @FXML
    private ImageView iconCrear;

    @FXML
    private ImageView iconEliminar;

    @FXML
    private Label nombreUsuario;

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

    @FXML
    void cerrarSesionAction(MouseEvent event) {
        aplicacion.mostrarVentanaIniciarHerramienta();

    }

    @FXML
    void crearTarea(MouseEvent event) {
        crearTarea();

    }

    @FXML
    void eliminarTarea(MouseEvent event) {
        eliminarTarea();

    }




    private void loadTable(){
//        tableTareas.getItems().clear();
//        tableTareas.getItems().addAll(actividad.getTareas());
    }


    public void crearTarea(){
//        try {
//            String nombre = txtNombre.getText();
//            String descripcion = txtDescripcion.getText();
//            Integer tiempo = Integer.parseInt(txtTiempo.getText());
//            actividad.crearTarea(nombre, descripcion, tiempo);
//            loadTable();
//        } catch (NumberFormatException e) {
//            ShowMessage.showErrorMessage("Error", "El tiempo debe ser un numero");
//        } catch (IncompleteDataException e) {
//            ShowMessage.showErrorMessage("Error", "Faltan datos");
//        } catch (ActivityDontExistException e) {
//            ShowMessage.showErrorMessage("Error", "La actividad no existe");
//        } catch (ActivityAlreadyExistException e) {
//            ShowMessage.showErrorMessage("Error", "La tarea ya existe");
//        }
    }
    public void eliminarTarea(){
//        Tarea tarea = tableTareas.getSelectionModel().getSelectedItem();
//        if(tarea != null){
//            actividad.eliminarTarea(tarea);
//            loadTable();
//        }
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void initialize() {
        assert actualizarProceso != null : "fx:id=\"actualizarProceso\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert cerrarSesion != null : "fx:id=\"cerrarSesion\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert columnNombre != null : "fx:id=\"columnNombre\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert columnTiempoMaximo != null : "fx:id=\"columnTiempoMaximo\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert columnTiempoMinimo != null : "fx:id=\"columnTiempoMinimo\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert comboBoxObligatoria != null : "fx:id=\"comboBoxObligatoria\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert crearTarea != null : "fx:id=\"crearTarea\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert eliminarTarea != null : "fx:id=\"eliminarTarea\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert iconActualizar != null : "fx:id=\"iconActualizar\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert iconCerrarSesion != null : "fx:id=\"iconCerrarSesion\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert iconCrear != null : "fx:id=\"iconCrear\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert iconEliminar != null : "fx:id=\"iconEliminar\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert nombreUsuario != null : "fx:id=\"nombreUsuario\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert tableProcesos != null : "fx:id=\"tableProcesos\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert txtIdProceso != null : "fx:id=\"txtIdProceso\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert txtNombreProceso != null : "fx:id=\"txtNombreProceso\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert txtTiempoMaximo != null : "fx:id=\"txtTiempoMaximo\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert txtTiempoMinimo != null : "fx:id=\"txtTiempoMinimo\" was not injected: check your FXML file 'Tareas.fxml'.";

        loadTable();

    }

}