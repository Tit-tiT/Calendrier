package Calendrier;

public class Jour {
    int jour;
    int mois;
    int an;

    public Jour(int jour,int mois,int an){
        if(!(jour>31 | mois>12)){
            this.jour=jour;
            this.mois=mois;
            this.an=an;
        }
        else{
            System.out.println("Entree invalide");
        }
    }

    public void setDate(int jour, int mois, int an){
        if(!(jour>31 | mois>12)){
            this.jour=jour;
            this.mois=mois;
            this.an=an;
        }
        else{
            System.out.println("Entree invalide");
        }
    }

    public String getDate(){
        String mois2 = String.valueOf(mois);
        String jour2 = String.valueOf(jour);

        if(mois<10){
            mois2 = "0"+ String.valueOf(mois);
        }
        if(jour<10){
            jour2 = "0"+ String.valueOf(jour);
        }
        return jour2+"/"+mois2+"/"+an;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAn() {
        return an;
    }

    public String toString(){
        String mois2 = String.valueOf(mois);
        String jour2 = String.valueOf(jour);
        if(mois<10){
            mois2 = "0"+ String.valueOf(mois);
        }
        if(jour<10){
            jour2 = "0"+ String.valueOf(jour);
        }

        return jour2+"/"+mois2+"/"+an;
    }
}
