package Calendrier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Calendrier extends JFrame implements ActionListener {
    LocalDate date = LocalDate.now();
    LocalDate first = LocalDate.of(date.getYear(),date.getMonthValue(),1);

    JPanel principal;
    JPanel nord;
    JPanel centre;
    JPanel centreCentre;
    JPanel centreNord;

    JLabel dateLabel;
    JLabel titreCentre;

    JButton moisSui;
    JButton moisPre;
    JButton retour;
    JButton addEve;

    public Calendrier() {
        super("Calendrier");
        principal = new JPanel();
        principal.setLayout(new BorderLayout());

        // NORD
        nord = new JPanel();
        dateLabel = new JLabel(dateToString(date),JLabel.CENTER);
        dateLabel.setFont(new Font("Arial",Font.BOLD,32));
        nord.add(dateLabel);
        principal.add(nord,BorderLayout.NORTH);

        // CENTRE
        centre = new JPanel();
        centre.setLayout(new BorderLayout());
        centreNord = new JPanel();
        centreCentre = new JPanel();
        centreCentre.setLayout(new GridLayout(7,7,1,1));
        tabMois();
        principal.add(centre,BorderLayout.CENTER);

        this.getContentPane().add(principal);
        this.setPreferredSize(new Dimension(900, 600));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Calendrier();
    }

    public String dateToString(LocalDate date){
        String[] jour = new String[]{"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        String[] mois = new String[]{"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
        return jour[date.getDayOfWeek().getValue()-1]+ " "+date.getDayOfMonth()+" "+mois[date.getMonth().getValue()-1]+" "+date.getYear();
    }

    public JPanel tabMois(){
        centre.removeAll();
        centreNord.removeAll();
        centreCentre.removeAll();

        Object[] tab = new Object[50];
        String[] jour = new String[]{"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        String[] mois = new String[]{"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
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
                    JButton today = new JButton(String.valueOf(i-jOW));
                    today.setBackground(Color.DARK_GRAY);
                    today.setForeground(Color.WHITE);
                    today.addActionListener(cliqueJour);
                    tab[i] = today;
                }
                else{
                    JButton day = new JButton(String.valueOf(i-jOW));
                    day.setBackground(Color.WHITE);
                    day.addActionListener(cliqueJour);
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
                else{centreCentre.add((JButton)obj);}}
        }

        moisPre = new JButton("←");
        moisPre.setBackground(Color.WHITE);
        moisPre.addActionListener(moisPrecedent);

        titreCentre = new JLabel(mois[first.getMonthValue()-1]+" "+first.getYear(),JLabel.CENTER);
        titreCentre.setFont(new Font("Arial",Font.PLAIN,24));

        moisSui = new JButton("→");
        moisSui.setBackground(Color.WHITE);
        moisSui.addActionListener(moisSuivant);

        centreNord.add(moisPre,BorderLayout.WEST);
        centreNord.add(new JLabel("     "));
        centreNord.add(titreCentre);
        centreNord.add(new JLabel("     "));
        centreNord.add(moisSui,BorderLayout.EAST);

        principal.add(nord,BorderLayout.NORTH);

        centre.add(centreNord,BorderLayout.NORTH);
        centre.add(centreCentre,BorderLayout.CENTER);
        return centre;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {}

    ActionListener moisSuivant = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            int mois = first.getMonthValue()+1;
            int an = first.getYear();
            if(mois>12){
                mois=1;
                an++;
            }

            first = LocalDate.of(an,mois,1);
            tabMois();
            principal.updateUI();
        }
    };

    ActionListener moisPrecedent = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {

            int mois = first.getMonthValue()-1;
            int an = first.getYear();
            if(mois<=0){
                mois=12;
                an--;
            }

            first = LocalDate.of(an,mois,1);
            principal.remove(centre);
            tabMois();
            principal.add(centre,BorderLayout.CENTER);
            principal.updateUI();
        }
    };

    ActionListener cliqueJour = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            principal.removeAll();
            nord.removeAll();
            centre.removeAll();
            centreNord.removeAll();
            centreCentre.removeAll();centre.updateUI();

            LocalDate date2 = LocalDate.of(first.getYear(),first.getMonthValue(), Integer.parseInt(((JButton)e.getSource()).getText()));

            principal.setLayout(new BorderLayout());

            // NORD
            nord = new JPanel();
            nord.setLayout(new BorderLayout());
            dateLabel = new JLabel(dateToString(date2),JLabel.CENTER);
            dateLabel.setFont(new Font("Arial",Font.BOLD,32));
            nord.add(dateLabel,BorderLayout.CENTER);

            retour = new JButton("←");
            retour.setBackground(Color.WHITE);
            retour.addActionListener(cliqueRetour);
            nord.add(retour,BorderLayout.WEST);

            principal.add(nord,BorderLayout.NORTH);

            addEve = new JButton("Ajouter un évenement");
            ActionListener ajtEve = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new Evenement(date2);
                }
            };
            addEve.addActionListener(ajtEve);
            principal.add(addEve,BorderLayout.CENTER);

            principal.updateUI();
        }
    };

    ActionListener cliqueRetour = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            principal.removeAll();
            nord.removeAll();
            centre.removeAll();
            centreNord.removeAll();
            centreCentre.removeAll();

            principal.setLayout(new BorderLayout());

            // NORD
            nord = new JPanel();
            dateLabel = new JLabel(dateToString(date),JLabel.CENTER);
            dateLabel.setFont(new Font("Arial",Font.BOLD,32));
            nord.add(dateLabel);
            principal.add(nord,BorderLayout.NORTH);

            // CENTRE
            centre.setLayout(new BorderLayout());
            centreCentre.setLayout(new GridLayout(7,7,1,1));
            tabMois();
            principal.add(centre,BorderLayout.CENTER);

            principal.updateUI();nord.setLayout(new BorderLayout());
            dateLabel = new JLabel(dateToString(date),JLabel.CENTER);
            dateLabel.setFont(new Font("Arial",Font.BOLD,32));
            nord.add(dateLabel,BorderLayout.CENTER);
        }
    };

}


