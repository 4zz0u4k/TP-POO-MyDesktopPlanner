package MyDesktopPlanner.Controlers;

import MyDesktopPlanner.Systeme;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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

    public void displayMonth(YearMonth yearMonthObject) {
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

            button.setOnAction(event -> handleDateSelection(finalDay,yearMonthObject));

            GridPane.setHalignment(button, HPos.CENTER); // Align horizontally to center
            GridPane.setValignment(button, VPos.CENTER); // Align vertically to center
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
        goBackward.setOnAction(event -> handleGoBackward(yearMonthObject));
        goForward.setOnAction(event -> handleGoForward(yearMonthObject));
    }

    private void handleGoBackward(YearMonth theCurrentONe) {
        displayMonth(theCurrentONe.minusMonths(1));
    }

    private void handleGoForward(YearMonth theCurrentONe) {
        displayMonth(theCurrentONe.plusMonths(1));
    }
    private void handleDateSelection(int date ,YearMonth yearMonth){

    }

}
