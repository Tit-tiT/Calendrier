package Vue;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bouton extends JButton implements MouseListener, ActionListener{

    Color back;
    Color hover=null;
    Color press=null;

    public Bouton(String titre){
        super(titre);
        setContentAreaFilled(false);
        setBackground2(Color.WHITE);
        setBorder(new LineBorder(Color.BLACK));
    }

    public Bouton(){ this(null); }

    public Color getBack() {
        return back;
    }

    public Color getHover() {
        return hover;
    }

    public Color getPress() {
        return press;
    }

    public void setBackground2(Color bg) {
        this.setBackground(bg);
        this.back=bg;
    }

    public void setHoverColor(Color bg){
        this.hover=bg;
        //this.addMouseListener(actionSetHoverColor);
    }

    public void setPressColor(Color bg){
        this.press=bg;
        //this.addActionListener(actionStPressColor);
        //this.paintComponent(new super.paintCompoment()
    }

    MouseListener actionSetHoverColor = new MouseListener(){

        @Override
        public void mouseClicked(MouseEvent mouseEvent) { }

        @Override
        public void mousePressed(MouseEvent mouseEvent) { }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) { }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) { ((Bouton)mouseEvent.getSource()).setBackground(((Bouton)mouseEvent.getSource()).getHover()); }

        @Override
        public void mouseExited(MouseEvent mouseEvent) { ((Bouton)mouseEvent.getSource()).setBackground(((Bouton)mouseEvent.getSource()).getBack()); }
    };

    ActionListener actionStPressColor = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent a) {
            //((Bouton)a.getSource()).setBackground(((Bouton)a.getSource()).getPress());
            while(((Bouton)a.getSource()).getModel().isPressed()){
                ((Bouton)a.getSource()).setBackground(((Bouton)a.getSource()).getPress());
            }
        }
    };

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(press);
        } else if (getModel().isRollover()) {
            g.setColor(hover);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) { }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) { }

    @Override
    public void mousePressed(MouseEvent mouseEvent) { }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) { }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) { }

    @Override
    public void mouseExited(MouseEvent mouseEvent) { }
}
