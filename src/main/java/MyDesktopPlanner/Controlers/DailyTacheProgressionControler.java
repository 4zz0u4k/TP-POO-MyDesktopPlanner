package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Calendrier.Créno;
import MyDesktopPlanner.Calendrier.EtatCréno;
import MyDesktopPlanner.Calendrier.Jour;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class DailyTacheProgressionControler {
    Utilisateur user;
    @FXML
    private Label Label;

    @FXML
    private VBox Vbox;

    @FXML
    private Button OKbutton;

    @FXML
    void OK(ActionEvent event) {
        Stage currentPopupStage = (Stage) OKbutton.getScene().getWindow();
        currentPopupStage.close();
    }

    public void Display(){
        ArrayList<Créno> listecréno = user.getCalendrier().getSpecificJourney(LocalDate.now()).getListeCréno();
        for (Créno créno : listecréno){
            if(créno.getÉtat() == EtatCréno.Occupée){
                Label progressLabel = new Label("Task Progress: " + créno.getTache().getProgressionTache());
                Label nameLabel = new Label("Task Name: " + créno.getTache().getNom());
                Label priorityLabel = new Label("Task Priority: " + créno.getTache().getPrioritée());
                Vbox.getChildren().add(nameLabel);
                Vbox.getChildren().add(priorityLabel);
                Vbox.getChildren().add(progressLabel);
                Vbox.setSpacing(10);
            }
        }
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
