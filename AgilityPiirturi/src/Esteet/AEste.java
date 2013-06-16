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
import java.awt.image.BufferedImage;

/**
 * AEste
 * Perii GraafisenEsteen
 * @author iitu
 */
public class AEste extends GraafinenEste {

    public AEste(int x, int y, int kulma) {
        super(x, y, kulma);
    }

    /**
     * Piirtää A-esteiksi polygoneja
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        int esteenLeveys = 60;
        int esteenKorkeus = 20;
        
        int kuvanKoko = 100;
        
        // Kuva käännetään ja siirretään koordinaateissa niin, että sitä voidaan raahata keskeltä estettä

        AffineTransform p = new AffineTransform();
        p.translate(kuvanKoko/2.0, kuvanKoko/2.0);
        p.rotate(Math.toRadians(this.getKulma()));
        p.translate(-esteenLeveys/2.0, -esteenKorkeus/2.0);
  
        AffineTransform t = new AffineTransform();
        t.translate(this.getX() - kuvanKoko / 2.0, this.getY() - kuvanKoko/ 2.0);
        
        BufferedImage kuva = new BufferedImage(kuvanKoko, kuvanKoko, BufferedImage.TYPE_INT_ARGB);
        Graphics2D kuvaG = (Graphics2D) kuva.getGraphics();

        kuvaG.setTransform(p);
        kuvaG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        luoPolygoni(kuvaG, 30, 10);
        g.drawImage(kuva, t, null);

    }

    /**
     * Luo polygonin
     *
     * @param g
     * @param x
     * @param y
     */
    public void luoPolygoni(Graphics2D g, int x, int y) {
        g.setColor(Color.BLACK);

        int[] xPoints = {x - 30, x, x + 30, x + 30, x, x - 30};
        int[] yPoints = {y - 10, y - 7, y - 10, y + 10, y + 7, y + 10};
        g.fillPolygon(xPoints, yPoints, 6);
    }
}
