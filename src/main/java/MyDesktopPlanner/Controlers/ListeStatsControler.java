package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListeStatsControler {
    Utilisateur user;
    @FXML
    void ShowEtat(ActionEvent event) {
        try{
            Stage Ajoutpopup = new Stage();
            Ajoutpopup.setTitle("Ajouter Créno");
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("DailyTacheLookUp.fxml"));
            Parent AjoutCréno = fxmlLoader.load();
            DailyTacheProgressionControler controller = fxmlLoader.getController();
            controller.setUser(user); // Set the user object on the controller
            controller.Display();
            Ajoutpopup.setScene(new Scene(AjoutCréno));
            Ajoutpopup.showAndWait();
        }catch (Exception e ){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    @FXML
    void showRendement(ActionEvent event) {
        try{
            Stage Ajoutpopup = new Stage();
            Ajoutpopup.setTitle("Ajouter Créno");
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("RendementJournalier.fxml"));
            Parent AjoutCréno = fxmlLoader.load();
            RendementJouralierControler controller = fxmlLoader.getController();
            controller.setUser(user); // Set the user object on the controller
            controller.Display();
            Ajoutpopup.setScene(new Scene(AjoutCréno));
            Ajoutpopup.showAndWait();
        }catch (Exception e ){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
