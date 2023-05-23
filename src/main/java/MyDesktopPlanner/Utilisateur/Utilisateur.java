package MyDesktopPlanner.Utilisateur;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import MyDesktopPlanner.Calendrier.*;
import MyDesktopPlanner.Tache.Tache;
import MyDesktopPlanner.Tache.TacheDecomposable;
import MyDesktopPlanner.Tache.TacheSimple;

public class Utilisateur implements Serializable {
    //Infos User
    private String nom;
    private String prénom;
    private String userName;
    //Calendrier
    Calendrier calendrier;
    //Sauvgarde Planning


    public Utilisateur(String nom, String prénom, String userName, String passWord) {
        this.nom = nom;
        this.userName = userName;
        this.prénom = prénom;
        this.calendrier = new Calendrier();
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

    public void planificationManuelleSimple(LocalDate date, LocalTime heureDébut, int pèriodicité, int forHowLong,Tache tache){ //Tache Simple w teba3 l problem !!
        calendrier.planificationTacheSimple(date,heureDébut,pèriodicité,forHowLong,tache);
    }

    public void ajouterCrénoLibre(LocalDate date,LocalTime tempsDebut,LocalTime tempsFinale){
        Créno newCréno = new Créno(tempsDebut,tempsFinale,EtatCréno.Libre);
        calendrier.insertCreno(date,newCréno);
    }

    public ArrayList<TupleCrénoDuréeExtraite> planificationManuelleDécomposable(LocalDate startingDate,LocalDate dateLimite, Duration durée,TacheDecomposable tache){
        ArrayList<TupleCrénoDuréeExtraite> listeCondidat = new ArrayList<TupleCrénoDuréeExtraite>();
        if(calendrier.generateProbablePlanning(startingDate,dateLimite,durée,listeCondidat)){
            System.out.println("Good planning candidat génere avec succés");
            for (TupleCrénoDuréeExtraite tuple : listeCondidat){
                System.out.println("Date : "+tuple.getDate()+"\n Durée dans cette date : "+tuple.getDurée());
            }
            return listeCondidat;
        }else{
            System.out.println("Insertion de cette tache est impossible");
            return null;
        }
    }

    public void UserApprovedTheDecomposablePlanning(ArrayList<TupleCrénoDuréeExtraite> listeCondidat, TacheDecomposable tache){
        //Parcourir le plan candidat et décomposer la tache au meme temps
        int compteur = 1;
        for (TupleCrénoDuréeExtraite tuple : listeCondidat){
            Tache tacheAinser = new TacheDecomposable(tache.getNom()+" "+compteur,tache.getPrioritée(),tuple.getDurée());
            compteur += 1;
            calendrier.planificationTacheSimple(tuple.getDate(),tuple.getCréno().getHeureDebut(),0,0,tacheAinser);
            System.out.println("Date : "+tuple.getDate()+"\n Durée dans cette date : "+tuple.getDurée());
        }
    }

    public Jour getSpecificJourney(LocalDate date){
        return calendrier.getSpecificJourney(date);
    }

    public String getUserName() {
        return userName;
    }
}
