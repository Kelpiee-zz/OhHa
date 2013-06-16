/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Esteet.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class KarttaPiirturi extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

    private GraafinenEsteKartta kartta;
    private EsteLuoja esteLuoja;
    private boolean ctrlPainettu;
    private boolean shiftPainettu;
    
    public KarttaPiirturi(EsteLuoja esteLuoja, GraafinenEsteKartta kartta) {
        this.kartta = kartta;
        this.esteLuoja = esteLuoja;

        ctrlPainettu = false;
        shiftPainettu = false;
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    /**
     * Piirtää kartan
     *
     * @param g piirtoon käytettävä Graphics olio
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        BufferedImage pohjaLayer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        BufferedImage esteLayer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D pohjaLayerG = (Graphics2D) pohjaLayer.getGraphics();
        Graphics2D esteLayerG = (Graphics2D) esteLayer.getGraphics();
        esteLayerG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        pohjaLayerG.setColor(Color.WHITE);
        pohjaLayerG.fillRect(0, 0, this.getWidth(), this.getHeight());

        int viivaTiheys = 25;

        pohjaLayerG.setColor(Color.GRAY.brighter());
        for (int y = 0; y < this.getWidth(); y += viivaTiheys) {
            pohjaLayerG.drawLine(0, y, this.getWidth(), y);
            pohjaLayerG.drawLine(y, 0, y, this.getHeight());
        }
        for (GraafinenEste este : kartta.getGraafisetEsteet()) {
            este.draw(esteLayerG);
        }

        g.drawImage(pohjaLayer, 0, 0, this);
        g.drawImage(esteLayer, 0, 0, this);

    }

    /**
     * Kun estettä klikataan, luodaan klikattuun pisteeseen uusi este
     * Jos este on jo valittuna, sitä klikkailemalla saadaan se kääntymään:
     * - normaalisti este kääntyy 5 astetta myötäpäivään
     * - Ctrl pohjassa este kääntyy vastapäivään
     * - Shift pohjassa este kääntyy 30 astetta 5:n sijaan
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (kartta.valitseGraafinenEste(me.getX(), me.getY()) == null) {
            GraafinenEste uusiEste = esteLuoja.luoEste(me.getX(), me.getY(), 0);

            kartta.lisaaEste(uusiEste);
        } else {
            int kaantoKulma = shiftPainettu ? 30 : 5;
            kaantoKulma = ctrlPainettu ? -kaantoKulma : kaantoKulma;
            
            GraafinenEste este = kartta.valitseGraafinenEste(me.getX(), me.getY());
            este.kaanna(este.getKulma()+kaantoKulma);
        }
        this.repaint();
    }

    /**
     * Kun estettä painetaan, este tulee valituksi
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
        kartta.valitseGraafinenEste(me.getX(), me.getY());
    }

    /**
     * Kun esteen painaminen lopetetaan, valinta poistuu
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        kartta.nollaaViimeisinValittu();
        this.repaint();
    }

    /**
     * Kun estettä raahataan, esteen koordinaatit muuttuvat ja kartta uudelleen
     * piirretään
     *
     * @param me
     */
    @Override
    public void mouseDragged(MouseEvent me) {        
        if (kartta.getViimeisinValittu() != null) {
            kartta.getViimeisinValittu().siirra(me.getX(), me.getY());
            
        }

        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (!this.isFocusOwner()) {
            this.requestFocusInWindow();
        }
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

    @Override
    public void keyTyped(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Kuunnellaan näppäimistön painallukset
     * @param ke 
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        ctrlPainettu = ke.isControlDown();
        shiftPainettu = ke.isShiftDown();
    }

    /**
     * Kuunnellaan näppäimistön vapauttaminen
     * @param ke 
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        ctrlPainettu = ke.isControlDown();
        shiftPainettu = ke.isShiftDown();
    }
}
