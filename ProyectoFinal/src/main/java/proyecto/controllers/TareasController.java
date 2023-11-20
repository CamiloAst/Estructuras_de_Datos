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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proyecto.application.Aplicacion;
import proyecto.model.Actividad;
import proyecto.model.Proceso;
import proyecto.model.Tarea;
import proyecto.utils.ShowMessage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;

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
    private TextField txtBuscar;

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
            for (int i = 0; i < tableTareas.getColumns().size(); i++) {
                headerRow.createCell(i).setCellValue(tableTareas.getColumns().get(i).getText());
            }

            // Datos de la tabla
            ObservableList<Tarea> items = tableTareas.getItems();
            for (int i = 0; i < items.size(); i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(items.get(i).getNombre());
                row.createCell(1).setCellValue(items.get(i).getDescripcion());
                row.createCell(2).setCellValue(items.get(i).getTiempoDuracion());
                row.createCell(3).setCellValue(items.get(i).getObigatoria());
            }

            workbook.write(fileOut);
            System.out.println("Exportación exitosa a Excel.");
        } catch (IOException e) {
            ShowMessage.mostrarMensaje("Error", "Error al exportar a Excel", "No se pudo exportar la tabla a Excel.");
        }
    }

    @FXML
    void initialize() {
        nombreUsuario.setText(actividad.getNombre());

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

        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
            searchTask();
        });
    }

    @FXML
    private void searchTask() {
        String text = txtBuscar.getText();
        ObservableList<Tarea> filteredList = actividad.getListaTareas().getTableData().stream()
                .filter(tarea -> tarea.getNombre().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), FXCollections::observableArrayList));

        tableTareas.setItems(filteredList);
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

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

}