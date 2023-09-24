package uniquindio.estructuras.biblioteca.controllers;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uniquindio.estructuras.biblioteca.exceptions.CampoVacioException;
import uniquindio.estructuras.biblioteca.model.Biblioteca;

public class TransaccionController {
        Biblioteca biblioteca = ModelFactoryController.getInstance().getBiblioteca();

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
                biblioteca.consultarLibro(txtNombreTransaccion.getText(), txtLibroTransaccion.getText());

        }

        @FXML
        void entregarAction(ActionEvent event) {

        }

        @FXML
        void pedirAction(ActionEvent event) {

        }

        @FXML
        void initialize() {

        }

        private void validarFields() throws CampoVacioException {
                if(txtNombreTransaccion.getText().equals("") && txtLibroTransaccion.getText().equals("")){
                        throw new CampoVacioException("Algun campo esta vacio");
                }
        }

        public void init(Stage stage) {
//                tittlePane.setOnMousePressed(mouseEvent -> {
//                        x = mouseEvent.getSceneX();
//                        y = mouseEvent.getSceneY();
//                });
//                tittlePane.setOnMouseDragged(mouseEvent -> {
//                        stage.setX(mouseEvent.getScreenX() - x);
//                        stage.setY(mouseEvent.getScreenY() - y);
//                });
//
//                closeBtn.setOnMouseClicked(mouseEvent -> {
//                        stage.close();
//                });
//                hideBtn.setOnMouseClicked(mouseEvent -> {
//                        stage.setIconified(true);
//                });
        }
}
