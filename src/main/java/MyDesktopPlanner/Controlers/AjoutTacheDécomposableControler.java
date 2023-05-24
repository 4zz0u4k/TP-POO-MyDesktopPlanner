package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Calendrier.TupleCrénoDuréeExtraite;
import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Tache.Catégorie;
import MyDesktopPlanner.Tache.Prioritée;
import MyDesktopPlanner.Tache.TacheDecomposable;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class AjoutTacheDécomposableControler {
    Utilisateur user;
    @FXML
    private TextField Catégorie;

    @FXML
    private TextField Dateinit;

    @FXML
    private TextField Datelim;

    @FXML
    private TextField DuréeHeur;

    @FXML
    private TextField DuréeMinute;

    @FXML
    private TextField Monthinit;

    @FXML
    private TextField Monthlim;

    @FXML
    private TextField YEARinit;

    @FXML
    private TextField YEARlim;

    @FXML
    private Button afficherPlan;

    @FXML
    private ColorPicker couleurCategorie;

    @FXML
    private TextField nomTache;

    @FXML
    private ComboBox<Prioritée> Prioritéee;

    void initilize(){
        Prioritéee.getItems().addAll(Prioritée.values());
        Prioritéee.setValue(Prioritée.MEDIUM);
    }

    @FXML
    void handleSubmission(ActionEvent event) {
        double red = couleurCategorie.getValue().getRed();
        double green = couleurCategorie.getValue().getGreen();
        double blue = couleurCategorie.getValue().getBlue();
        MyDesktopPlanner.Tache.Catégorie catégorie = new Catégorie(red,green,blue,Catégorie.getText());
        TacheDecomposable tache = new TacheDecomposable(nomTache.getText(),catégorie,Duration.ofMinutes(Integer.parseInt(DuréeMinute.getText())).plusHours(Integer.parseInt(DuréeHeur.getText())), Prioritéee.getValue());
        ArrayList<TupleCrénoDuréeExtraite> listeCandidat =  user.planificationManuelleDécomposable(LocalDate.parse(YEARinit.getText()+"-"+Monthinit.getText()+"-"+ Dateinit.getText()),LocalDate.parse(YEARlim.getText()+"-"+Monthlim.getText()+"-"+ Datelim.getText()), Duration.ofMinutes(Integer.parseInt(DuréeMinute.getText())).plusHours(Integer.parseInt(DuréeHeur.getText())),tache);
        if(listeCandidat != null){ //Proposer !!
            try{
                Stage ConfirmationPOPUP = new Stage();
                ConfirmationPOPUP.setTitle("Confirmer le plan");
                FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("ConfirmDécomposable.fxml"));
                Parent AffJour = fxmlLoader.load();
                ValideDécomposable controler = fxmlLoader.getController();
                controler.setParentStage((Stage) ((Node) event.getSource()).getScene().getWindow());
                controler.setListeCandidta(listeCandidat);
                controler.DisplayList();
                controler.setTache(tache);
                controler.setUser(user);
                ConfirmationPOPUP.setScene(new Scene(AffJour));
                ConfirmationPOPUP.showAndWait();

            }catch (Exception e ){
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }else { //Impossible
            try{
                Stage NotPossiblePOPUP = new Stage();
                NotPossiblePOPUP.setTitle("Impossible !!");
                FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("CréationDécomposableImpossible.fxml"));
                Parent AffJour = fxmlLoader.load();
                CréationDécomposableImpossible controler = fxmlLoader.getController();
                controler.setParentStage((Stage) ((Node) event.getSource()).getScene().getWindow());
                NotPossiblePOPUP.setScene(new Scene(AffJour));
                NotPossiblePOPUP.showAndWait();

            }catch (Exception e ){
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
