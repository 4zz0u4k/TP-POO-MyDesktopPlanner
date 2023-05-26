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
import javafx.geometry.Pos;
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
                    //Couleur
                    Color couleur = new Color(créno.getTache().getPrioritée().getRed(), créno.getTache().getPrioritée().getGreen(), créno.getTache().getPrioritée().getBlue(), 1.0);
                    //Categorie
                    String catégorie = créno.getTache().getPrioritée().getNom();
                    Label CateLabel = new Label("   Categorie : "+catégorie);
                    CateLabel.setStyle("-fx-font-size: 24px");
                    CateLabel.setBackground(new Background(new BackgroundFill(couleur, CornerRadii.EMPTY, Insets.EMPTY)));
                    //Name
                    String tacheName = créno.getTache().getNom();
                    Label nameLabel = new Label("   Tache : "+tacheName);
                    nameLabel.setStyle("-fx-font-size: 24px;");
                    nameLabel.setBackground(new Background(new BackgroundFill(couleur, CornerRadii.EMPTY, Insets.EMPTY)));
                    //HeureDébut
                    Label heureDébutLabel = new Label("   Debut : "+créno.getHeureDebut());
                    heureDébutLabel.setStyle("-fx-font-size: 24px;");
                    heureDébutLabel.setBackground(new Background(new BackgroundFill(couleur, CornerRadii.EMPTY, Insets.EMPTY)));
                    //Durée
                    Label duréeLabel = new Label("   Durée : "+créno.getTache().getDurée().toString());
                    duréeLabel.setStyle("-fx-font-size: 24px;");
                    duréeLabel.setBackground(new Background(new BackgroundFill(couleur, CornerRadii.EMPTY, Insets.EMPTY)));
                    //Prioritée
                    Label prioritéeLabel = new Label("   Prioritée : "+créno.getTache().getPrioritéeFr());
                    prioritéeLabel.setStyle("-fx-font-size: 24px;");
                    prioritéeLabel.setBackground(new Background(new BackgroundFill(couleur, CornerRadii.EMPTY, Insets.EMPTY)));

                    ObservableList<ProgressionTache> progression = FXCollections.observableArrayList(ProgressionTache.completed,ProgressionTache.cancelled,ProgressionTache.inProgress,ProgressionTache.notRealzed,ProgressionTache.reported);
                    ComboBox<ProgressionTache> comboBoxProgression = new ComboBox<>(progression);
                    comboBoxProgression.setStyle("-fx-font-size: 16px; -fx-pref-width: 200px;");
                    comboBoxProgression.setValue(créno.getTache().getProgressionTache());

                    //The adding part
                    TheTaskVBox.getChildren().add(nameLabel);
                    TheTaskVBox.getChildren().add(heureDébutLabel);
                    TheTaskVBox.getChildren().add(duréeLabel);
                    TheTaskVBox.getChildren().add(CateLabel);
                    TheTaskVBox.getChildren().add(prioritéeLabel);
                    TheTaskVBox.getChildren().add(comboBoxProgression);
                    comboBoxProgression.valueProperty().addListener((observable, oldValue, newValue) -> {
                        créno.getTache().setProgressionTache(newValue);
                    });
                    Separator separator = new Separator();
                    separator.setStyle("-fx-background-color: black; -fx-pref-width: 2px;");
                    TheTaskVBox.getChildren().add(separator);
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
