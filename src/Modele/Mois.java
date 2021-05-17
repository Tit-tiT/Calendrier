package Modele;

import java.time.LocalDate;

public class Mois {

    private String nom;
    private int numéro;
    private int annee;
    private Jour[] jours;

    public Mois(int num,int years){
        if(num<1 | num>12) System.out.println("Mauvais numéro");
        else{
            this.annee=years;
            String[] mois = new String[]{"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
            this.numéro=num;
            int nbJ = LocalDate.of(years,num,1).lengthOfMonth();
            this.nom=mois[LocalDate.of(years,num,1).getMonthValue()-1] + " " + years;
            jours = new Jour[nbJ];
            for(int i=1;i<=nbJ;i++){
                jours[i-1] = new Jour(i,num,years);
            }
        }
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getNom() {
        return nom;
    }

    public int getNuméro() {
        return numéro;
    }

    public Jour[] getJours() {
        return jours;
    }

    public String toString(){
        StringBuilder ret = new StringBuilder();
        for(Jour j : jours){
            ret.append("\n").append(j.toString());
        }
        return ret.toString();
    }
}
