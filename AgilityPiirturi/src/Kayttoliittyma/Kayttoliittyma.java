/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * Luo graafisen käyttöliittymän
 *
 * @author iitu
 */
public class Kayttoliittyma extends JFrame {

    private KarttaPiirturi kartta;
    private KarttaMenu menu;

    public Kayttoliittyma() {
        super("AgilityPiirturi");
        kartta = new KarttaPiirturi();
        menu = new KarttaMenu(kartta);

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
