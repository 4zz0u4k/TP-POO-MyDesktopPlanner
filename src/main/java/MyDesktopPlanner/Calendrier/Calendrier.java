package MyDesktopPlanner.Calendrier;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.HashMap;
public class Calendrier implements Serializable {
    private HashMap<LocalDate, Jour> jours;
    public Calendrier(){
        this.jours = new HashMap<LocalDate, Jour>();
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 28; j++) {
                LocalDate date = LocalDate.of(Year.now().getValue(), i, j);
                Jour jour = new Jour();
                jours.put(date, jour);
            }
        }
    }
    public void insertCreno(LocalDate dateInsertion , Créno créno){
        if (jours.containsKey(dateInsertion)) {
            Jour jour = jours.get(dateInsertion);
            System.out.println("Date is founed");
            jour.insererCréno(créno);
        } else {
            // handle the case where the search date is not in the HashMap
            System.out.println("Nein makach had la date");
        }
    }
}
