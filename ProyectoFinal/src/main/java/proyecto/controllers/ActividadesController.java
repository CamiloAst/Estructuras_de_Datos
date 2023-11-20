package proyecto.controllers;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proyecto.application.Aplicacion;
import proyecto.exceptions.ActivityAlreadyExistException;
import proyecto.exceptions.ActivityDontExistException;
import proyecto.exceptions.IncompleteDataException;
import proyecto.model.Actividad;
import proyecto.model.Proceso;
import proyecto.utils.ShowMessage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;

import static proyecto.controllers.AppController.INSTANCE;


public class ActividadesController {

    Proceso proceso = INSTANCE.getProcesoActual();
    

    @FXML
    private TableView<Actividad> tableActividades;

    @FXML
    private TableColumn<Actividad, String> columnDescripcionActvidad;

    @FXML
    private TableColumn<Actividad, String> columnNombreActividad;

    @FXML
    public TableColumn<Actividad, Boolean> columnObligatoriaActvidad;

    public TableColumn<Actividad, Integer> columnTiempoMinimo;

    public TableColumn<Actividad, Integer> ColumnTiempoTotal;

    @FXML
    private ComboBox<Boolean> comboBoxObligatoria;



    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    public TextField txtBuscar;

    private Aplicacion aplicacion;

    Object actividadSeleccion;


    @FXML
    private Label nombreProceso;


    @FXML
    void cerrarSesionAction(MouseEvent event) {
        aplicacion.mostrarVentanaIniciarHerramienta();
    }

    @FXML
    void actualizarActividadAction(MouseEvent event) {
        if(actividadSeleccion != null){
            Actividad actividad = (Actividad) actividadSeleccion;
            if(!txtNombre.getText().isEmpty())
                actividad.setNombre(txtNombre.getText());
            if(!txtDescripcion.getText().isEmpty())
                actividad.setDescripcion(txtDescripcion.getText());
            if(comboBoxObligatoria.getValue() != null)
                actividad.setObligatoria(comboBoxObligatoria.getValue());
        }else
            ShowMessage.mostrarMensaje("Error", "Error al actualizar actividad", "No se ha seleccionado ninguna actividad");
        rechargeTable();
    }

    @FXML
    void crearActividadAction(MouseEvent event) {

        if(proceso.getListaActividades().getSize() == 0 || actividadSeleccion == null) {
            try {
                if (!txtNombre.getText().isEmpty() && !txtDescripcion.getText().isEmpty())
                    proceso.agregarActividad(new Actividad(txtNombre.getText(), txtDescripcion.getText(), comboBoxObligatoria.getValue()));
                else
                    throw new IncompleteDataException();
            } catch (ActivityAlreadyExistException e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "La actividad ya existe");
            } catch (IncompleteDataException e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "Faltan datos");
            }
        }else{
            crearActividadSecuencia();
        }
        rechargeTable();
    }

    void crearActividadSecuencia(){
        if (!txtNombre.getText().isEmpty() && !txtDescripcion.getText().isEmpty())
            proceso.agregarActividad(new Actividad(txtNombre.getText(), txtDescripcion.getText(), comboBoxObligatoria.getValue()), ((Actividad) actividadSeleccion).getNombre());
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
        } else if (proceso.getListaActividades().getSize() == 1){
            try {
                proceso.eliminarActividad(proceso.getListaActividades().getFirstNode().getValue());
            } catch (ActivityDontExistException e) {
                ShowMessage.mostrarMensaje("Error", "Error al eliminar actividad", "La actividad no existe");
            }
        }else if (!txtNombre.getText().isEmpty()){
            try {
                proceso.eliminarActividad(txtNombre.getText());
            } catch (ActivityDontExistException e) {
                ShowMessage.mostrarMensaje("Error", "Error al eliminar actividad", "La actividad no existe");
            }
        }
        rechargeTable();
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

        comboBoxObligatoria.getItems().addAll(true, false);


        nombreProceso.setText(proceso.getNombre());
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

        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
            searchActivity();
        });
    }
    public void exportExcel(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar como archivo Excel");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivo Excel (*.xlsx)", "*.xlsx"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            exportarTablaAExcel(file);
        }
    }
    private void exportarTablaAExcel(File file) {
        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(file)) {
            Sheet sheet = workbook.createSheet("Datos");

            // Encabezados de columna
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < tableActividades.getColumns().size(); i++) {
                headerRow.createCell(i).setCellValue(tableActividades.getColumns().get(i).getText());
            }

            // Datos de la tabla
            ObservableList<Actividad> items = tableActividades.getItems();
            for (int i = 0; i < items.size(); i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(items.get(i).getNombre());
                row.createCell(1).setCellValue(items.get(i).getDescripcion());
                row.createCell(2).setCellValue(items.get(i).getIsObligatoria());
                row.createCell(3).setCellValue(items.get(i).getTiempoMinimo());
                row.createCell(4).setCellValue(items.get(i).getTiempoDuracion());
            }

            workbook.write(fileOut);
            System.out.println("Exportación exitosa a Excel.");
        } catch (IOException e) {
            ShowMessage.mostrarMensaje("Error", "Error al exportar a Excel", "No se pudo exportar la tabla a Excel.");
        }
    }

    private void loadTable() {
        columnNombreActividad.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDescripcionActvidad.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        columnObligatoriaActvidad.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue().getIsObligatoria()));
        columnObligatoriaActvidad.setCellFactory(CheckBoxTableCell.forTableColumn(columnObligatoriaActvidad));
        columnTiempoMinimo.setCellValueFactory(new PropertyValueFactory<>("tiempoMinimo"));
        ColumnTiempoTotal.setCellValueFactory(new PropertyValueFactory<>("tiempoDuracion"));

        ObservableList<Actividad> listaActividadesData = FXCollections.observableArrayList(proceso.getListaActividades().getTableData());
        tableActividades.setItems(listaActividadesData);

    }

    private void rechargeTable(){
        tableActividades.getItems().clear();
        ObservableList<Actividad> listaActividadesData = FXCollections.observableArrayList(proceso.getListaActividades().getTableData());
        tableActividades.setItems(listaActividadesData);
        txtNombre.setText("");
        txtDescripcion.setText("");
    }


    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void searchActivity() {
        String text = txtBuscar.getText().toLowerCase();
        ObservableList<Actividad> filteredList = proceso.getListaActividades().getTableData().stream()
                .filter(actividad -> actividad.getNombre().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), FXCollections::observableArrayList));

        tableActividades.setItems(filteredList);
    }
}
