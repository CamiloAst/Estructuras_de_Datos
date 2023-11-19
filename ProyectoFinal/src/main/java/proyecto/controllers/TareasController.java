package proyecto.controllers;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto.application.Aplicacion;
import proyecto.model.Actividad;
import proyecto.model.Tarea;
import proyecto.utils.ShowMessage;

import static proyecto.controllers.AppController.INSTANCE;

public class TareasController {
    Aplicacion aplicacion;

    Actividad actividad = INSTANCE.getActividadActual();

    @FXML
    private ComboBox<String> comboBoxObligatoria;

    @FXML
    private Label actualizarProceso;

    @FXML
    private Label cerrarSesion;


    @FXML
    private TableColumn<Tarea, String> columnNombre;
    @FXML
    private TableColumn<Tarea, String> columnDescripcion;

    @FXML
    private TableColumn<Tarea, Integer> columnTiempo;
    public TableColumn<Tarea, Boolean> columnIsObligatoria;


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
    private TableView<Tarea> tableTareas;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTiempo;

    Object tareaSelection;


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





    public void crearTarea(){
        try {
            Boolean isObligatoria = comboBoxObligatoria.getValue().equals("Si");
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            int tiempo = Integer.parseInt(txtTiempo.getText());
            actividad.crearTarea(nombre, descripcion,isObligatoria, tiempo);
            rechargeTable();
        } catch (NumberFormatException e) {
            ShowMessage.mostrarMensaje("Error", "Error al crear tarea", "El tiempo debe ser un numero");
        }
        INSTANCE.getProcesoActual().calcularTiempos();
    }

    public void eliminarTarea(){
        Tarea tarea = tableTareas.getSelectionModel().getSelectedItem();
        if(tarea != null){
            actividad.eliminarTarea(tarea);
            rechargeTable();
        }
        INSTANCE.getProcesoActual().calcularTiempos();
    }
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void initialize() {
        assert actualizarProceso != null : "fx:id=\"actualizarProceso\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert cerrarSesion != null : "fx:id=\"cerrarSesion\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert columnDescripcion != null : "fx:id=\"columnId\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert columnNombre != null : "fx:id=\"columnNombre\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert columnTiempo != null : "fx:id=\"columnTiempoMaximo\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert comboBoxObligatoria != null : "fx:id=\"comboBoxObligatoria\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert crearTarea != null : "fx:id=\"crearTarea\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert eliminarTarea != null : "fx:id=\"eliminarTarea\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert iconActualizar != null : "fx:id=\"iconActualizar\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert iconCerrarSesion != null : "fx:id=\"iconCerrarSesion\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert iconCrear != null : "fx:id=\"iconCrear\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert iconEliminar != null : "fx:id=\"iconEliminar\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert nombreUsuario != null : "fx:id=\"nombreUsuario\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert tableTareas != null : "fx:id=\"tableProcesos\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert txtDescripcion != null : "fx:id=\"txtIdProceso\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombreProceso\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert txtTiempo != null : "fx:id=\"txtTiempoMaximo\" was not injected: check your FXML file 'Tareas.fxml'.";
        assert columnIsObligatoria != null : "fx:id=\"columnIsObligatoria\" was not injected: check your FXML file 'Tareas.fxml'.";

        loadTable();

        comboBoxObligatoria.getItems().addAll("Si", "No");

        actividad.getListaTareas().addObserver((o, arg) -> {
            ObservableList<Tarea> updatedTableData = FXCollections.observableArrayList(actividad.getListaTareas().getTableData());
            tableTareas.setItems(updatedTableData);
        });
        tableTareas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                tareaSelection = newSelection;
            }
        });

    }

    private void loadTable(){
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        columnTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoDuracion"));
        columnIsObligatoria.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue().getObigatoria()));
        columnIsObligatoria.setCellFactory(CheckBoxTableCell.forTableColumn(columnIsObligatoria));

        ObservableList<Tarea> tareas = FXCollections.observableArrayList(actividad.getListaTareas().getTableData());
        tableTareas.setItems(tareas);

    }

    private void rechargeTable(){
        ObservableList<Tarea> updatedTableData = FXCollections.observableArrayList(actividad.getListaTareas().getTableData());
        tableTareas.setItems(updatedTableData);
    }

}