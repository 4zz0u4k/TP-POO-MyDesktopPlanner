package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public class TacheSimple extends Tache implements Serializable {
    public TacheSimple(String nom, String priorité, Duration durée){
        super(nom,priorité,durée);
    }
}
