package MyDesktopPlanner.Calendrier;

import MyDesktopPlanner.Tache.TacheSimple;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.HashMap;
public class Calendrier implements Serializable {
    private HashMap<LocalDate, Jour> jours;
    public Calendrier(){
        this.jours = new HashMap<LocalDate, Jour>();
    }
    public void insertCreno(LocalDate dateInsertion , Créno créno){
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

    public void ajouterTacheSimpleManuelle(String nom, String priorité, Duration durée,LocalDate jour){
        if(jours.containsKey(jour)){
            System.out.println("Jour trouvée :)");
            if(jour.isBefore(LocalDate.now())){//Go atack les crénos

            }else {
                System.out.println("How come nigga ???");
            }
        }
        else {
            System.out.println("Ce jours n'existe pas :(");
        }
    }

    public Jour getSpecificJourney(LocalDate date){
        if(jours.containsKey(date)){
            return jours.get(date);
        }else {
            return null;
        }
    }

    public void planificationTacheSimple(LocalDate date, LocalTime heureDébut, LocalTime heureFin, int periodicité, int forHowLong, TacheSimple tache){
        if(jours.containsKey(date)){
            jours.get(date).planificationSM(heureDébut,heureFin,tache);
        }
        else {
            System.out.println("Y'a aucun créno libre dans ce jours la !! ");
        }
    }
}
