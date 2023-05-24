package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Calendrier.Créno;
import MyDesktopPlanner.Calendrier.EtatCréno;
import MyDesktopPlanner.Tache.ProgressionTache;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class RendementJouralierControler {
    Utilisateur user;
    @FXML
    private Label Sur;

    @FXML
    private VBox VboxCompleted;

    @FXML
    private VBox VboxUncompleted;

    @FXML
    private Label nb;

    @FXML
    private Button ok;

    @FXML
    void ok(ActionEvent event) {
        Stage currentPopupStage = (Stage) ok.getScene().getWindow();
        currentPopupStage.close();
    }

    public void Display(){
        int nbcompleted = 0;
        int remaining = 0;
        ArrayList<Créno> listecréno = user.getCalendrier().getSpecificJourney(LocalDate.now()).getListeCréno();
        for (Créno créno : listecréno){
            if(créno.getÉtat() == EtatCréno.Occupée){
                Label progressLabel = new Label("Task Progress: " + créno.getTache().getProgressionTache());
                Label nameLabel = new Label("Task Name: " + créno.getTache().getNom());
                Label priorityLabel = new Label("Task Priority: " + créno.getTache().getPrioritée());
                if(créno.getTache().getProgressionTache() == ProgressionTache.completed){
                    VboxCompleted.getChildren().add(nameLabel);
                    VboxCompleted.getChildren().add(priorityLabel);
                    nbcompleted++;
                }else {
                    VboxUncompleted.getChildren().add(nameLabel);
                    VboxUncompleted.getChildren().add(priorityLabel);
                    remaining++;
                }
            }
        }
        nb.setText(String.valueOf(nbcompleted));
        Sur.setText(String.valueOf(remaining+nbcompleted));
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
