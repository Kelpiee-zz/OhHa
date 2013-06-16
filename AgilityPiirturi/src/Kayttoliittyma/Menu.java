/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Luodaan toiminnoista menu ohjelmalle
 * @author iitu
 */
public class Menu extends JPanel {

    private JButton poistaValittu;
    private JButton poistaKaikki;
    private JButton tallennaKuvaksi;
    private GraafinenEsteKartta kartta;
    private KarttaPiirturi piirturi;
    private KuvanTallennus tallentaja;

    /**
     * JButtonit kutsuvat metodeita, joilla halutut toiminnat toteutetaan
     * @param esteKartta
     * @param karttaPiirturi 
     */
    public Menu(GraafinenEsteKartta esteKartta, KarttaPiirturi karttaPiirturi) {
        this.kartta = esteKartta;
        this.piirturi = karttaPiirturi;
        this.tallentaja = new KuvanTallennus();
        
        GridLayout layout = new GridLayout(1, 2);
        this.setLayout(layout);

        poistaValittu = new JButton("Poista valittu este");
        Nappuloita.initButton(poistaValittu, 150, 25, "Poista valittu este", poistaValittuListener());

        poistaKaikki = new JButton("Poista kaikki esteet");
        Nappuloita.initButton(poistaKaikki, 150, 25, "Poista kaikki esteet", poistaKaikkiListener());
        
        tallennaKuvaksi = new JButton("Tallenna kuva");
        Nappuloita.initButton(tallennaKuvaksi, 150, 25, "Tallenna kuva", tallennusListener());

        this.add(tallennaKuvaksi);
        this.add(poistaValittu);
        this.add(poistaKaikki);
    }
    
    /**
     * Luodaan ActionListener valitun esteen poistamiselle
     * @return 
     */
    public ActionListener poistaValittuListener() {
         return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kartta.poistaEste(kartta.getViimeisinValittu());
                piirturi.repaint();
            }
        };
    }
    
    /**
     * Luodaan ActionListener kaikkien esteiden poistamiselle
     * @return 
     */
    public ActionListener poistaKaikkiListener() {
         return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kartta.poistaKaikkiGraafisetEsteet();
                piirturi.repaint();
            }
        };
    }
    /**
     * Luodaan ActionListener radan tallentamiselle kuvaksi
     * Heitetään virheilmoitus, jos tallennus ei onnistu
     * @return 
     */
    public ActionListener tallennusListener() {
         return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BufferedImage rata = new BufferedImage(piirturi.getWidth(), piirturi.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D rataG = (Graphics2D) rata.getGraphics();
                piirturi.paint(rataG);
                try {
                    tallentaja.tallennaKuva(rata);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(piirturi, "Kuvan tallennus ei onnistunut!", "Virhe!", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }
}
