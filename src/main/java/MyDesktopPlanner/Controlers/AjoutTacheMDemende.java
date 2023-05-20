package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.time.LocalTime;

public class AjoutTacheMDemende {
    Utilisateur user;
    LocalDate date;
    @FXML
    void ChoixTacheDécomposable(ActionEvent event) {

    }

    @FXML
    void ChoixTacheSimple(ActionEvent event) {

    }
    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
