package Controleurs;

import Modele.Mois;
import Vue.Fenetre;
import Vue.PrinCentre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MoisSuivantControleur implements ActionListener {
    private Fenetre fenetre;

    public MoisSuivantControleur(Fenetre fn){
        this.fenetre=fn;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        LocalDate date = ((PrinCentre)fenetre.getPrinCentre()).getFirst();
        int valueMois = date.getMonthValue()+1;
        int annee=date.getYear();
        if(valueMois>12){
            valueMois=1;
            annee++;
        }
        Mois mois = new Mois(valueMois,annee);;
        PrinCentre centre = new PrinCentre(mois);
        fenetre.changePanelCentre(centre);
    }
}
