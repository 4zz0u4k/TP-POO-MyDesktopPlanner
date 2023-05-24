package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public class TacheDecomposable extends Tache implements Serializable {

    public TacheDecomposable(String nom, Catégorie priorité, Duration durée,Prioritée prioritéeFr) {
        super(nom, priorité, durée,prioritéeFr);
    }
}
