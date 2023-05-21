package MyDesktopPlanner.Authentification;
//Sérilisation + Authentification


import MyDesktopPlanner.Utilisateur.Utilisateur;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.TreeMap;

public class Authentification {
    private HashMap<String, Utilisateur> Utilisateurs = new HashMap<>();

    public Authentification(){
        try {
            FileInputStream fileInputStream = new FileInputStream("Users.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Utilisateurs = (HashMap<String, Utilisateur>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("HashMap successfully read from file.");
        } catch (Exception e) {
            // Handle any exceptions that occur during file reading or deserialization
            e.printStackTrace();
        }
    }
    public boolean verifierExistance(String userName){
        return Utilisateurs.containsKey(userName);
    }
    public void addUser(Utilisateur user){
        Utilisateurs.put(user.getUserName(),user);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Users.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Utilisateurs);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("HashMap successfully written to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Utilisateur getUserByUserName(String userName){
        return Utilisateurs.get(userName);
    }

    public void save(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Users.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Utilisateurs);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("HashMap successfully written to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
