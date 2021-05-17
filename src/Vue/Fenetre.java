package Vue;

import Modele.Jour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Fenetre extends JFrame {

    private JPanel principal;
    private JPanel prinHaut;
    private JPanel prinCentre;

    private JLabel labelToday;

    private Jour jour = new Jour(LocalDate.now());

    public Fenetre(){
        super("Calendrier");
        this.setPreferredSize(new Dimension(900, 600));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //--------------------//

        // Panel principal :
        principal = new JPanel(new BorderLayout());

        // Panel prinHaut :
        prinHaut = new JPanel();

        labelToday = new JLabel(jour.toString(),JLabel.CENTER);
        labelToday.setFont(new Font("Arial",Font.BOLD,32));
        prinHaut.add(labelToday);this.setContentPane(principal);

        principal.add(prinHaut,BorderLayout.NORTH);

        // Panel prinCentre :
        prinCentre = new PrinCentre(jour.getMois());
        principal.add(prinCentre,BorderLayout.CENTER);


        //--------------------//

        this.setContentPane(principal);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel getPrinCentre() {
        return prinCentre;
    }

    public Jour getJour() {
        return jour;
    }

    public void changePanelCentre(JPanel centre){
        principal.remove(prinCentre);
        if(centre.getClass()==PrinCentre.class && prinCentre.getClass()==PrinCentre.class){
            if(((PrinCentre)prinCentre).getMoisSui().getActionListeners()!=null){
                ((PrinCentre)centre).actionMoisSui(((PrinCentre)prinCentre).getMoisSui().getActionListeners()[0]);
            }
            if(((PrinCentre)prinCentre).getMoisPre().getActionListeners()!=null){
                ((PrinCentre)centre).actionMoisPre(((PrinCentre)prinCentre).getMoisPre().getActionListeners()[0]);
            }
        }
        prinCentre = centre;
        principal.add(prinCentre,BorderLayout.CENTER);
        principal.updateUI();
    }
}
