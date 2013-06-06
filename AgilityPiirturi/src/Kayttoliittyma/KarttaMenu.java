/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luodaan menu ohjelmalle
 */

/**
 *
 * @author iitu
 */
public class KarttaMenu extends JPanel {

    private JButton aitaNappi;
    private JButton putkiNappi;

    public KarttaMenu(final KarttaPiirturi kartta) {

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        aitaNappi = new JButton("Aita");
        aitaNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kartta.kaytaAitaa();;
            }
        });
        putkiNappi = new JButton("Putki");
        putkiNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kartta.kaytaPutkea();
            }
        });

        this.add(aitaNappi);
        this.add(putkiNappi);

    }
}
