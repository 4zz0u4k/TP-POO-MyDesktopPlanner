package MyDesktopPlanner;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;


public class Systeme extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        //YearMonth yearMonthObject = YearMonth.now();
        //Loading the page
        FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("AuthentificationForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MyDesktopPlanner");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        /*
        Utilisateur user = new Utilisateur("Anything","azzou","azzou14","anything");
        Utilisateur user1 = new Utilisateur("Anything","azzou","azzou56","anything");
        Utilisateur user2 = new Utilisateur("Anything","azzou","azzou42","anything");
        Utilisateur user3 = new Utilisateur("Anything","azzou","azzou41","anything");
        Utilisateur user4 = new Utilisateur("Anything","azzou","azzou4","anything");
        TreeMap<String,Utilisateur> Utilisateurs= new TreeMap<String,Utilisateur>();
        Utilisateurs.put(user.getUserName(),user);
        Utilisateurs.put(user1.getUserName(),user1);
        Utilisateurs.put(user2.getUserName(),user2);
        Utilisateurs.put(user3.getUserName(),user3);
        Utilisateurs.put(user4.getUserName(),user4);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Users.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Utilisateurs);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("TreeMap successfully written to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /// the tache decomposable

        Utilisateur user = new Utilisateur("Anything","azzou","azzou14","anything");

        user.ajouterCrénoLibre(LocalDate.parse("2023-12-12"), LocalTime.parse("12:00:00"),LocalTime.parse("13:00:00"));
        user.ajouterCrénoLibre(LocalDate.parse("2023-12-14"), LocalTime.parse("12:00:00"),LocalTime.parse("18:00:00"));
        user.ajouterCrénoLibre(LocalDate.parse("2023-12-13"), LocalTime.parse("12:00:00"),LocalTime.parse("12:30:00"));
        Priority priorité = new Priority(0.2,0.2,0.2,"anything");
        TacheDecomposable tache = new TacheDecomposable("name",priorité,Duration.ofHours(3));
        user.planificationManuelleDécomposable(LocalDate.parse("2023-12-12"),LocalDate.parse("2023-12-14"), Duration.ofHours(3),tache);
        TreeMap<String,Utilisateur> Utilisateurs= new TreeMap<String,Utilisateur>();
        Utilisateurs.put(user.getUserName(),user);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Users.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Utilisateurs);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("TreeMap successfully written to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }


         */

    launch();

    }
}