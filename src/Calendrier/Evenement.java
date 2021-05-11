package Calendrier;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Evenement extends JFrame {
    Jour jour;
    double heure;
    String titre;
    int urgence;

    JPanel principal;

    public Evenement(LocalDate date){
        super("Nouvelle Evenement");
        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        this.jour=new Jour(date.getDayOfMonth(),date.getMonthValue(),date.getYear());



        this.getContentPane().add(principal);
        this.setPreferredSize(new Dimension(600, 300));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setTitre(String titre){
        this.titre=titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setDate(Jour jour){
       this.jour=jour;
    }

    public Jour getJour() {
        return jour;
    }

    public double getHeure() {
        return heure;
    }

    public void setUrgence(int urgence){
        if(!(urgence>3 || urgence<0)){
            this.urgence=urgence;
        }
        else{
            System.out.println("Entree invalide");
        }
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

        if(urgence==3){
            eve = red+eve;
        }
        else if (urgence==2){
            eve = yellow+eve;
        }

        return eve;
    }
}


