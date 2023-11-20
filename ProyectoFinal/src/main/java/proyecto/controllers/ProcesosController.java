package proyecto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import proyecto.application.Aplicacion;
import proyecto.exceptions.AccesDeniedException;
import proyecto.model.Herramienta;
import proyecto.model.Proceso;
import proyecto.model.TipoUsuario;
import proyecto.model.Usuario;
import proyecto.utils.ShowMessage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static proyecto.controllers.AppController.INSTANCE;


public class ProcesosController {

    Aplicacion aplicacion;

    Herramienta herramienta = INSTANCE.getHerramienta();
    Usuario usuario;

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
    private TableColumn<Proceso, Integer> columnTiempoMaximo;

    @FXML
    private TableColumn<Proceso, Integer> columnTiempoMinimo;
    @FXML
    private TableView<Proceso> tableProcesos;

    @FXML
    private Label crearProceso;

    @FXML
    private Label eliminarProceso;

    @FXML
    private ImageView iconCerrarSesion;


    @FXML
    private TextField txtNombreProceso;

    @FXML
    private Label nombreUsuario;

    Object procesoSeleccion;
    ObservableList<Proceso> listaProcesosData = FXCollections.observableArrayList();

    @FXML
    void abiriActiviadesAction(MouseEvent event) {
        if (procesoSeleccion != null) {
            INSTANCE.setProcesoActual((Proceso) procesoSeleccion);
            aplicacion.mostrarVentanaActividadesAdmin();

        }
    }

    @FXML
    void cerrarSesionAction(MouseEvent event) {
        aplicacion.mostrarVentanaIniciarHerramienta();
    }

    @FXML
    void crearProcesoAction(MouseEvent event) {
        try {
            if (verificarPermisos())
                herramienta.createProcess(txtNombreProceso.getText(),
                    String.valueOf(herramienta.getListaProcesos().size()));
        } catch (AccesDeniedException e) {
            ShowMessage.mostrarMensaje("Error", "Error al crear proceso", "No tiene permisos para crear procesos");
        }
        notificarAlCorreo("Se ha creado un proceso ");
        rechargeTable();
    }

    @FXML
    void elimiarProcesoAction(MouseEvent event) {
        try {
            if(verificarPermisos()) {
                if(procesoSeleccion != null)
                    herramienta.deleteProcess(((Proceso) procesoSeleccion).getNombre());
                else
                    herramienta.deleteProcess(txtNombreProceso.getText());
            }
        } catch (AccesDeniedException e) {
            throw new RuntimeException(e);
        }
        notificarAlCorreo("Se ha eliminado un proceso ");
        rechargeTable();
    }

    @FXML
    void configuracionAction(MouseEvent event) {
        aplicacion.mostrarVentanaConfiguracion();

    }
    public Boolean verificarPermisos() throws AccesDeniedException {
        if(INSTANCE.getUsuarioActual().getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR))
            return true;
        throw new AccesDeniedException();
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
            for (int i = 0; i < tableProcesos.getColumns().size(); i++) {
                headerRow.createCell(i).setCellValue(tableProcesos.getColumns().get(i).getText());
            }

            // Datos de la tabla
            ObservableList<Proceso> items = tableProcesos.getItems();
            for (int i = 0; i < items.size(); i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(items.get(i).getId());
                row.createCell(1).setCellValue(items.get(i).getNombre());
                row.createCell(2).setCellValue(items.get(i).getTiempoDuracionMin());
                row.createCell(3).setCellValue(items.get(i).getTiempoDuracionMax());
            }

            workbook.write(fileOut);
            System.out.println("Exportación exitosa a Excel.");
        } catch (IOException e) {
            ShowMessage.mostrarMensaje("Error", "Error al exportar a Excel", "No se pudo exportar la tabla a Excel.");
        }
    }

    @FXML
    void initialize() {
        nombreUsuario.setText(INSTANCE.getUsuarioActual().getNombreUsuario());
        loadTable();
        tableProcesos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                procesoSeleccion = newSelection;
            }
        });
        notificarAlCorreo("Se ha iniciado sesion");
    }

    private void loadTable() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnTiempoMinimo.setCellValueFactory(new PropertyValueFactory<>("tiempoDuracionMin"));
        columnTiempoMaximo.setCellValueFactory(new PropertyValueFactory<>("tiempoDuracionMax"));

        listaProcesosData.clear();
        listaProcesosData.addAll(herramienta.getListaProcesos());
        tableProcesos.setItems(listaProcesosData);

        System.out.println(herramienta.getListaProcesos().get(0).getTiempoDuracionMax());
    }
    private void rechargeTable(){
        listaProcesosData.clear();
        listaProcesosData.addAll(herramienta.getListaProcesos());
        tableProcesos.setItems(listaProcesosData);
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void notificarAlCorreo(String mensaje){
        herramienta.notifyUser(mensaje);
    }

    public void update(MouseEvent mouseEvent) {
        if(procesoSeleccion != null){
            Proceso proceso = (Proceso) procesoSeleccion;
            if(!txtNombreProceso.getText().isEmpty())
                proceso.setNombre(txtNombreProceso.getText());
            rechargeTable();
        }
    }
}
