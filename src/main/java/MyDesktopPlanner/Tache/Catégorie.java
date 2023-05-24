package MyDesktopPlanner.Tache;

import java.io.Serializable;

public class Catégorie implements Serializable {
    private double red;
    private double green;
    private double blue;
    private String nom;
    public Catégorie(double red, double green, double blue, String nom){
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public double getBlue() {
        return blue;
    }

    public double getGreen() {
        return green;
    }

    public double getRed() {
        return red;
    }
}
