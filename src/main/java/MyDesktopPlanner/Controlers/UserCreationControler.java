package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Authentification.Authentification;
import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.YearMonth;

public class UserCreationControler {
    @FXML
    private TextField nom;

    @FXML
    private TextField prénom;

    @FXML
    private TextField userName;

    @FXML
    void RegistrationHandle(ActionEvent event) {
        Utilisateur user = new Utilisateur(nom.getText(),prénom.getText(),userName.getText(),"0");
        Authentification auth = new Authentification();
        auth.addUser(user);
        try{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
