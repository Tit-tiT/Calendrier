package Modele;

import java.time.LocalDate;

public class Jour {
    LocalDate date;

    public Jour(int jour,int mois,int annee){
        date = LocalDate.of(annee,mois,jour);
    }

    public Jour(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate() { return date; }

    public int getJour(){ return date.getDayOfMonth(); }

    public Mois getMois(){return new Mois(date.getMonthValue(),getAnnee());}

    public int getValeurMois(){ return date.getMonthValue(); }

    public int getAnnee(){ return date.getYear(); }

    public void setDate(int a, int m, int j){ date = LocalDate.of(a,m,j); }

    public void setJour(int j){ date = LocalDate.of(getAnnee(),getValeurMois(),j); }

    public void setMois(int m){ date = LocalDate.of(getAnnee(),m,getJour()); }

    public void setAnnee(int a){ date = LocalDate.of(a,getValeurMois(),getJour()); }

    public String toString(){
        String[] jour = new String[]{"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        String[] mois = new String[]{"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
        return jour[date.getDayOfWeek().getValue()-1]+ " "+date.getDayOfMonth()+" "+mois[date.getMonth().getValue()-1]+" "+date.getYear();
    }
}
