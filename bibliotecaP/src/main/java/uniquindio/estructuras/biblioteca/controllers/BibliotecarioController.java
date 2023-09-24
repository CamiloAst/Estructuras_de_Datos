package uniquindio.estructuras.biblioteca.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import uniquindio.estructuras.biblioteca.exceptions.CampoVacioException;
import uniquindio.estructuras.biblioteca.exceptions.UsuarioNoEncontradoException;
import uniquindio.estructuras.biblioteca.model.Biblioteca;

import java.io.IOException;

public class BibliotecarioController {
    ModelFactoryController INSTANCE = ModelFactoryController.getInstance();
    Biblioteca biblioteca = INSTANCE.getBiblioteca();
    double x,y;

    @FXML
    private Button btnIngresar;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private ImageView closeBtn;

    @FXML
    private ImageView hideBtn;

    @FXML
    private Pane tittlePane;

    @FXML
    void mouseClicked(MouseEvent event){
        if(txtIdentificacion.getText().isEmpty()){
            try {
                throw new CampoVacioException("Por favor ingrese todos los campos");
            } catch (CampoVacioException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            if(biblioteca.obtenerBibliotecario(txtIdentificacion.getText())!=null){
                INSTANCE.setUsuario(biblioteca.obtenerBibliotecario(txtIdentificacion.getText()));
                System.out.println("Bienvenido "+INSTANCE.getUsuario().getNombre());
                abrirVentana("../crudPrestamo.fxml",event);
            }
        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void abrirVentana(String s, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
        Parent root = loader.load();
//        CeldasController celdasController = loader.getController();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Prestamo");
//        scene.getStylesheets().add("styles/Styles.css");
        stage.getIcons().add(new javafx.scene.image.Image("/images/icon.png"));
        ((CrudPrestamoController)loader.getController()).init(stage);
        stage.show();
        Stage myStage = (Stage) btnIngresar.getScene().getWindow();
        myStage.close();
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

