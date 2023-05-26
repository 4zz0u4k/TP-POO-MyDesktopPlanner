package MyDesktopPlanner.Controlers;
import MyDesktopPlanner.Authentification.Authentification;
import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.YearMonth;

public class AuthFormControler {

    @FXML
    private Label message;
    private Authentification auth;
    @FXML
    private TextField AuthUserName;
    @FXML
    void authInfosSubmission(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        auth = new Authentification();
        if (auth.verifierExistance(AuthUserName.getText())){
            try{
                Utilisateur user = auth.getUserByUserName(AuthUserName.getText());
                YearMonth yearMonthObject = YearMonth.now();
                FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("CalendarFX.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                CalendarControler MonthController = fxmlLoader.getController();
                MonthController.displayMonth(yearMonthObject , user);
                stage.setTitle("MyDesktopPlanner");
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
                stage.setOnCloseRequest(e -> {
                    // Call your function or perform any actions here
                    MonthController.handleCloseRequest(auth);
                });
            }catch (Exception e){
                System.out.println("An error occured while login");
            }
        }
        else {
            message.setText("Utilisateur Introuvable");
        }

    }

    @FXML
    void handleCompteCreationRedirection(ActionEvent event) {
        try{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("CreateUser.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("MyDesktopPlanner");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        }catch (Exception e){
            System.out.println("An error occured while login");
        }
    }
}
