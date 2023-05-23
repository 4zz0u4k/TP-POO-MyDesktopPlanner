package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Calendrier.TupleCrénoDuréeExtraite;
import MyDesktopPlanner.Tache.Tache;
import MyDesktopPlanner.Tache.TacheDecomposable;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ValideDécomposable {
    ArrayList<TupleCrénoDuréeExtraite> listeCandidta;
    Utilisateur user;
    Tache tache;
    private Stage parentStage;
    @FXML
    private Button AnnulerButton;
    @FXML
    private Button ValiderButton;
    @FXML
    private VBox Vbox;

    void DisplayList(){
        for(TupleCrénoDuréeExtraite element : listeCandidta){
            System.out.println("Humm : "+element.getDate().toString());
            LocalTime HeureDébut = element.getCréno().getHeureDebut();
            LocalTime HeureFin = element.getCréno().getHeureDebut().plus(element.getDurée());
            LocalDate date = element.getDate();
            HBox hbox = new HBox();
            Text textHeureDebut = new Text("Heure de début: " + HeureDébut.toString());
            Text textHeureFin = new Text("Heure de fin: " + HeureFin.toString());
            Text textDate = new Text("Date: " + date.toString());
            hbox.getChildren().addAll(textHeureDebut, textHeureFin, textDate);
            Vbox.getChildren().add(hbox);
        }
    }

    @FXML
    void Anuller(ActionEvent event) {
        Stage currentPopupStage = (Stage) AnnulerButton.getScene().getWindow();
        currentPopupStage.close();
        parentStage.close();
    }

    @FXML
    void Valider(ActionEvent event) {
        user.UserApprovedTheDecomposablePlanning(listeCandidta,(TacheDecomposable) tache);
        Stage currentPopupStage = (Stage) AnnulerButton.getScene().getWindow();
        currentPopupStage.close();
        parentStage.close();
    }

    public void setListeCandidta(ArrayList<TupleCrénoDuréeExtraite> listeCandidta) {
        this.listeCandidta = listeCandidta;
    }

    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
}
