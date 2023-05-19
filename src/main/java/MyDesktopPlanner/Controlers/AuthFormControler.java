package MyDesktopPlanner.Controlers;
import MyDesktopPlanner.Authentification.Authentification;
import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.YearMonth;

public class AuthFormControler {

    @FXML
    private TextField AuthUserName;
    @FXML
    void authInfosSubmission(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        System.out.println("UserName : " + AuthUserName.getText());
        // Loading the page
        try{
            Utilisateur user = new Utilisateur("azziz","akeb","4zzou","anything");
            YearMonth yearMonthObject = YearMonth.now();
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("CalendarFX.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            CalendarControler MonthController = fxmlLoader.getController();
            MonthController.displayMonth(yearMonthObject , user);
            stage.setTitle("MyDesktopPlanner");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        }catch (Exception e){
            System.out.println("An error occured while login");
        }

    }
}
