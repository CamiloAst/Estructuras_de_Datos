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
import proyecto.exceptions.ActivityAlreadyExistException;
import proyecto.exceptions.ActivityDontExistException;
import proyecto.exceptions.IncompleteDataException;
import proyecto.model.Actividad;
import proyecto.model.Proceso;
import proyecto.utils.ShowMessage;

import java.net.URL;
import java.util.ResourceBundle;

import static proyecto.controllers.AppController.INSTANCE;


public class ActividadesAdminController {

    Proceso proceso = INSTANCE.getHerramienta().getProcesoActual();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label actualizarActividad;

    @FXML
    private TableView<Actividad> tableActividades;

    @FXML
    private TableColumn<Actividad, String> columnDescripcionActvidad;

    @FXML
    private TableColumn<Actividad, String> columnNombreActividad;

    @FXML
    public TableColumn<Actividad, Boolean> columnObligatoriaActvidad;

    @FXML
    private ComboBox<Actividad> comboBoxObligatoria;

    @FXML
    private Label crearActividad;

    @FXML
    private Label eliminarActividad;

    @FXML
    private ImageView iconLogin;


    @FXML
    private TextField txtDescripcionActividad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTiempoMinimo;

    @FXML
    private TextField tztTiempoMaximoActividad;

    @FXML
    private Label verTareas;
    private Aplicacion aplicacion;

    ObservableList<Actividad> listaActividadesData = FXCollections.observableArrayList(proceso.getListaActividades().getTableData());
    Object actividadSeleccion;

    @FXML
    private Label cerrarSesion;

    @FXML
    private ImageView iconAbrir;

    @FXML
    private ImageView iconActualizar;

    @FXML
    private ImageView iconCerrarSesion;

    @FXML
    private ImageView iconCrear;

    @FXML
    private ImageView iconEliminar;

    @FXML
    private Label nombreProceso;


    @FXML
    void cerrarSesionAction(MouseEvent event) {

        aplicacion.mostrarVentanaIniciarHerramienta();
    }




    @FXML
    void actualizarActividadAction(MouseEvent event) {

    }

    @FXML
    void crearActividadAction(MouseEvent event) {
        try {
            if(txtNombre.getText().isEmpty() && txtDescripcionActividad.getText().isEmpty())
                proceso.agregarActividad(new Actividad(txtNombre.getText(), txtDescripcionActividad.getText(), false));
            else
                throw new IncompleteDataException();
        } catch (ActivityAlreadyExistException e) {
            ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "La actividad ya existe");
        } catch (IncompleteDataException e) {
            ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "Faltan datos");
        }
    }

    void crearActividadSecuencia(){
        if (!txtNombre.getText().isEmpty() && !txtDescripcionActividad.getText().isEmpty())
            proceso.agregarActividad(new Actividad(txtNombre.getText(), txtDescripcionActividad.getText(), false), "Actividad 1");
        else
            ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "Faltan datos");
    }

    @FXML
    void eliminarActividadAction(MouseEvent event) {
        if(actividadSeleccion != null){
            try {
                proceso.eliminarActividad((Actividad) actividadSeleccion);
            } catch (ActivityDontExistException e) {
                ShowMessage.mostrarMensaje("Error", "Error al eliminar actividad", "La actividad no existe");
            }
        }
    }

    @FXML
    void abrirTareasAction(MouseEvent event) {
        if(actividadSeleccion != null){
            INSTANCE.setActividadActual((Actividad) actividadSeleccion);
            aplicacion.mostrarVentanaTareasAdmin();
        }
    }
    @FXML
    void initialize() {
        assert actualizarActividad != null : "fx:id=\"actualizarActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert columnDescripcionActvidad != null : "fx:id=\"columnDescripcionActvidad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert columnNombreActividad != null : "fx:id=\"columnNombreActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert comboBoxObligatoria != null : "fx:id=\"comboBoxObligatoria\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert crearActividad != null : "fx:id=\"crearActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert eliminarActividad != null : "fx:id=\"eliminarActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert iconLogin != null : "fx:id=\"iconLogin\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert tableActividades != null : "fx:id=\"tableActividades\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert txtDescripcionActividad != null : "fx:id=\"txtDescripcionActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert txtTiempoMinimo != null : "fx:id=\"txtTiempoMinimo\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert tztTiempoMaximoActividad != null : "fx:id=\"tztTiempoMaximoActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
        assert verTareas != null : "fx:id=\"verTareas\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";

        loadTable();


        proceso.getListaActividades().addObserver((o, arg) -> {
            ObservableList<Actividad> updatedTableData = FXCollections.observableArrayList(proceso.getListaActividades().getTableData());
            tableActividades.setItems(updatedTableData);
        });
        tableActividades.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                actividadSeleccion = newSelection;
            }
        });

    }

    private void loadTable() {
        columnNombreActividad.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDescripcionActvidad.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        columnObligatoriaActvidad.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue().getIsObligatoria()));
        columnObligatoriaActvidad.setCellFactory(CheckBoxTableCell.forTableColumn(columnObligatoriaActvidad));

    }


    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

}
