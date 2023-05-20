package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Calendrier.Créno;
import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class JourControler {
    private Utilisateur user;
    private LocalDate date;
    @FXML
    private ScrollPane scrollBar;
    @FXML
    private ListView<Créno> viewList;
    @FXML
    private Button ButtonAjout;
    public void displayDays(){
        if(user.getSpecificJourney(date) != null){

            ArrayList<Créno> listeCréno = user.getSpecificJourney(date).getListeCréno();
            Collections.sort(listeCréno);
            //Display the liste of créno !!
            for(Créno créno : listeCréno){
                System.out.println(créno.getHeureDebut());
                viewList.getItems().add(créno);
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
    /*
    *         for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 15) {
                String hourLabel = String.format("    %02d:%02d", hour, minute);
                Label hourFXLabel = new Label(hourLabel);
                hourFXLabel.setFont(Font.font("Arial", FontWeight.MEDIUM, 18));

                if (minute > 0) {
                    hourFXLabel.setOpacity(0.3);
                }

                hoursContainer.getChildren().add(hourFXLabel);
            }
            if (hour < 23) {
                Line separatorLine = new Line();
                separatorLine.setEndX(800);
                separatorLine.setOpacity(0.1);
                separatorLine.setStroke(Color.GRAY);
                separatorLine.setStrokeWidth(1);
                hoursContainer.getChildren().add(separatorLine);
            }
        }
     */

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
