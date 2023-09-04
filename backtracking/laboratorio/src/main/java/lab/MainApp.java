package lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lab.controllers.InicioController;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Inicio");
        scene.getStylesheets().add("estilos/InicioStyles.css");
        stage.getIcons().add(new Image("/images/icon.png"));
        ((InicioController)fxmlLoader.getController()).init(stage);
        stage.show();
    }

//    public void mostrarVentanaCeldas()
    public static void main(String[] args) {
        launch();
    }
}
