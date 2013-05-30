/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;


import javax.swing.JFrame;

/**
 *
 * @author iitu
 */
public class Kayttoliittyma extends JFrame {
    private KarttaPiirturi kartta;

    public Kayttoliittyma() {
        super("AgilityPiirturi");
        kartta = new KarttaPiirturi();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(kartta);
        addMouseMotionListener(kartta);
        
        add(kartta);
        pack();
        setSize(700, 500);
        setVisible(true);
        this.setLocation(210, 0);
    }
}
