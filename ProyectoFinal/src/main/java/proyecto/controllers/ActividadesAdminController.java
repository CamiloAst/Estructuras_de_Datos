package proyecto.controllers;

import proyecto.application.Aplicacion;
import proyecto.model.Actividad;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class ActividadesAdminController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label actualizarActividad;

        @FXML
        private TableColumn<Actividad, String> columnDescripcionActvidad;

        @FXML
        private TableColumn<Actividad, String> columnNombreActividad;

        @FXML
        private TableColumn<Actividad, String> columnTiempoMaximoActividad;

        @FXML
        private ComboBox<Actividad> comboBoxObligatoria;

        @FXML
        private Label crearActividad;

        @FXML
        private Label eliminarActividad;

        @FXML
        private ImageView iconLogin;

        @FXML
        private TableView<?> tableActividades;

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

        private Actividad actividad;


    @FXML
        void actualizarActividad(MouseEvent event) {

        }

        @FXML
        void crearActividadAction(MouseEvent event) {

        }

        @FXML
        void eliminarActividad(MouseEvent event) {

        }

        @FXML
        void verTareasAction(MouseEvent event) {

        }

        @FXML
        void initialize() {
            assert actualizarActividad != null : "fx:id=\"actualizarActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
            assert columnDescripcionActvidad != null : "fx:id=\"columnDescripcionActvidad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
            assert columnNombreActividad != null : "fx:id=\"columnNombreActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
            assert columnTiempoMaximoActividad != null : "fx:id=\"columnTiempoMaximoActividad\" was not injected: check your FXML file 'ActividadesAdmin.fxml'.";
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

        }


    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void serActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}
