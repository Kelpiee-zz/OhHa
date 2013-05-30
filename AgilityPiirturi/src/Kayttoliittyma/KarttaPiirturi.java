/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author iitu
 */
public class KarttaPiirturi extends JPanel implements MouseListener, MouseMotionListener {

    private GraafinenEsteKartta kartta;
    private GraafinenEste valittu;

    public KarttaPiirturi() {
        kartta = new GraafinenEsteKartta();
        kartta.lisaaEste(new GraafinenEste(50, 50, 90));
        kartta.lisaaEste(new GraafinenEste(100, 300, 90));
        
        valittu = null;
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage esteLayer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (GraafinenEste este : kartta.getGraafisetEsteet()) {
            este.draw(g);
        }

        g.drawImage(esteLayer, 0, 0, this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        valittu = kartta.valitseGraafinenEste(me.getX(), me.getY());
        
        if (valittu != null) {
            System.out.println("moi");
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        valittu = kartta.valitseGraafinenEste(me.getX(), me.getY());
        
        if (valittu != null) {
            System.out.println("moi");
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        valittu = null;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (valittu != null) {
            valittu.siirra(me.getX(), me.getY());
        }
        
        this.repaint();
    }

    public void graphChanged() {
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
