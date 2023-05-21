package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public abstract class Tache implements Serializable {
    protected String nom;
    protected Priority prioritée;
    protected Duration durée;
    protected ProgressionTache progressionTache;

    public Tache(String nom, Priority priorité, Duration durée) {
        this.prioritée = priorité;
        this.durée = durée;
        this.nom = nom;
        this.progressionTache = ProgressionTache.inProgress;
    }

    public Duration getDurée() {
        return durée;
    }

    public String getNom() {
        return nom;
    }

    public Priority getPrioritée() {
        return prioritée;
    }

    public ProgressionTache getProgressionTache() {
        return progressionTache;
    }

    public void setProgressionTache(ProgressionTache progressionTache) {
        this.progressionTache = progressionTache;
    }
}
