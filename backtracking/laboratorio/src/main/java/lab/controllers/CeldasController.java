package lab.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lab.modelo.Carcel;
import lab.modelo.CarcelThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CeldasController {
    @FXML
    public Pane tittlePane;
    @FXML
    public ImageView closebtn, minimizebtn;
    @FXML
    private ImageView carcelero = new ImageView(new Image("/images/carcelero.png"));
    @FXML
    private GridPane grid = new GridPane();
    @FXML
    private ImageView celda10;

    @FXML
    private ImageView celda11;
    @FXML
    private ImageView celda12;
    @FXML
    private ImageView celda13;
    @FXML
    private ImageView celda14;
    @FXML
    private ImageView celda2;
    @FXML
    private ImageView celda3;
    @FXML
    private ImageView celda4;
    @FXML
    private ImageView celda5;
    @FXML
    private ImageView celda6;
    @FXML
    private ImageView celda7;
    @FXML
    private ImageView celda8;
    @FXML
    private ImageView celda9;
    double x, y;
    private final Carcel carcel = new Carcel();
    private final CarcelThread carcelThread = new CarcelThread(carcel);
    public void init(Stage stage) {

        celda10.setUserData("celda10");
        celda11.setUserData("celda11");
        celda12.setUserData("celda12");
        celda13.setUserData("celda13");
        celda14.setUserData("celda14");
        celda2.setUserData("celda2");
        celda3.setUserData("celda3");
        celda4.setUserData("celda4");
        celda5.setUserData("celda5");
        celda6.setUserData("celda6");
        celda7.setUserData("celda7");
        celda8.setUserData("celda8");
        celda9.setUserData("celda9");


        carcelThread.start();
        grid.getChildren().remove(carcelero);
        grid.add(carcelero, carcel.getPosX(), carcel.getPosY());

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



    public void mouseClicked(MouseEvent mouseEvent) {
        if (!Objects.equals(carcel.getImage(), " ")){
            List<Node> nodos = new ArrayList<>();
            String identificador = carcel.getCelda(carcel.getXCelda(), carcel.getYCelda()).toString();
            for (Node nodo : grid.getChildren()) {
                String numId = (String) nodo.getUserData();


                // Verifica si las coordenadas coinciden
                if (numId != null && numId.equals(identificador)) {
                    // Elimina el nodo de la celda específica
                    nodos.add(nodo);
                }

            }
            grid.getChildren().removeAll(nodos);
            ImageView image = new ImageView(new Image(carcel.getImage()));
            image.setPreserveRatio(true); // Conserva la relación de aspecto de la imagen
            image.setFitWidth(95); // Establece el ancho deseado de la celda
            image.setFitHeight(95);
            grid.add(image, carcel.getYCelda(), carcel.getXCelda());

        }
        carcel.continuarRecorrido();
        grid.getChildren().remove(carcelero);
        grid.add(carcelero, carcel.getPosY(), carcel.getPosX());

    }
}
