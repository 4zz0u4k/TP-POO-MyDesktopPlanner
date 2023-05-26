package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Calendrier.Créno;
import MyDesktopPlanner.Calendrier.EtatCréno;
import MyDesktopPlanner.Tache.ProgressionTache;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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
        if(user.getCalendrier().getSpecificJourney(LocalDate.now()) != null){
            if(user.getCalendrier().getSpecificJourney(LocalDate.now()).getListeCréno() != null){
                ArrayList<Créno> listecréno = user.getCalendrier().getSpecificJourney(LocalDate.now()).getListeCréno();
                for (Créno créno : listecréno){
                    if(créno.getÉtat() == EtatCréno.Occupée){
                        Label progressLabel = new Label("   Progression : " + créno.getTache().getProgressionTache());
                        Label nameLabel = new Label("    Tache : " + créno.getTache().getNom());
                        Label categorieLabel = new Label("   Categorie : " + créno.getTache().getPrioritée().getNom());
                        Label priorityLabel = new Label("   Prioritée : "+créno.getTache().getPrioritéeFr());
                        progressLabel.setStyle("-fx-font-size: 24px;");
                        nameLabel.setStyle("-fx-font-size: 24px;");
                        categorieLabel.setStyle("-fx-font-size: 24px;");
                        priorityLabel.setStyle("-fx-font-size: 24px;");
                        if(créno.getTache().getProgressionTache() == ProgressionTache.completed){
                            VboxCompleted.getChildren().add(nameLabel);
                            VboxCompleted.getChildren().add(priorityLabel);
                            VboxCompleted.getChildren().add(categorieLabel);
                            VboxCompleted.getChildren().add(progressLabel);
                            Separator separator = new Separator();
                            separator.setStyle("-fx-background-color: black; -fx-pref-width: 2px;");
                            VboxCompleted.getChildren().add(separator);
                            nbcompleted++;
                        }else {
                            VboxUncompleted.getChildren().add(nameLabel);
                            VboxUncompleted.getChildren().add(priorityLabel);
                            VboxUncompleted.getChildren().add(categorieLabel);
                            VboxUncompleted.getChildren().add(progressLabel);
                            Separator separator = new Separator();
                            separator.setStyle("-fx-background-color: black; -fx-pref-width: 2px;");
                            VboxUncompleted.getChildren().add(separator);
                            remaining++;
                        }
                    }
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
