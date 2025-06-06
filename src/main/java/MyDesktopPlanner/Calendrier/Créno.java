package MyDesktopPlanner.Calendrier;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import MyDesktopPlanner.Décompossable.Décomposable;
import MyDesktopPlanner.Tache.*;
public class Créno implements Décomposable, Serializable,Comparable<Créno> {
    private LocalTime HeureDebut;
    private LocalTime HeureFin;
    private EtatCréno état;
    private Tache tache;
    private Duration limite = Duration.ofMinutes(30);

    public Créno(LocalTime HeureDebut, LocalTime HeureFin, EtatCréno état){
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.état = état;
    }

    @Override
    public int compareTo(Créno o) {
        if(o.getHeureDebut().isAfter(HeureDebut)){
            return -1;
        }else if (o.getHeureDebut().isBefore(HeureDebut)){
            return 1;
        }else {
            return 0;
        }
    }

    public LocalTime getHeureDebut() {
        return HeureDebut;
    }

    public LocalTime getHeureFin() {
        return HeureFin;
    }

    @Override
    public String toString() {
        // Return a string representation of the Créno object
        return "Créno [HeureDebut=" + HeureDebut + ", HeureFin=" + HeureFin + "]";
    }

    public boolean insertionPossible(LocalTime heureDebut,LocalTime heureFin){
        return (this.HeureDebut.isBefore(heureDebut) && this.HeureFin.isAfter(heureFin));
    }

    public void insererTacheSM(LocalTime heureDebut, TacheSimple tache, ArrayList<Créno> listeCréno){
        Duration remaining1 = Duration.between(this.HeureDebut,heureDebut);
        Duration remaining2 = Duration.between(heureDebut.plus(tache.getDurée()),this.HeureFin);
        if((remaining1.compareTo(limite) > 0)&&(remaining2.compareTo(limite) > 0)){ //Décomposition en 3
            Créno créno1 = new Créno(this.HeureDebut,heureDebut,EtatCréno.Libre);
            Créno créno2 = new Créno(heureDebut,heureDebut.plus(tache.getDurée()),EtatCréno.Occupée);
            créno2.setTache(tache);
            Créno créno3 = new Créno(heureDebut.plus(tache.getDurée()),this.HeureFin,EtatCréno.Libre);
            listeCréno.remove(this);
            listeCréno.add(créno1);
            listeCréno.add(créno2);
            listeCréno.add(créno3);
        } else if ((remaining1.compareTo(limite) > 0)&&(remaining2.compareTo(limite) <= 0)){ //Décomposition en 2 ( nouveau is the previous one !! )
            Créno créno1 = new Créno(this.HeureDebut,heureDebut,EtatCréno.Libre);
            Créno créno2 = new Créno(heureDebut,this.HeureFin,EtatCréno.Occupée);
            créno2.setTache(tache);
            listeCréno.remove(this);
            listeCréno.add(créno1);
            listeCréno.add(créno2);
        } else if ((remaining1.compareTo(limite) <= 0)&&(remaining2.compareTo(limite) > 0)){ //Décomposition en 2 ( nouveau upHead !! )
            Créno créno1 = new Créno(this.HeureDebut,heureDebut.plus(tache.getDurée()),EtatCréno.Occupée);
            Créno créno2 = new Créno(heureDebut.plus(tache.getDurée()),this.HeureFin,EtatCréno.Libre);
            créno1.setTache(tache);
            listeCréno.remove(this);
            listeCréno.add(créno1);
            listeCréno.add(créno2);
        }else{//Nothing to decompose !! insertion directe
            this.tache = tache;
        }
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public EtatCréno getÉtat() {
        return état;
    }

    public Tache getTache() {
        return tache;
    }
}
