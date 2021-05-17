package Controleurs;

import Modele.Mois;
import Vue.Fenetre;
import Vue.PrinCentre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MoisPreceControleur implements ActionListener {
    private Fenetre fenetre;

    public MoisPreceControleur(Fenetre fn){
        this.fenetre=fn;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        LocalDate date = ((PrinCentre)fenetre.getPrinCentre()).getFirst();
        int valueMois = date.getMonthValue()-1;
        int annee=date.getYear();
        if(valueMois<1){
            valueMois=12;
            annee--;
        }
        Mois mois = new Mois(valueMois,annee);;
        PrinCentre centre = new PrinCentre(mois);
        fenetre.changePanelCentre(centre);
    }
}
