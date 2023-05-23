package MyDesktopPlanner.Calendrier;

import MyDesktopPlanner.Tache.TacheSimple;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Calendrier implements Serializable {
    private HashMap<LocalDate, Jour> jours;
    //min Tache par jour
    private int minTask = 2;
    public Calendrier(){
        this.jours = new HashMap<LocalDate, Jour>();
    }
    public void insertCreno(LocalDate dateInsertion , Créno créno){
        if (jours.containsKey(dateInsertion)) {
            Jour jour = jours.get(dateInsertion);
            jour.insererCréno(créno);
            //System.out.println("Contien deja un creno !!");
        } else {
            Jour jour = new Jour();
            jour.insererCréno(créno);
            jours.put(dateInsertion, jour);
            //System.out.println("Initialisation d'une nouvelle date !!");
        }
    }


    public Jour getSpecificJourney(LocalDate date){
        if(jours.containsKey(date)){
            return jours.get(date);
        }else {
            return null;
        }
    }

    public void planificationTacheSimple(LocalDate date, LocalTime heureDébut, int periodicité, int forHowLong, TacheSimple tache){
        if(jours.containsKey(date)){
            jours.get(date).planificationSM(heureDébut,tache);
        }
        else {
            System.out.println("Y'a aucun créno libre dans ce jours la !! ");
        }
    }

    public void afficher(){
        jours.forEach((date, day) -> {
            System.out.print(date.toString());
            day.affichageCrenos();
            System.out.println();
        });
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
