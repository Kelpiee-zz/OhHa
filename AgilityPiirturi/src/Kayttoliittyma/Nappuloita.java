package Kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Muodostetaan nappuloiden layout
 *
 * @author iitu
 */
public class Nappuloita {

    public static final Color BLUE_VD = new Color(38, 107, 137);
    public static final Color BLUE_M = new Color(131, 195, 222);
    public static final Color BLUE_L = new Color(156, 202, 222);
    public static final Border etchedBorder = BorderFactory.createEtchedBorder(Nappuloita.BLUE_M, Nappuloita.BLUE_VD);
    public static final Border BUTTON_BORDER = new LineBorder(Nappuloita.BLUE_VD, 1, false);

    /**
     * Nappuloiden layout
     *
     * @param b muutettava nappula
     * @param w leveys
     * @param h korkeus
     * @param text nappulan otsikko
     * @param a actionlistener
     */
    public static void initButton(final JButton b, int w, int h, String text, ActionListener a) {
        b.setText(text);
        b.setPreferredSize(new Dimension(w, h));
        b.setActionCommand(text);
        b.addActionListener(a);
        b.setOpaque(true);
        b.setBackground(Nappuloita.BLUE_M);
        b.setForeground(Nappuloita.BLUE_VD);

        b.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                b.setBackground(Nappuloita.BLUE_L);
            }

            public void mouseReleased(MouseEvent e) {
                b.setBackground(Nappuloita.BLUE_M);
            }
        });
    }
}
