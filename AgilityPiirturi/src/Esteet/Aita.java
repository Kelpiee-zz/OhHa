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
 * Aita, joka oletuksena ensimmäinen este
 * Perii GraafisenEsteen
 * @author iitu
 */
public class Aita extends GraafinenEste {
    
    public Aita(int x, int y, int kulma) {
        super(x, y, kulma);
    }
    
    /**
     * Piirtää aita-esteiksi suorakulmioita
     * t.translate:n avulla esteitä voi kääntää
     * @param g 
     * 
     */
    @Override
    public void draw(Graphics2D g) {
        int aidanLeveys = 35;
        int aidanKorkeus = 3;
        
        int kuvanKoko = 100;
        
        // Kuva käännetään ja siirretään koordinaateissa niin, että sitä voidaan raahata keskeltä estettä
        AffineTransform p = new AffineTransform();
        p.translate(kuvanKoko/2.0, kuvanKoko/2.0);
        p.rotate(Math.toRadians(this.getKulma()));
        p.translate(-aidanLeveys/2.0, -aidanKorkeus/2.0);
  
        AffineTransform t = new AffineTransform();
        t.translate(this.getX() - kuvanKoko / 2.0, this.getY() - kuvanKoko/ 2.0);

        BufferedImage kuva = new BufferedImage(kuvanKoko, kuvanKoko, BufferedImage.TYPE_INT_ARGB);
        Graphics2D kuvaG = (Graphics2D) kuva.getGraphics();
        
        kuvaG.setTransform(p);
        kuvaG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        kuvaG.setColor(Color.BLACK);
        kuvaG.fillRect(0, 0, aidanLeveys, aidanKorkeus);

        g.drawImage(kuva, t, null);

    }
}
