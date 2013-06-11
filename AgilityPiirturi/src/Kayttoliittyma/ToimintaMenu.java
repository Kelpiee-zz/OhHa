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
 *
 * @author iitu
 */
public class ToimintaMenu extends JPanel {

    private JButton poistaValittu;
    private JButton poistaKaikki;
    private GraafinenEsteKartta kartta;
    private KarttaPiirturi piirturi;

    public ToimintaMenu(GraafinenEsteKartta esteKartta, KarttaPiirturi karttaPiirturi) {
        this.kartta = esteKartta;
        this.piirturi = karttaPiirturi;
        
        GridLayout layout = new GridLayout(1, 2);
        this.setLayout(layout);

        poistaValittu = new JButton("Poista valittu este");
        Nappuloita.initButton(poistaValittu, 150, 25, "Poista valittu este", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kartta.poistaEste(kartta.getViimeisinValittu());
                piirturi.repaint();
            }
        });

        poistaKaikki = new JButton("Poista kaikki esteet");
        Nappuloita.initButton(poistaKaikki, 150, 25, "Poista kaikki esteet", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kartta.poistaKaikkiGraafisetEsteet();
                piirturi.repaint();
            }
        });
//
//        aEsteNappi = new JButton("Putki");
//        Nappuloita.initButton(aEsteNappi, 150, 25, "A-este", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                esteLuoja.luoAEsteita();
//            }
//        });

        this.add(poistaValittu);
        this.add(poistaKaikki);
    }
}
