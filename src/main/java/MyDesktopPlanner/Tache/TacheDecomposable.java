package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

import MyDesktopPlanner.Décompossable.Décomposable;
public class TacheDecomposable extends Tache implements Décomposable, Serializable {

    public TacheDecomposable(String nom, String priorité, Duration durée) {
        super(nom, priorité, durée);
    }
}
