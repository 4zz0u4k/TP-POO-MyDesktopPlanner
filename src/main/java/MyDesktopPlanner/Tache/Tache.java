package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public abstract class Tache implements Serializable {
    protected String nom;
    protected Catégorie prioritée;
    protected Duration durée;
    protected ProgressionTache progressionTache;
    protected Prioritée prioritéeFr;

    public Tache(String nom, Catégorie priorité, Duration durée,Prioritée prioritéeFr) {
        this.prioritée = priorité;
        this.durée = durée;
        this.nom = nom;
        this.progressionTache = ProgressionTache.inProgress;
        this.prioritéeFr = prioritéeFr;
    }

    public Duration getDurée() {
        return durée;
    }

    public String getNom() {
        return nom;
    }

    public Catégorie getPrioritée() {
        return prioritée;
    }

    public ProgressionTache getProgressionTache() {
        return progressionTache;
    }

    public void setProgressionTache(ProgressionTache progressionTache) {
        this.progressionTache = progressionTache;
    }
}
