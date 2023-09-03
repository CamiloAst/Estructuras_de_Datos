package lab.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.awt.*;

public class InicioController {
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
}
