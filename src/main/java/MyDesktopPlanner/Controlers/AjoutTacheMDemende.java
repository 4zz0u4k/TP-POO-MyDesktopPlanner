package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;

public class AjoutTacheMDemende {
    Utilisateur user;
    LocalDate date;
    @FXML
    void ChoixTacheDécomposable(ActionEvent event) {
        try{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("AjoutTacheDécomposable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            AjoutTacheDécomposableControler controller = fxmlLoader.getController();
            controller.setUser(user);
            stage.setTitle("Ajout tache Décomposable");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        }catch (Exception e){
            System.out.println("An error occured while login");
        }
    }

    @FXML
    void ChoixTacheSimple(ActionEvent event) {
        try{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("CréationMTS.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            CréationTMSControler controller = fxmlLoader.getController();
            controller.setDate(date);
            controller.setUser(user);
            stage.setTitle("Ajout tache simple");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        }catch (Exception e){
            System.out.println("An error occured while login");
        }
    }
    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
