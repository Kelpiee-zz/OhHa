/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Esteet;

import Kayttoliittyma.GraafinenEste;
import java.awt.Color;
import java.awt.Graphics;

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
    
    @Override
    public void draw(Graphics g) {
        int x = this.getX();
        int y = this.getY();

        g.setColor(Color.black);
        g.fillOval(x- 12, y - 12, 24, 24);
        g.setColor(Color.RED);
        g.fillOval(x - 10, y - 10, 20, 20);
    }
}
