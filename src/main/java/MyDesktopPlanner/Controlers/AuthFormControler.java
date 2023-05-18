package MyDesktopPlanner.Controlers;
import MyDesktopPlanner.Authentification.Authentification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthFormControler {

    @FXML
    private TextField AuthUserName;
    @FXML
    void authInfosSubmission(ActionEvent event) {
        System.out.println("UserName : "+AuthUserName.getText());
        Authentification auth = new Authentification();
    }
}
