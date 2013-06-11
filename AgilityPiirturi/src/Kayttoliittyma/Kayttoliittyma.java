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
    private ToimintaMenu valikko;
    private GraafinenEsteKartta esteKartta;

    public Kayttoliittyma() {
        super("AgilityPiirturi");
        esteLuoja = new EsteLuoja();
        esteKartta = new GraafinenEsteKartta();
        kartta = new KarttaPiirturi(esteLuoja, esteKartta);
        menu = new KarttaMenu(esteLuoja);
        valikko = new ToimintaMenu(esteKartta, kartta);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(kartta);
        addMouseMotionListener(kartta);

        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        
        add(menu, BorderLayout.WEST);
        add(valikko, BorderLayout.NORTH);
        add(kartta);
        pack();
        setSize(700, 500);
        setVisible(true);
        this.setLocation(210, 0);
    }
}
