package MyDesktopPlanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Systeme extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("AuthentificationForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1290, 600);
        stage.setTitle("MyDesktopPlanner");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}