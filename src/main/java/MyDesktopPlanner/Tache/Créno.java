package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.LocalTime;
import MyDesktopPlanner.Décompossable.Décomposable;
public class Créno implements Décomposable, Serializable {
    private LocalTime HeureDebut;
    private LocalTime HeureFin;
    private EtatCréno état;
    private Tache tache;

    public Créno(LocalTime HeureDebut, LocalTime HeureFin, EtatCréno état){
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.état = état;
    }


    public LocalTime getHeureDebut() {
        return HeureDebut;
    }

    public LocalTime getHeureFin() {
        return HeureFin;
    }
}
