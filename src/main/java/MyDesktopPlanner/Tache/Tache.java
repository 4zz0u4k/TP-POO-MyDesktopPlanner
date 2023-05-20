package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public abstract class Tache implements Serializable {
    private String nom;
    private Priority prioritée;
    private Duration durée;

    public Tache(String nom, String priorité, Duration durée) {

    }

    public Duration getDurée() {
        return durée;
    }
}
