package uniquindio.estructuras.biblioteca.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.print.DocFlavor;
import java.util.ResourceBundle;

public class EstudianteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private DocFlavor.URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    void mouseClicked(MouseEvent event) {

        // aqui poner la ventana de transacciones :D

    }

    @FXML
    void initialize() {
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'estudiante.fxml'.";
        assert txtContrasenia != null : "fx:id=\"txtContrasenia\" was not injected: check your FXML file 'estudiante.fxml'.";
        assert txtIdentificacion != null : "fx:id=\"txtIdentificacion\" was not injected: check your FXML file 'estudiante.fxml'.";

    }



}
