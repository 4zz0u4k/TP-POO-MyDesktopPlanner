package MyDesktopPlanner.Utilisateur;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import MyDesktopPlanner.Calendrier.*;

public class Utilisateur implements Serializable {
    //Infos User
    private String nom;
    private String prénom;
    private String userName;
    private String passWord;
    //Calendrier
    Calendrier calendrier;
    //Sauvgarde Planning


    public Utilisateur(String nom, String prénom, String userName, String passWord) {
        this.nom = nom;
        this.passWord = passWord;
        this.userName = userName;
        this.prénom = prénom;
        this.calendrier = new Calendrier();
    }

    public void initialisationCrénoLibre(){
        Scanner scanner = new Scanner(System.in);
        boolean inserer;
        System.out.println("Voulez vous inserer des crénos libre ?");
        String nouvelleInsertion = scanner.nextLine();
        if(nouvelleInsertion.compareTo("Yes") == 0){
            Créno nouveauCrénoLibre;
            inserer = true;
            String dateInserton;
            String heureDébut;
            String heureFin;
            while (inserer){
                System.out.println("Entrer la date : (Veuillez respecter le fomat YYYY-MM-DD)");
                dateInserton = scanner.nextLine();
                System.out.println("Entrer l'heure de debut : (Veuillez respecter le fomat HH-MM-SS)");
                heureDébut = scanner.nextLine();
                System.out.println("Entrer l'heure de Fin :  (Veuillez respecter le fomat HH-MM-SS)");
                heureFin = scanner.nextLine();
                if(vérifierValiditéDateHeure(heureDébut,heureFin,dateInserton)){
                    nouveauCrénoLibre = new Créno(LocalTime.parse(heureDébut),LocalTime.parse(heureFin),EtatCréno.Libre);
                    calendrier.insertCreno(LocalDate.parse(dateInserton),nouveauCrénoLibre);
                }else{
                    System.out.println(""); //A traiter ... ( ghlate fles infos lzm yetverifyaw shkn ghlate fihom w djih possiblité y3awd wesh ghlate brk )
                }
                System.out.println("Inserer un nouveau creno libre ? ");
                nouvelleInsertion = scanner.nextLine();
                if (nouvelleInsertion.compareTo("Yes") != 0){
                    inserer = false;
                    System.out.println("OK !!");
                }
                System.out.println("+---------------------------------+");
            }
        }
        else {
            System.out.println("OK !");
        }
    }

    public boolean vérifierValiditéDateHeure(String heureDébut,String heureFin,String date){
        try {
            LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            System.out.println("you didn't respect the giving date format :((  YYYY-MM-DD");
            return false;
        }
        if(LocalTime.parse(heureDébut).isAfter(LocalTime.parse(heureFin))) {
            System.out.println("heure Debut after heure fin ??");
            return false;
        }
        if(LocalDate.parse(date).isBefore(LocalDate.now())){
            System.out.println("Youcan't add a free creno in a date thats already passed mate :)");
            return false;
        }
        return true;
    }


    public boolean vérifierInfoAuth(String passWord){
        if(passWord.equals(this.passWord)){
            return true;
        }else {
            return false;
        }
    }

    public void planificationMannuelle(){
        System.out.println("Tache simple ou décomposable ?");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        if(choix == 0){ //Simple
            System.out.println("Name : ");
            String nom = scanner.nextLine();
            System.out.println("Priorité : ");
            String priorité = scanner.nextLine();
            System.out.println("Jour : ");
            String jour = scanner.nextLine();
            System.out.println("Durée : ");
            String durée = scanner.nextLine();
            this.calendrier.ajouterTacheSimpleManuelle(nom,priorité,Duration.parse(durée),LocalDate.parse(jour));
        }else { //Décomposable

        }
    }

    public void ajouterCrénoLibre(LocalDate date,LocalTime tempsDebut,LocalTime tempsFinale){
        Créno newCréno = new Créno(tempsDebut,tempsFinale,EtatCréno.Libre);
        calendrier.insertCreno(date,newCréno);
    }

    public String getUserName() {
        return userName;
    }
}
