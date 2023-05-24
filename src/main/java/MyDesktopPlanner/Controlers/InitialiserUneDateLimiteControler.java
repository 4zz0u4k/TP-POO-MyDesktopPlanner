package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;

public class InitialiserUneDateLimiteControler {
    Utilisateur user;
    @FXML
    private TextField Year;

    @FXML
    private TextField date;

    @FXML
    private TextField month;

    @FXML
    private Button submit;

    @FXML
    void submit(ActionEvent event) {
        user.setDateLimitePlanning(LocalDate.parse(Year.getText()+"-"+month.getText()+"-"+ date.getText()));
        Stage currentPopupStage = (Stage) submit.getScene().getWindow();
        currentPopupStage.close();
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
