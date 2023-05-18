module com.example.mydesktopplannerapp {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens MyDesktopPlanner to javafx.fxml;
    opens MyDesktopPlanner.Controlers to javafx.fxml;
    exports MyDesktopPlanner;
}