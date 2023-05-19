package MyDesktopPlanner.Controlers;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JourControler {
    @FXML
    private ScrollPane scrollBar;
    @FXML
    private VBox hoursContainer;
    public void displayDays(){
        for (int hour = 0; hour < 24; hour++) {
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
    }
}
