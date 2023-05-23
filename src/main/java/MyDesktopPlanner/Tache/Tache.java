package MyDesktopPlanner.Tache;

import java.io.Serializable;
import java.time.Duration;

public abstract class Tache implements Serializable {
    protected String nom;
    protected Categorie categorie;
    protected Duration durée;
    protected ProgressionTache progressionTache;

    public Tache(String nom, Categorie categorie, Duration durée) {
        this.categorie = categorie;
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

    public Categorie getPrioritée() {
        return categorie;
    }

    public ProgressionTache getProgressionTache() {
        return progressionTache;
    }

    public void setProgressionTache(ProgressionTache progressionTache) {
        this.progressionTache = progressionTache;
    }
}
