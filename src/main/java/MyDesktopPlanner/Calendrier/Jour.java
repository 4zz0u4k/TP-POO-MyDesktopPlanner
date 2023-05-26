package MyDesktopPlanner.Calendrier;

import MyDesktopPlanner.Tache.ProgressionTache;
import MyDesktopPlanner.Tache.Tache;
import MyDesktopPlanner.Tache.TacheSimple;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
public class Jour implements Serializable{
    ArrayList<Créno> listeCréno;
    private int TaskPerDay;
    public Jour(){
        listeCréno = new ArrayList<Créno>();
    }
    public boolean insererCréno(Créno newCréno){
        if (this.vérifierDisponibilitéeCréno(newCréno)){
            listeCréno.add(newCréno);
            return true;
        }else {
            return false;
        }
    }
    private boolean vérifierDisponibilitéeCréno(Créno nouveaCréno){
        for (Créno créno : listeCréno) {
            if((nouveaCréno.getHeureDebut().isAfter(créno.getHeureDebut())) && (nouveaCréno.getHeureDebut().isBefore(créno.getHeureFin()))){
                return false;
            } else if ((nouveaCréno.getHeureFin().isAfter(créno.getHeureDebut())) && (nouveaCréno.getHeureFin().isBefore(créno.getHeureFin()))) {
                return false;
            }
        }
        return true;
    }

    public void planificationSM(LocalTime heureDébut,Tache tache){
        for (Créno créno : listeCréno){
            if(créno.insertionPossible(heureDébut,heureDébut.plus(tache.getDurée()))){
                //insertion possible
                System.out.println("verifies cool");
                créno.insererTacheSM(heureDébut,tache,this.listeCréno);
                return;
            }else {
                System.out.println("noooo not possible");
            }
        }
    }

    public boolean checkInsertionPossible(Duration durée,ArrayList<TupleCrénoDuréeExtraite> listeCandidat,LocalDate date){
        TupleCrénoDuréeExtraite tupleCrénoDuréeExtraite;
        for(Créno créno : listeCréno){
            tupleCrénoDuréeExtraite = créno.checkAvailable(durée,date);
            if(tupleCrénoDuréeExtraite != null){
                listeCandidat.add(tupleCrénoDuréeExtraite);
                if(durée.compareTo(tupleCrénoDuréeExtraite.getDurée()) == 0){
                    return true;
                }
                durée = durée.minus(tupleCrénoDuréeExtraite.getDurée());
                System.out.println("The remaining durée : "+durée);
            }

        }
        return false;
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
