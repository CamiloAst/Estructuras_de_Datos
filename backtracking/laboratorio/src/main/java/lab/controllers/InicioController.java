package lab.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

public class InicioController {
    @FXML
    public Button btnRevisar;
    @FXML
    private Pane tittlePane;
    @FXML
    private ImageView closebtn, minimizebtn;

    private double x, y;
    public void init(Stage stage) {
        tittlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        tittlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        closebtn.setOnMouseClicked(mouseEvent -> {
            stage.close();
        });
        minimizebtn.setOnMouseClicked(mouseEvent -> {
            stage.setIconified(true);
        });
    }

    public void onMouseClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../celdas.fxml"));
        Parent root = loader.load();
//        CeldasController celdasController = loader.getController();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Celdas");
        scene.getStylesheets().add("estilos/CeldasStyles.css");
        stage.getIcons().add(new javafx.scene.image.Image("/images/icon.png"));
        ((CeldasController)loader.getController()).init(stage);
        stage.show();
        Stage myStage = (Stage) btnRevisar.getScene().getWindow();
        myStage.close();
    }

}
