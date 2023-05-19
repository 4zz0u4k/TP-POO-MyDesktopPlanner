package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;

public class AjoutCrénoControler {
    Utilisateur user;
    @FXML
    private TextField HD;
    @FXML
    private TextField MD;
    @FXML
    private TextField HF;
    @FXML
    private TextField MF;
    @FXML
    private TextField YEAR;
    @FXML
    private TextField Month;
    @FXML
    private TextField Date;

    @FXML
    public void AjouterCréno(ActionEvent event) {
        LocalTime startingTime = LocalTime.parse(HD.getText()+":"+MD.getText()+":00");
        LocalTime EndingTime = LocalTime.parse(HF.getText()+":"+MF.getText()+":00");
        LocalDate date = LocalDate.parse(YEAR.getText()+"-"+Month.getText()+"-"+ Date.getText());
        System.out.println(startingTime +" "+ EndingTime+" "+date);
        user.ajouterCrénoLibre(date,startingTime,EndingTime);
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
