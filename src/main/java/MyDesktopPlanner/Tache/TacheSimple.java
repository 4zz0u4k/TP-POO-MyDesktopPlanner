package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public class TacheSimple extends Tache implements Serializable {
    public TacheSimple(String nom, Catégorie priorité, Duration durée,Prioritée prioritéeFr){
        super(nom,priorité,durée,prioritéeFr);
    }
}
