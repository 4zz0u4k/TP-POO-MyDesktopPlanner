package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Systeme;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

public class CalendarControler {
    @FXML
    private GridPane calendarGrid;
    @FXML
    private Label MonthYearDislay;
    @FXML
    private Button goBackward;
    @FXML
    private Button goForward;
    @FXML
    private Button AjtCrénoBTN;

    public void displayMonth(YearMonth yearMonthObject, Utilisateur user) {
        calendarGrid.getChildren().clear(); // Clear existing buttons
        MonthYearDislay.setText(yearMonthObject.getMonth().toString()+" "+yearMonthObject.getYear());
        LocalDate firstDayOfMonth = yearMonthObject.atDay(1);
        int firstDateNumber = firstDayOfMonth.getDayOfWeek().getValue();
        if(firstDateNumber == 7){
            firstDateNumber = 0;
        }

        int row = 0;
        int col = firstDateNumber;

        for(int day = 1; day <= yearMonthObject.lengthOfMonth(); day++) {
            Button button = new Button(String.valueOf(day));
            button.setPrefWidth(60);
            button.setPrefHeight(60);
            // Add event handler to handle button click and navigate to the specific date

            calendarGrid.add(button, col, row);

            int finalDay = day;

            button.setOnAction(event -> handleDateSelection(finalDay,yearMonthObject,user));

            GridPane.setHalignment(button, HPos.CENTER); // Align horizontally to center
            GridPane.setValignment(button, VPos.CENTER); // Align vertically to center
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
        goBackward.setOnAction(event -> handleGoBackward(yearMonthObject,user));
        goForward.setOnAction(event -> handleGoForward(yearMonthObject,user));
        AjtCrénoBTN.setOnAction(event -> handleAjoutCréno(user));
    }

    private void handleGoBackward(YearMonth theCurrentONe,Utilisateur user) {
        displayMonth(theCurrentONe.minusMonths(1),user);
    }

    private void handleGoForward(YearMonth theCurrentONe,Utilisateur user) {
        displayMonth(theCurrentONe.plusMonths(1),user);
    }
    private void handleDateSelection(int date ,YearMonth yearMonth,Utilisateur user){
        try{
            System.out.println(date + " "+yearMonth);
            Stage Ajoutpopup = new Stage();
            Ajoutpopup.setTitle("Ajouter Créno");
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("JourFX.fxml"));
            Parent AffJour = fxmlLoader.load();
            JourControler controller = fxmlLoader.getController();
            controller.setUser(user); // Set the user object on the controller
            controller.setDate(yearMonth.atDay(date));
            controller.displayDays();
            Ajoutpopup.setScene(new Scene(AffJour));
            Ajoutpopup.showAndWait();

        }catch (Exception e ){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
    private void handleAjoutCréno(Utilisateur user){
        try{
            Stage Ajoutpopup = new Stage();
            Ajoutpopup.setTitle("Ajouter Créno");
            FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("AjoutCreno.fxml"));
            Parent AjoutCréno = fxmlLoader.load();
            AjoutCrénoControler controller = fxmlLoader.getController();
            controller.setUser(user); // Set the user object on the controller
            Ajoutpopup.setScene(new Scene(AjoutCréno));
            Ajoutpopup.showAndWait();
        }catch (Exception e ){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

}
