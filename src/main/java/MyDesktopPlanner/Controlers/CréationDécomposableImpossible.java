package MyDesktopPlanner.Controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CréationDécomposableImpossible {
    private Stage parentStage;
    @FXML
    private Button fermerButton;
    @FXML
    void RetourModiferT(ActionEvent event) {
        Stage currentPopupStage = (Stage) fermerButton.getScene().getWindow();
        currentPopupStage.close();
    }

    @FXML
    void fermer(ActionEvent event) {
        Stage currentPopupStage = (Stage) fermerButton.getScene().getWindow();
        currentPopupStage.close();
        parentStage.close();
    }

    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }
}
