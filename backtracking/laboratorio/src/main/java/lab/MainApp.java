package lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
//        scene.getStylesheets().add("lab/estilos/inicioStyles.css");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
//        stage.getIcons().add(new javafx.scene.image.Image("images/icon.png"));
        stage.setTitle("Inicio");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
