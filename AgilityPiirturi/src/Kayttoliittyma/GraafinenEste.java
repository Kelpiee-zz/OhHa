/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Agilitypiirturi.Este;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Graafinen versio esteestä
 * @author iitu
 */
public class GraafinenEste extends Este {


    public GraafinenEste(int x, int y, int kulma) {
        super(x, y, kulma);
    }

    /**
     * Piirretään esteet (sinisiä ovaaleja, ellei ole estetyyppiä vaihdettu)
     * @param g piirtoon käytettävä Graphics olio
     */
    public void draw(Graphics2D g) {
        int x = this.getX();
        int y = this.getY();

        g.setColor(Color.BLACK);
        g.fillOval(x- 12, y - 12, 24, 24);
        g.setColor(Color.BLUE);
        g.fillOval(x - 10, y - 10, 20, 20);
    }
}
