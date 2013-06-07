/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Esteet;

import Kayttoliittyma.GraafinenEste;
import java.awt.Color;
import java.awt.Graphics;

/**
 * AEste, väriltään sininen
 * @author iitu
 */
public class AEste extends GraafinenEste {
    
    public AEste(int x, int y, int kulma) {
        super(x,y,kulma);
    }
    
    @Override
    public void draw(Graphics g) {
        int x = this.getX();
        int y = this.getY();

        g.setColor(Color.black);
        g.fillOval(x- 12, y - 12, 24, 24);
        g.setColor(Color.BLUE);
        g.fillOval(x - 10, y - 10, 20, 20);
    }
}
