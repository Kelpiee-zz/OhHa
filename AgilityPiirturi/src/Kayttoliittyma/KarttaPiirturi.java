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
 * Piirtää kartan ja huolehtii hiiren antamista komennoista
 *
 * @author iitu
 */
public class KarttaPiirturi extends JPanel implements MouseListener, MouseMotionListener {

    private GraafinenEsteKartta kartta;
    private GraafinenEste valittu;

    public KarttaPiirturi() {
        kartta = new GraafinenEsteKartta();
        valittu = null;

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    /**
     * Piirtää kartan
     *
     * @param g piirtoon käytettävä Graphics olio
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage esteLayer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (GraafinenEste este : kartta.getGraafisetEsteet()) {
            este.draw(g);
        }

        g.drawImage(esteLayer, 0, 0, this);
    }

    /**
     * Kun estettä klikataan, luodaan klikattuun pisteeseen uusi este
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        GraafinenEste uusiEste = new GraafinenEste(me.getX(), me.getY(), 0);
        kartta.lisaaEste(uusiEste);

        this.repaint();
    }

    /**
     * Kun estettä painetaan, este tulee valituksi
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
        valittu = kartta.valitseGraafinenEste(me.getX(), me.getY());
    }

    /**
     * Kun esteen painaminen lopetetaan, valinta poistuu
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        valittu = null;
    }

    /**
     * Kun estettä raahataan, esteen koordinaatit muuttuvat ja kartta uudelleen
     * piirretään
     *
     * @param me
     */
    @Override
    public void mouseDragged(MouseEvent me) {
        if (valittu != null) {
            valittu.siirra(me.getX(), me.getY());
        }

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
