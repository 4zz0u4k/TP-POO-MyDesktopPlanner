package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Calendrier.Créno;
import MyDesktopPlanner.Calendrier.EtatCréno;
import MyDesktopPlanner.Calendrier.Jour;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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
        if(user.getCalendrier().getSpecificJourney(LocalDate.now()) != null){
            if(user.getCalendrier().getSpecificJourney(LocalDate.now()).getListeCréno() != null) {
                ArrayList<Créno> listecréno = user.getCalendrier().getSpecificJourney(LocalDate.now()).getListeCréno();
                Vbox.setSpacing(10);
                for (Créno créno : listecréno) {
                    if (créno.getÉtat() == EtatCréno.Occupée) {
                        Label progressLabel = new Label("   Progression : " + créno.getTache().getProgressionTache());
                        Label nameLabel = new Label("    Tache : " + créno.getTache().getNom());
                        Label categorieLabel = new Label("   Categorie : " + créno.getTache().getPrioritée().getNom());
                        Label priorityLabel = new Label("   Prioritée : " + créno.getTache().getPrioritéeFr());
                        progressLabel.setStyle("-fx-font-size: 24px;");
                        nameLabel.setStyle("-fx-font-size: 24px;");
                        categorieLabel.setStyle("-fx-font-size: 24px;");
                        priorityLabel.setStyle("-fx-font-size: 24px;");
                        Vbox.getChildren().add(nameLabel);
                        Vbox.getChildren().add(priorityLabel);
                        Vbox.getChildren().add(categorieLabel);
                        Vbox.getChildren().add(progressLabel);
                        Separator separator = new Separator();
                        separator.setStyle("-fx-background-color: black; -fx-pref-width: 2px;");
                        Vbox.getChildren().add(separator);
                    }
                }
            }else {
                Label noTasks = new Label("Pas de tache aujourd'hui");
                Vbox.getChildren().add(noTasks);
            }
        }
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
