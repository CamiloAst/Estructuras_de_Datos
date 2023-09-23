package uniquindio.estructuras.biblioteca.controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import uniquindio.estructuras.biblioteca.model.Biblioteca;
import uniquindio.estructuras.biblioteca.model.Estudiante;
import uniquindio.estructuras.biblioteca.model.Prestamo;

import javax.swing.*;

import static uniquindio.estructuras.biblioteca.model.Biblioteca.prestamos;

public class CrudPrestamoController {

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
    private TableColumn<?, ?> columnCodigo;

    @FXML
    private TableColumn<?, ?> columnFechaDevolucion;

    @FXML
    private TableColumn<?, ?> columnFechaPrestamo;

    @FXML
    private TableColumn<?, ?> columnNombreEstudiante;

    @FXML
    private TableView<?> tablePrestamos;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtFechaDevolucion;

    @FXML
    private TextField txtFechaPrestamo;

    @FXML
    private TextField txtNombreEstudiante;

    @FXML
    void actionActualizar(ActionEvent event) {

    }

    @FXML
    void actionCrear(ActionEvent event) {

    }


    @FXML
    void initialize() {
        assert btnActualizarPrestamo != null : "fx:id=\"btnActualizarPrestamo\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert btnAniadirPrestamo != null : "fx:id=\"btnAniadirPrestamo\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert btnEliminarPrestamo != null : "fx:id=\"btnEliminarPrestamo\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert columnCodigo != null : "fx:id=\"columnCodigo\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert columnFechaDevolucion != null : "fx:id=\"columnFechaDevolucion\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert columnFechaPrestamo != null : "fx:id=\"columnFechaPrestamo\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert columnNombreEstudiante != null : "fx:id=\"columnNombreEstudiante\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert tablePrestamos != null : "fx:id=\"tablePrestamos\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert txtFechaDevolucion != null : "fx:id=\"txtFechaDevolucion\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert txtFechaPrestamo != null : "fx:id=\"txtFechaPrestamo\" was not injected: check your FXML file 'crudPrestamo.fxml'.";
        assert txtNombreEstudiante != null : "fx:id=\"txtNombreEstudiante\" was not injected: check your FXML file 'crudPrestamo.fxml'.";

    }



    @FXML
    void crearPrestamo(ActionEvent event) {
        String codigo = txtCodigo.getText();
        String estudiante = txtNombreEstudiante.getText();
        String fechaPrestamo = txtFechaPrestamo.getText();
        String fechaDevolucion = txtFechaDevolucion.getText();
        if(datosValidos(codigo,estudiante,fechaPrestamo,fechaDevolucion)){
            Biblioteca.crearPrestamo(codigo, estudiante, fechaPrestamo, fechaDevolucion);
            mostrarMensaje("Notificaión","El Prestamo se ha añadido","El prestamo se añadió correctamente");
        }else {
            mostrarMensaje("Error","Error", "No se pudo");
        }
        BancoController.guardarResourceXML();
        BancoController.cargarResourceXML();
    }
    private void loadTable(){
        columnNombreEstudiante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnFechaPrestamo.setCellValueFactory(new PropertyValueFactory<>("fecha de prestamo"));
        columnFechaDevolucion.setCellValueFactory(new PropertyValueFactory<>("fecha de devolucion"));
        columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        prestamos.clear();
        prestamos.addAll(Biblioteca.getPrestamos());
        tablePrestamosCliente.setItems(prestamos);

        tablePrestamos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                prestamoSeleccion = newSelection;

            }
        });
    }

    @FXML
    void actionEliminar(ActionEvent event) {
        try {
            Prestamo prestamo = (Prestamo) tablePrestamos.getSelectionModel().getSelectedItem();
            Biblioteca.eliminarPrestamo(prestamo.getCodigo());
            JOptionPane.showMessageDialog(null, "Prestamo eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en el sistema");

        }
        AdminController.guardarResourceXML();
        AdminController.cargarResourceXML();
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
        if (codigo == null || codigo.equals("")) {
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
     if(notificacion.equals("")){

            return true;
        }


        return false;
    }
    @FXML
    void actionRecargar(ActionEvent event) {
        prestamos.clear();
        prestamos.addAll(Biblioteca.eliminarPrestamo());
        tablePrestamos.setItems(prestamos);
    }




}
