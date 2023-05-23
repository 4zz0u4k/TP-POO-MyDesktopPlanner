package MyDesktopPlanner.Calendrier;

import MyDesktopPlanner.Tache.ProgressionTache;
import MyDesktopPlanner.Tache.TacheSimple;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
public class Jour implements Serializable {
    ArrayList<Créno> listeCréno;
    private int TaskPerDay;
    public Jour(){
        listeCréno = new ArrayList<Créno>();
        TaskPerDay = 0;
    }
    public boolean insererCréno(Créno newCréno){
        if (this.vérifierDisponibilitéeCréno(newCréno)){
            listeCréno.add(newCréno);
            //System.out.println("Suiiiiiii sa verife");
            return true;
        }else {
            //System.out.println("Ak dekhltou f w7d kyn deja !!");
            return false;
        }
    }
    private boolean vérifierDisponibilitéeCréno(Créno nouveaCréno){
        for (Créno créno : listeCréno) {
            if((nouveaCréno.getHeureDebut().isAfter(créno.getHeureDebut())) && (nouveaCréno.getHeureDebut().isBefore(créno.getHeureFin()))){
                System.out.println("Vous ete entrain d'inserer dans créno qui existe deja !!! ");
                return false;
            } else if ((nouveaCréno.getHeureFin().isAfter(créno.getHeureDebut())) && (nouveaCréno.getHeureFin().isBefore(créno.getHeureFin()))) {
                System.out.println("Well m3a lwl ak s7i7 mais mzl dekhlou f w7d");
                return false;
            }
        }
        return true;
    }

    public void planificationSM(LocalTime heureDébut, TacheSimple tache){
        for (Créno créno : listeCréno){
            if(créno.insertionPossible(heureDébut,heureDébut.plus(tache.getDurée()))){
                //insertion possible
                créno.insererTacheSM(heureDébut,tache,this.listeCréno);
                return;
            }
        }
    }

    public void affichageCrenos(){
        for (Créno crenos : listeCréno){
            System.out.println(crenos.toString());
        }
    }

    public int getTaskNumDay(){
        TaskPerDay = 0;
        for (Créno créno : listeCréno){
            if(créno.getTache() != null && créno.getTache().getProgressionTache() == ProgressionTache.completed){
                TaskPerDay++;
            }
        }
        return TaskPerDay;
    }
    public ArrayList<Créno> getListeCréno() {
        return listeCréno;
    }
}
