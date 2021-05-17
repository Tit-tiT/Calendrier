package Vue;

import Modele.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class PrinCentre extends JPanel {

    private JPanel centreHaut;
    private JPanel centreCentre;

    private JLabel moisEtAnnee;

    private Bouton moisPre;
    private Bouton moisSui;

    private Object[] tab;

    private LocalDate date = LocalDate.now();
    private  LocalDate first;

    public PrinCentre(Mois mois){
        super(new BorderLayout());
        first = LocalDate.of(mois.getAnnee(),mois.getNuméro(),1);

        // Panel centreHaut :
        centreHaut = new JPanel();

        moisPre = new Bouton("←");
        moisPre.setPreferredSize(new Dimension(50,25));
        moisPre.setHoverColor(new Color(180,180,180));
        centreHaut.add(moisPre);

        centreHaut.add(new JLabel("     "));

        moisEtAnnee = new JLabel(mois.getNom(),JLabel.CENTER);
        moisEtAnnee.setFont(new Font("Arial",Font.PLAIN,24));
        centreHaut.add(moisEtAnnee);

        centreHaut.add(new JLabel("     "));

        moisSui = new Bouton("→");
        moisSui.setPreferredSize(new Dimension(50,25));
        moisSui.setHoverColor(new Color(180,180,180));
        centreHaut.add(moisSui);

        this.add(centreHaut,BorderLayout.NORTH);

        // Panel centreCentre :

        centreCentre = new JPanel();
        centreCentre.setLayout(new GridLayout(7,7,2,2));

        tab = new Object[50];
        String[] jour = new String[]{"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        String[] moistab = new String[]{"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
        int jOW = first.getDayOfWeek().getValue()+7;
        int nbJM = first.lengthOfMonth();

        for(int i=1; i<50;i++){
            if(i<=7){
                tab[i] = new JLabel(jour[i-1],JLabel.CENTER);
            }
            else if(i>7 && i<jOW){
                tab[i]=new JLabel("");
            }
            else if(i<=jOW+nbJM && i>jOW){
                if(first.getMonthValue()==date.getMonthValue() && first.getYear()==date.getYear() && i-jOW==date.getDayOfMonth()){
                    Bouton today = new Bouton(String.valueOf(i-jOW));
                    today.setBackground2(new Color(130,130,130));
                    today.setHoverColor(new Color(180,180,180));
                    today.setPressColor(new Color(230,230,230));
                    today.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));
                    today.setForeground(Color.WHITE);
                    tab[i] = today;
                }
                else{
                    Bouton day = new Bouton(String.valueOf(i-jOW));
                    day.setHoverColor(new Color(180,180,180));
                    tab[i]= day;
                }
            }
            else if(i>jOW+nbJM){
                tab[i]= new JLabel("");
            }
        }

        for(Object obj : tab){
            if(obj!=null){
                if(obj.getClass()==JLabel.class){centreCentre.add((JLabel)obj);}
                else{centreCentre.add((Bouton)obj);}
            }
        }

        this.add(centreCentre,BorderLayout.CENTER);


    }

    public Bouton getMoisPre() {
        return moisPre;
    }

    public LocalDate getFirst() {
        return first;
    }

    public Bouton getMoisSui() {
        return moisSui;
    }

    public Object[] getTab() {
        return tab;
    }

    public void actionMoisPre(ActionListener action){ moisPre.addActionListener(action);}

    public void actionMoisSui(ActionListener action){ moisSui.addActionListener(action);}

    public  void actionTab(ActionListener action){ for(Object o : tab){ if(o.getClass()==Bouton.class) ((Bouton) o).addActionListener(action);} }

    //    public void mouseMoisPre(MouseListener mouse){ moisPre.addMouseListener(mouse);}
//
//    public void mouseMoisSui(MouseListener mouse){ moisSui.addMouseListener(mouse);}
//
//    public  void mouseTab(MouseListener mouse){ for(Object o : tab){ if(o.getClass()==Bouton.class) ((Bouton) o).addMouseListener(mouse);}}

}
