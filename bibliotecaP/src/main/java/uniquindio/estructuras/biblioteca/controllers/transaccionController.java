package uniquindio.estructuras.biblioteca.controllers;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import uniquindio.estructuras.biblioteca.model.Biblioteca;
import uniquindio.estructuras.biblioteca.model.TextoLiterario;

public class transaccionController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnConsultar;

        @FXML
        private Button btnEntregar;

        @FXML
        private Button btnPedir;

        @FXML
        private TextField txtFechaTransaccion;

        @FXML
        private TextField txtLibroTransaccion;

        @FXML
        private TextField txtNombreTransaccion;

        @FXML
        void consultarAction(ActionEvent event) {
                TextoLiterario.consultarLibro(txtNombreTransaccion.getText(),txtFechaTransaccion.getText(), txtLibroTransaccion.getText());

        }

        @FXML
        void entregarAction(ActionEvent event) {

        }

        @FXML
        void pedirAction(ActionEvent event) {

        }

        @FXML
        void initialize() {
                assert btnConsultar != null : "fx:id=\"btnConsultar\" was not injected: check your FXML file 'transacciones.fxml'.";
                assert btnEntregar != null : "fx:id=\"btnEntregar\" was not injected: check your FXML file 'transacciones.fxml'.";
                assert btnPedir != null : "fx:id=\"btnPedir\" was not injected: check your FXML file 'transacciones.fxml'.";
                assert txtFechaTransaccion != null : "fx:id=\"txtFechaTransaccion\" was not injected: check your FXML file 'transacciones.fxml'.";
                assert txtLibroTransaccion != null : "fx:id=\"txtLibroTransaccion\" was not injected: check your FXML file 'transacciones.fxml'.";
                assert txtNombreTransaccion != null : "fx:id=\"txtNombreTransaccion\" was not injected: check your FXML file 'transacciones.fxml'.";

        }

        private void validarFields() throws Exception {
                if(txtNombreTransaccion.getText().equals("") && txtLibroTransaccion.getText().equals("")){
                        throw new Exception("Algun campo esta vacio");
                }
        }

}
