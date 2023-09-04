package lab.controllers;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CeldasController {
    public Pane tittlePane;
    public ImageView closebtn, minimizebtn;

    double x, y;
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
