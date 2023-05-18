package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public abstract class Tache implements Serializable {
    private String nom;
    private Prioritée prioritée;
    private Duration durée;
}
