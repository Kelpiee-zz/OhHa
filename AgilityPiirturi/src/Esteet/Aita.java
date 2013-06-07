/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Esteet;

import Kayttoliittyma.GraafinenEste;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Ensimmäinen este, väri punainen
 * Myös oletuksena ensimmäisenä (ks. KarttaPiirturi)
 * Perii GraafisenEsteen
 * @author iitu
 */
public class Aita extends GraafinenEste {
    
    public Aita(int x, int y, int kulma) {
        super(x, y, kulma);
    }
    
    /**
     * Piirtää aita-esteiksi suorakulmioita
     * t.translate:n avulla esteitä voi kääntää. Tämä ominaisuus hyvin kesken
     * Rendering-osasto parantamaan kuvan laatua, mutta siinä myös vielä ongelmia
     * @param g 
     * 
     */
    @Override
    public void draw(Graphics2D g) {
        int x = this.getX();
        int y = this.getY();
        int leveys = 50;
        int korkeus = 10;
        
        AffineTransform t = new AffineTransform();
        t.translate(x, y);
        t.rotate(Math.toRadians(this.getKulma()));
        t.translate(-leveys/2, -korkeus/2);
        
        BufferedImage kuva = new BufferedImage(leveys, 3, BufferedImage.TYPE_INT_ARGB);
        Graphics2D kuvaG = (Graphics2D) kuva.getGraphics();
        
//        kuvaG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        kuvaG.setColor(Color.black);
        kuvaG.fillRect(0, 0, 50, 3);
        
        g.drawImage(kuva, t, null);

    }
}
