package MyDesktopPlanner.Authentification;
//Sérilisation + Authentification


import MyDesktopPlanner.Utilisateur.Utilisateur;
import java.util.TreeMap;

public class Authentification {
    private TreeMap<String, Utilisateur> Utilisateurs;
    public boolean verifierExistance(String userName){
        return Utilisateurs.containsKey(userName);
    }
}
