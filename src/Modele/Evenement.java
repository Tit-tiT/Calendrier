package Modele;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Evenement extends JFrame {
    Jour jour;
    double heure;
    String titre;
    int urgence;

    public Evenement(String titre,Jour j){
        this.titre = titre;
        this.jour = j;
        this.urgence = 1;
        this.heure = -1;
    }

    public Evenement(String titre,Jour j, double heure){
        this(titre,j);
        heure = heure;
    }

    public Evenement(String titre,Jour j, int urgence){
        this(titre,j);
        setUrgence(urgence);
    }

    public Evenement(String titre,Jour j, double heure, int urgence){
        this(titre,j,heure);
        setUrgence(urgence);
    }


    public void setTitre(String titre){
        this.titre=titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setJour(Jour jour){
       this.jour=jour;
    }

    public Jour getJour() {
        return jour;
    }

    public double getHeure() {
        return heure;
    }

    public void setHeure(double heure) {

        if(!(heure>24 || heure<0)) this.heure = heure;
        else System.out.println("Entree invalide");
    }

    public int getUrgence() { return urgence; }

    public void setUrgence(int urgence){
        if(!(urgence>3 || urgence<0)) this.urgence=urgence;
        else System.out.println("Entree invalide");
    }

    public String toString(){

        String red = "\u001B[31m";
        String yellow = "\u001B[33m";
        DecimalFormat df = new DecimalFormat("########.00");
        String eve;

        if(heure!=-1.0){
           eve = this.jour.toString()+" "+ df.format(heure).replace(",","h") +" : "+titre+"\n\u001B[0m";
        }
        else{
            eve = this.jour.toString()+" : "+titre+"\n\u001B[0m";
        }

        if(urgence==3) eve = red+eve;
        else if (urgence==2) eve = yellow+eve;

        return eve;
    }
}


