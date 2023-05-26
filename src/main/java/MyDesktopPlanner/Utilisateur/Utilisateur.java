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
import MyDesktopPlanner.Tache.Prioritée;
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
    LocalDate dateLimitePlanning = LocalDate.MIN;
    Badge badgeStatus;

    public Utilisateur(String nom, String prénom, String userName, String passWord) {
        this.nom = nom;
        this.userName = userName;
        this.prénom = prénom;
        this.calendrier = new Calendrier();
        this.badgeStatus = Badge.Nothing;
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
            Tache tacheAinser = new TacheDecomposable(tache.getNom()+" "+compteur,tache.getPrioritée(),tuple.getDurée(), Prioritée.LOW);
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

    public LocalDate getDateLimitePlanning() {
        return dateLimitePlanning;
    }

    public void setDateLimitePlanning(LocalDate dateLimitePlanning) {
        this.dateLimitePlanning = dateLimitePlanning;
    }

    public Calendrier getCalendrier() {
        return calendrier;
    }
    public Void SetBadge(){
        int res =  calendrier.BadgeUpdate();
        if(res == 0){
            this.badgeStatus = Badge.Nothing;
        }else if(res == 1){
            this.badgeStatus = Badge.Good;
        }else if(res == 2){
            this.badgeStatus = Badge.VeryGood;
        }else {
            this.badgeStatus = Badge.Excellent;
        }
        return null;
    }
}
