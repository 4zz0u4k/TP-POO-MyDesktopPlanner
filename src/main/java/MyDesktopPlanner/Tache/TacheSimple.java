package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public class TacheSimple extends Tache implements Serializable {
    public TacheSimple(String nom, Categorie categorie, Duration durée){
        super(nom,categorie,durée);
    }
}
