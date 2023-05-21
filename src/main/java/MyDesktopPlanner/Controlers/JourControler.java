package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Calendrier.Créno;
import MyDesktopPlanner.Calendrier.EtatCréno;
import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Tache.ProgressionTache;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class JourControler {
    private Utilisateur user;
    private LocalDate date;
    @FXML
    private ScrollPane scrollBar;

    @FXML
    private VBox TheTaskVBox;
    @FXML
    private Button ButtonAjout;
    public void displayDays(){
        if(user.getSpecificJourney(date) != null){

            ArrayList<Créno> listeCréno = user.getSpecificJourney(date).getListeCréno();
            Collections.sort(listeCréno);
            //Display the liste of créno !!
            for(Créno créno : listeCréno){
                System.out.println("One to go");
                if (créno.getÉtat()== EtatCréno.Libre){
                    //Vide
                }
                else {
                    String priority = créno.getTache().getPrioritée().getNom();
                    Color couleur = new Color(créno.getTache().getPrioritée().getRed(), créno.getTache().getPrioritée().getGreen(), créno.getTache().getPrioritée().getBlue(), 1.0);
                    String tacheName = créno.getTache().getNom();
                    Duration durée = créno.getTache().getDurée();
                    Label nameLabel = new Label(tacheName);
                    nameLabel.setStyle("-fx-font-size: 28px;");
                    Label priorityLabel = new Label(priority);
                    priorityLabel.setStyle("-fx-font-size: 28px");
                    priorityLabel.setBackground(new Background(new BackgroundFill(couleur, CornerRadii.EMPTY, Insets.EMPTY)));
                    nameLabel.setBackground(new Background(new BackgroundFill(couleur, CornerRadii.EMPTY, Insets.EMPTY)));
                    ObservableList<ProgressionTache> progression = FXCollections.observableArrayList(ProgressionTache.completed,ProgressionTache.cancelled,ProgressionTache.inProgress,ProgressionTache.notRealzed,ProgressionTache.reported);
                    ComboBox<ProgressionTache> comboBoxProgression = new ComboBox<>(progression);
                    comboBoxProgression.setStyle("-fx-font-size: 16px; -fx-pref-width: 200px;");
                    comboBoxProgression.setValue(créno.getTache().getProgressionTache());
                    TheTaskVBox.getChildren().add(priorityLabel);
                    TheTaskVBox.getChildren().add(nameLabel);
                    TheTaskVBox.getChildren().add(comboBoxProgression);
                    comboBoxProgression.valueProperty().addListener((observable, oldValue, newValue) -> {
                        créno.getTache().setProgressionTache(newValue);
                    });
                }
            }
        }
        else{
            //Display "No Créno is founed !!!"
        }
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @FXML
    void AjouterTacheManuelleAvecDateDispo(ActionEvent event) {
        try{
            Stage Ajoutpopup = new Stage();
            Ajoutpopup.setTitle("Sélectioner le type de la tache");
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("AjoutTacheManuelleDemendeType.fxml"));
            Parent SélectionTache = fxmlLoader.load();
            AjoutTacheMDemende controller = fxmlLoader.getController();
            controller.setUser(user); // Set the user object on the controller
            controller.setDate(date);
            Ajoutpopup.setScene(new Scene(SélectionTache));
            Ajoutpopup.showAndWait();
        }catch (Exception e ){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

}
