package uniquindio.estructuras.biblioteca.controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uniquindio.estructuras.biblioteca.exceptions.CodigoNoEncontradoException;
import uniquindio.estructuras.biblioteca.model.*;

import javax.swing.*;

public class CrudPrestamoController {
    Biblioteca biblioteca = ModelFactoryController.getInstance().getBiblioteca();
    Object prestamoSeleccion;
    double x,y;
    @FXML
    private ImageView closeBtn;

    @FXML
    private ImageView hideBtn;

    @FXML
    private Pane tittlePane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarPrestamo;

    @FXML
    private Button btnAniadirPrestamo;

    @FXML
    private Button btnEliminarPrestamo;

    @FXML
    private TableColumn<Prestamo, String> columnCodigo;

    @FXML
    private TableColumn<Prestamo, String> columnFechaDevolucion;

    @FXML
    private TableColumn<Prestamo, String> columnFechaPrestamo;

    @FXML
    private TableColumn<Prestamo, String> columnNombreEstudiante;

    @FXML
    private TableView<Prestamo> tablePrestamos;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtFechaDevolucion;

    @FXML
    private TextField txtFechaPrestamo;

    @FXML
    private TextField txtNombreEstudiante;
    private final ObservableList<Prestamo> prestamos = FXCollections.observableArrayList();

    @FXML
    void actionActualizar(ActionEvent event) {
        if (prestamoSeleccion != null) {
            Prestamo prestamo = (Prestamo) prestamoSeleccion;
            biblioteca.actualizarPrestamo(prestamo.getCodigo(), prestamo);
            mostrarMensaje("Notificación","El prestamo se ha actualizado","El prestamo se actualizó correctamente");
        } else {
            mostrarMensaje("Error","Error", "No se pudo");
        }
    }

    @FXML
    void actionCrear(ActionEvent event) {

    }


    @FXML
    void initialize() {
        loadTable();

        tablePrestamos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                prestamoSeleccion = newSelection;

            }
        });
    }



    @FXML
    void crearPrestamo(ActionEvent event) {
        HashMap<String, DetallePrestamo> detallePrestamo = new HashMap<>();
        String codigo = txtCodigo.getText();
        String estudiante = txtNombreEstudiante.getText();
        String fechaPrestamo = txtFechaPrestamo.getText();
        String fechaDevolucion = txtFechaDevolucion.getText();
        detallePrestamo.put(codigo, new DetallePrestamo(0,codigo,biblioteca.obtenerLibro(new Autor("Desconocido","Desconocido","1")),1000));
        if(datosValidos(codigo,estudiante,fechaPrestamo,fechaDevolucion)){
            biblioteca.crearPrestamo(codigo, new Estudiante(), fechaPrestamo, fechaDevolucion, detallePrestamo);
            mostrarMensaje("Notificaión","El Prestamo se ha añadido","El prestamo se añadió correctamente");
        }else {
            mostrarMensaje("Error","Error", "No se pudo");
        }
    }
    private void loadTable(){
        System.out.println("Cargando tabla" + biblioteca.getPrestamos());
        columnNombreEstudiante.setCellValueFactory(cellData -> {
            Prestamo prestamo = cellData.getValue();
            Estudiante estudiante = prestamo.getEstudiante();
            if (estudiante != null) {
                return new SimpleStringProperty(estudiante.getNombre());
            } else {
                return new SimpleStringProperty("");
            }
        });
        columnFechaPrestamo.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        columnFechaDevolucion.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
        columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        prestamos.clear();
        prestamos.addAll(biblioteca.getPrestamos().values());
        tablePrestamos.setItems(prestamos);


    }

    @FXML
    void actionEliminar(ActionEvent event) {
        try {
            biblioteca.eliminarPrestamo(txtCodigo.getText());
            JOptionPane.showMessageDialog(null, "Prestamo eliminado");
        } catch (CodigoNoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en el sistema");

        }
    }

    private void mostrarMensaje(String titulo,String header,String contenido)  {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private boolean datosValidos(String codigo, String estudiante, String fechaPrestamo, String fechaDevolucion) {
        String notificacion = "";
        if (codigo == null || codigo.isEmpty()) {
            notificacion += "Codigo no puede estar vacío\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (estudiante == null || estudiante.equals("")) {
            notificacion += "Estudiante no puede estar vacío\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (fechaPrestamo == null || fechaPrestamo.equals("")) {
            notificacion += "Fecha prestamo no puede estar vacía\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (fechaDevolucion == null || fechaDevolucion.equals("")) {
            notificacion += "Fecha devolucion no puede estar vacía\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        return true;


    }
    @FXML
    void actionRecargar(ActionEvent event) {
        prestamos.clear();
        prestamos.addAll(biblioteca.getPrestamos().values());
        tablePrestamos.setItems(prestamos);
    }


    public void init(Stage stage) {
        tittlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        tittlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        closeBtn.setOnMouseClicked(mouseEvent -> {
            stage.close();
        });
        hideBtn.setOnMouseClicked(mouseEvent -> {
            stage.setIconified(true);
        });
    }
}
