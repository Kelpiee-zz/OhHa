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
    private EsteMenu esteMenu;
    private EsteLuoja esteLuoja;
    private Menu menu;
    private GraafinenEsteKartta esteKartta;

    public Kayttoliittyma() {
        super("AgilityPiirturi");
        esteLuoja = new EsteLuoja();
        esteKartta = new GraafinenEsteKartta();
        kartta = new KarttaPiirturi(esteLuoja, esteKartta);
        esteMenu = new EsteMenu(esteLuoja);
        menu = new Menu(esteKartta, kartta);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(kartta);
        addMouseMotionListener(kartta);
        addKeyListener(kartta);
        kartta.setFocusable(true);
        
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        
        add(esteMenu, BorderLayout.WEST);
        add(menu, BorderLayout.NORTH);
        add(kartta);
        pack();
        setSize(700, 500);
        setVisible(true);
    }
}
