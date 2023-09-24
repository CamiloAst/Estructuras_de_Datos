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
import uniquindio.estructuras.biblioteca.exceptions.UsuarioNoEncontradoException;
import uniquindio.estructuras.biblioteca.model.Biblioteca;

import java.io.IOException;

public class EstudianteController {
    Biblioteca biblioteca = ModelFactoryController.getInstance().getBiblioteca();


    Double x,y;
    @FXML
    private Button btnIngresar;

    @FXML
    private ImageView closeBtn;

    @FXML
    private ImageView hideBtn;

    @FXML
    private Pane tittlePane;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    void mouseClicked(MouseEvent event) throws UsuarioNoEncontradoException, IOException {
        if(txtIdentificacion.getText().isEmpty()){
            throw new UsuarioNoEncontradoException("Por favor ingrese todos los campos");
        }
        abrirVentana("../transaccion.fxml",event);

    }

    private void abrirVentana(String s, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../bibliotecario.fxml"));
        Parent root = loader.load();
//        CeldasController celdasController = loader.getController();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Bibliotecario");
//        scene.getStylesheets().add("styles/Styles.css");
        stage.getIcons().add(new javafx.scene.image.Image("/images/icon.png"));
        ((TransaccionController)loader.getController()).init(stage);
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
