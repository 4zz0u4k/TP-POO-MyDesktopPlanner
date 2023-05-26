package MyDesktopPlanner.Calendrier;

import MyDesktopPlanner.Tache.ProgressionTache;
import MyDesktopPlanner.Tache.Tache;
import MyDesktopPlanner.Tache.TacheSimple;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Calendrier implements Serializable{
    private TreeMap<LocalDate, Jour> jours;
    private int minTask = 2;
    public Calendrier(){
        this.jours = new TreeMap<LocalDate,Jour>();
    }
    public void insertCreno(LocalDate dateInsertion , Créno créno){ //Traiter le return FALSE !!!
        if (jours.containsKey(dateInsertion)) {
            Jour jour = jours.get(dateInsertion);
            jour.insererCréno(créno);
            System.out.println("Contien deja un creno !!");
        } else {
            Jour jour = new Jour();
            jour.insererCréno(créno);
            jours.put(dateInsertion, jour);
            System.out.println("Initialisation d'une nouvelle date !!");
        }
    }


    public Jour getSpecificJourney(LocalDate date){
        if(jours.containsKey(date)){
            return jours.get(date);
        }else {
            return null;
        }
    }

    public void planificationTacheSimple(LocalDate date, LocalTime heureDébut, int periodicité, int forHowLong, Tache tache){
        if(jours.containsKey(date)){
            jours.get(date).planificationSM(heureDébut,tache);
        }
        else {
            System.out.println("Y'a aucun créno libre dans ce jours la !! ");
        }
    }
    public boolean generateProbablePlanning(LocalDate startingDate, LocalDate dateLimite, Duration durée, ArrayList<TupleCrénoDuréeExtraite> listeCandidat){
        Duration savedDurée = durée;
        for (LocalDate key : jours.keySet()) {
            Jour jour = jours.get(key);
            if (key.isAfter(startingDate.minusDays(1)) && key.isBefore(dateLimite.plusDays(1))){
                System.out.println("IN the date :  "+key);
                if(jour.checkInsertionPossible(durée,listeCandidat,key)){
                    return true;
                }
                if (!listeCandidat.isEmpty()){
                    durée = savedDurée;
                    Duration réervéeJusquaMaintenant = Duration.ofMinutes(0);
                    for (TupleCrénoDuréeExtraite element : listeCandidat){
                        réervéeJusquaMaintenant = réervéeJusquaMaintenant.plus(element.getDurée());
                    }
                    listeCandidat.get(listeCandidat.size()-1).getDurée();
                    durée = durée.minus(réervéeJusquaMaintenant);
                }
            }
        }
        return false;
    }
    public int BadgeUpdate(){
        final int[] res = {0};
        final int[] tmp = {0};
        final int[] dayCpt = {0};
        jours.forEach((date, day) -> {
            dayCpt[0]++;
            if(day.getTaskNumDay() >= minTask){
                tmp[0]++;
            }
            if(tmp[0] == 5 && dayCpt[0] ==5){
                res[0]++;
                dayCpt[0] = 0;
                tmp[0]= 0;
            }
        });
        return res[0];
    }
}
