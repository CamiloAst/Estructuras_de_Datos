package proyecto.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto.application.Aplicacion;
import proyecto.model.Proceso;
import proyecto.model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.*;


public class ProcesosRegularController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnAbrirProceso;

        @FXML
        private Button btnConsultarDuracionProceso;

        @FXML
        private Button btnEliminarProceso;

        @FXML
        private TableColumn<Proceso, String> tableProcesos;

        @FXML
        private ImageView iconUsuario;
        private Usuario usuario;

        private Aplicacion aplicacion;

        ObservableList<Proceso> listaProcesosData = FXCollections.observableArrayList();

        Proceso procesoSeleccionado;

        ObservableList<Proceso> ListaProcesosDataData = FXCollections.observableArrayList();

        @FXML
        void abrirProcesoAction(ActionEvent event) {

                

        }

        @FXML
        void consultarDuracionAction(ActionEvent event) {

        }

        @FXML
        void eliminarProcesoAction(ActionEvent event) {
                eliminarProcesoAction();
        }

        public void eliminarProcesoAction(){
                if(procesoSeleccionado != null){
                        aplicacion.eliminarProceso(String.valueOf(procesoSeleccionado));
                        listaProcesosData.remove(procesoSeleccionado);
                        procesoSeleccionado = null;
                }else{
                        mostrarMensaje("Error", "Error", "Debe seleccionar un proceso", Alert.AlertType.ERROR);
                }


        }



        private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

                Alert alert = new Alert(alertType);
                alert.setTitle(titulo);
                alert.setHeaderText(header);
                alert.setContentText(contenido);
                alert.showAndWait();
        }

        @FXML
        void usuarioEvent(MouseEvent event) {

        }




        private ObservableList <Proceso> getListaVendedoresData(){
                listaProcesosData.addAll(aplicacion.obtenerProcesos());
                return listaProcesosData;
        }

        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }

        public void setAplicacion(Aplicacion aplicacion) {
                this.aplicacion = aplicacion;
        }
}
