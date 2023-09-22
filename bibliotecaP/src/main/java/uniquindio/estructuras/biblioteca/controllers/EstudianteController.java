package uniquindio.estructuras.biblioteca.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

    public class EstudianteController {

        @FXML
        private Button btnActualizarEstudiante;

        @FXML
        private Button btnAniadirEstudiante;

        @FXML
        private Button btnEliminarEstudiante;

        @FXML
        private TableColumn<?, ?> columnApellidoEstudiante;

        @FXML
        private TableColumn<?, ?> columnCedulaEstudiante;

        @FXML
        private TableColumn<?, ?> columnCorreoEstudiante;

        @FXML
        private TableColumn<?, ?> columnNombreEstudiante;

        @FXML
        private TableView<?> tableViewEmpleados;

        @FXML
        private TextField txtApellidoEstudiante;

        @FXML
        private TextField txtCedulaEstudiante;

        @FXML
        private TextField txtCorreoEstudiante;

        @FXML
        private TextField txtNombreEstudianre;

        @FXML
        void actionCrear(ActionEvent event) {

        }

        @FXML
        void actionEliminar(ActionEvent event) {

        }

        @FXML
        void actionRecargar(ActionEvent event) {

        }

    }

