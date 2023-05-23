package MyDesktopPlanner;
import MyDesktopPlanner.Calendrier.Créno;
import MyDesktopPlanner.Calendrier.Jour;
import MyDesktopPlanner.Tache.Categorie;
import MyDesktopPlanner.Tache.ProgressionTache;
import MyDesktopPlanner.Tache.Tache;
import MyDesktopPlanner.Tache.TacheSimple;
import MyDesktopPlanner.Utilisateur.Utilisateur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;

public class Systeme extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        YearMonth yearMonthObject = YearMonth.now();
        //Loading the page
        /*FXMLLoader fxmlLoader = new FXMLLoader(Systeme.class.getResource("AuthentificationForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MyDesktopPlanner");
        stage.setScene(scene);
        stage.show();*/

        //Utilisateur user = new Utilisateur("Karim", "Karim", "Benkrid", "Soumia");
        //Créno testCreno = new Créno("20:20:20", "23:23:23", );

    }

    public static void main(String[] args) {
        //launch();
        //System.out.println(LocalTime.parse("20-20-20"));

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

        try {
            FileInputStream fileInputStream = new FileInputStream("Users.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Utilisateurs = (TreeMap<String, Utilisateur>) objectInputStream.readObject();
            /*for(String key: Utilisateurs.keySet()){
                System.out.println("La valeur de "+key+" est: "+Utilisateurs.get(key));
            }*/



            //------------Tache------------------
            Categorie cat = new Categorie(0,0,0,"new");
            Duration duration = Duration.of(60, ChronoUnit.MINUTES);
            TacheSimple myTask = new TacheSimple("test",cat,duration);
            myTask.setProgressionTache(ProgressionTache.completed);
            TacheSimple myTask1 = new TacheSimple("test222222222",cat,duration);
            myTask1.setProgressionTache(ProgressionTache.completed);

            //----------------les crenos------------------
            LocalDate dt1 = LocalDate.parse("2023-05-25");
            LocalTime TimeD1 = LocalTime.parse("20:24:25");
            LocalTime TimeF1 = LocalTime.parse("23:59:59");
            LocalTime TimeD1N = LocalTime.parse("14:24:25");
            LocalTime TimeF1N = LocalTime.parse("18:59:59");
            Utilisateurs.get("azzou14").ajouterCrénoLibre(dt1,TimeD1,TimeF1);
            Utilisateurs.get("azzou14").ajouterCrénoLibre(dt1,TimeD1N,TimeF1N);
            Jour day1 = Utilisateurs.get("azzou14").getSpecificJourney(dt1);
            Créno test1 = day1.getListeCréno().get(0);
            Créno test1N = day1.getListeCréno().get(1);
            test1.setTache(myTask);
            test1N.setTache(myTask1);

            Utilisateurs.get("azzou14").afficherCalComplet();
            //System.out.println(Utilisateurs.get("azzou14").badge());


            objectInputStream.close();
            fileInputStream.close();
            System.out.println("TreeMap successfully read from file.");
        } catch (Exception e) {
            // Handle any exceptions that occur during file reading or deserialization
            e.printStackTrace();
        }


    }
}