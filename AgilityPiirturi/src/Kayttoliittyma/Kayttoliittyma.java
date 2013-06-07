/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Esteet.EsteLuoja;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Luo graafisen käyttöliittymän
 *
 * @author iitu
 */
public class Kayttoliittyma extends JFrame {

    private KarttaPiirturi kartta;
    private KarttaMenu menu;
    private EsteLuoja esteLuoja;

    public Kayttoliittyma() {
        super("AgilityPiirturi");
        esteLuoja = new EsteLuoja();
        kartta = new KarttaPiirturi(esteLuoja);
        menu = new KarttaMenu(esteLuoja);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(kartta);
        addMouseMotionListener(kartta);

        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        
        add(menu, BorderLayout.WEST);
        add(kartta);
        pack();
        setSize(700, 500);
        setVisible(true);
        this.setLocation(210, 0);
    }
}
