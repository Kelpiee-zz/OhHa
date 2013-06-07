/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Esteet.EsteLuoja;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * Luodaan menu ohjelmalle
 * @author iitu
 */
public class KarttaMenu extends JPanel {

    private JButton aitaNappi;
    private JButton putkiNappi;
    private JButton aEsteNappi;

    /**
     * JButtonit kutsuvat EsteLuojan metodeita, joilla tallennetaan halutun esteen tyyppi
     * @param esteLuoja 
     */
    public KarttaMenu(final EsteLuoja esteLuoja) {

        GridLayout layout = new GridLayout(3, 1);
        this.setLayout(layout);

        aitaNappi = new JButton("Aita");
        Nappuloita.initButton(aitaNappi, 150, 25, "Aita", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                esteLuoja.luoAitoja();
            }
        });

        putkiNappi = new JButton("Putki");
        Nappuloita.initButton(putkiNappi, 150, 25, "Putki", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                esteLuoja.luoPutkia();
            }
        });
        
        aEsteNappi = new JButton("Putki");
        Nappuloita.initButton(aEsteNappi, 150, 25, "A-este", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                esteLuoja.luoAEsteita();
            }
        });

        this.add(aitaNappi);
        this.add(putkiNappi);
        this.add(aEsteNappi);

    }
}
