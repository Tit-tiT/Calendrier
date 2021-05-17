import Controleurs.MoisPreceControleur;
import Controleurs.MoisSuivantControleur;
import Vue.Fenetre;
import Vue.PrinCentre;

public class AppCalendrier {
    public static void main(String[] args) {

        Fenetre f = new Fenetre();

        // Controleurs :
        ((PrinCentre)f.getPrinCentre()).actionMoisSui((new MoisSuivantControleur(f)));
        ((PrinCentre)f.getPrinCentre()).actionMoisPre((new MoisPreceControleur(f)));
        //((PrinCentre)f.getPrinCentre()).actionTab();

    }
}
