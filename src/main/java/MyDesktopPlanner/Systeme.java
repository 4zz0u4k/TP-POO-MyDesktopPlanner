package MyDesktopPlanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.YearMonth;

public class Systeme extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        YearMonth yearMonthObject = YearMonth.now();
        //Loading the page
        FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("AuthentificationForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MyDesktopPlanner");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}