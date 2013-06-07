/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Esteet;

import Kayttoliittyma.GraafinenEste;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.image.BufferedImage;

/**
 * Toinen varsinainen este, piiretään curvena
 *
 * @author iitu
 */
public class Putki extends GraafinenEste {

    public Putki(int x, int y, int kulma) {
        super(x, y, kulma);
    }

    /**
     * Piirretään este ja myös käännetään sitä
     * Kääntäminen testailua, varsinainen toiminto tulee muualle, jos saan toimimaan
     * Rendering-osasto parantamaan kuvanlaatua, mutta ei toimi vielä
     * @param g 
     */
    @Override
    public void draw(Graphics2D g) {
        int korkeus = 40;
        int leveys = 65;

        int x1 = 6;
        int y1 = korkeus - 5;
        int x2 = x1 + 50;
        int y2 = y1;

        int cx1 = x1;
        int cy1 = y2 - korkeus;
        int cx2 = x2;
        int cy2 = y2 - korkeus;



        BasicStroke reunus =
                new BasicStroke(10.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                10.0f, null, 0.0f);

        AffineTransform p = new AffineTransform();
//        p.translate(this.getX(), this.getY());
//        p.translate(-leveys / 2, -korkeus / 2);

        p.translate(leveys / 2, korkeus / 2);
        p.rotate(Math.toRadians(this.getKulma()));
        p.translate(-leveys / 2, -(korkeus / 2 - 20));

        AffineTransform t = new AffineTransform();
        t.translate(this.getX() - leveys / 2, this.getY() - korkeus / 2);

//        t.rotate(Math.toRadians(this.getKulma()));

        BufferedImage kuva = new BufferedImage(leveys + 20, leveys + 20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D kuvaG = (Graphics2D) kuva.getGraphics();

//        kuvaG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        kuvaG.setColor(Color.BLACK);
        kuvaG.setStroke(reunus);
        kuvaG.setTransform(p);


        CubicCurve2D q = new CubicCurve2D.Float();
        q.setCurve(x1, y1, cx1, cy1, cx2, cy2, x2, y2);

        kuvaG.draw(q);

        g.drawImage(kuva, t, null);
    }
}
