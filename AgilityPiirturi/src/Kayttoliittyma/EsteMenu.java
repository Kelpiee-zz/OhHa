package Kayttoliittyma;

import Esteet.EsteLuoja;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luodaan esteistä menu ohjelmalle
 *
 * @author iitu
 */
public class EsteMenu extends JPanel {

    private JButton aitaNappi;
    private JButton putkiNappi;
    private JButton aEsteNappi;

    /**
     * JButtonit kutsuvat metodeita, joilla tallennetaan halutun
     * esteen tyyppi EsteLuojan avulla
     *
     * @param esteLuoja
     */
    public EsteMenu(final EsteLuoja esteLuoja) {

        GridLayout layout = new GridLayout(3, 1);
        this.setLayout(layout);

        aitaNappi = new JButton("Aita");
        Nappuloita.initButton(aitaNappi, 150, 25, "Aita", luoAitojaListener(esteLuoja));

        putkiNappi = new JButton("Putki");
        Nappuloita.initButton(putkiNappi, 150, 25, "Putki", luoPutkiaListener(esteLuoja));

        aEsteNappi = new JButton("A-este");
        Nappuloita.initButton(aEsteNappi, 150, 25, "A-este", luoAEsteListener(esteLuoja));

        this.add(aitaNappi);
        this.add(putkiNappi);
        this.add(aEsteNappi);

    }
    /**
     * Luodaan ActionListener aidoille
     * @param esteLuoja
     * @return 
     */
    public ActionListener luoAitojaListener(final EsteLuoja esteLuoja) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                esteLuoja.luoAitoja();
            }
        };
    }
    /**
     * Luodaan ActionListener putkille
     * @param esteLuoja
     * @return 
     */
    public ActionListener luoPutkiaListener(final EsteLuoja esteLuoja) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                esteLuoja.luoPutkia();
            }
        };
    }
    /**
     * Luodaan ActionListener A-esteille
     * @param esteLuoja
     * @return 
     */
    public ActionListener luoAEsteListener(final EsteLuoja esteLuoja) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                esteLuoja.luoAEsteita();
            }
        };
    }
}
