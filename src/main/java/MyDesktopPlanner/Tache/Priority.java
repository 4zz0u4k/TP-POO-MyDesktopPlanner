package MyDesktopPlanner.Tache;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class Priority implements Serializable {
    private Color couleur;
    private String nom;
    public Priority(Color couleur, String nom){
        this.couleur = couleur;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Color getCouleur() {
        return couleur;
    }
}
