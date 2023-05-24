package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Tache.Catégorie;
import MyDesktopPlanner.Tache.Prioritée;
import MyDesktopPlanner.Tache.TacheSimple;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class CréationTMSControler {
    Utilisateur user;
    LocalDate date;
    @FXML
    private TextField DuréeHeur;

    @FXML
    private TextField DuréeMinute;

    @FXML
    private TextField HeureDébut;

    @FXML
    private TextField MinuteDébut;

    @FXML
    private TextField NomTMS;

    @FXML
    private CheckBox PériodiqueBTN;

    @FXML
    private TextField nbFois;

    @FXML
    private TextField priority;

    @FXML
    private ColorPicker priorityColor;

    @FXML
    private TextField période;


    @FXML
    private ComboBox<Prioritée> Prioritéee;
    @FXML
    void handleSubmission(ActionEvent event) {
        double red = priorityColor.getValue().getRed();
        double green = priorityColor.getValue().getGreen();
        double blue = priorityColor.getValue().getBlue();
        Catégorie prioritée = new Catégorie(red,green,blue,priority.getText());
        TacheSimple nouvellTache = new TacheSimple(NomTMS.getText(),prioritée, Duration.ofMinutes(Integer.parseInt(DuréeMinute.getText())).plusHours(Integer.parseInt(DuréeHeur.getText())), Prioritéee.getValue());
        user.planificationManuelleSimple(date, LocalTime.of(Integer.parseInt(HeureDébut.getText()),Integer.parseInt(MinuteDébut.getText())),Integer.parseInt(période.getText()),Integer.parseInt(nbFois.getText()),nouvellTache);
    }

    void initialize(){
        Prioritéee.getItems().addAll(Prioritée.values());
        Prioritéee.setValue(Prioritée.MEDIUM);
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
