/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agilitypiirturi;

import java.util.ArrayList;

/**
 * Pitää kirjaa kaikista esteistä
 * @author iitu
 */

public class EsteKartta {
    private ArrayList<Este> esteet;
    private final int etaisyys;
    private Este viimeisinValittu;
    
    public EsteKartta() {
        esteet = new ArrayList<Este>();
        etaisyys = 10;
        viimeisinValittu = null;
    }
    /**
     * Lisätään este esteet-listaan
     * @param este 
     */
    public void lisaaEste(Este este) {
        esteet.add(este);
    }
    
    /**
     * Poistetaan este listalta
     * @param poistettava 
     */
    public void poistaEste(Este poistettava) {
        int poistettavanIndeksi = -1;
        
        for (int i = 0; i < esteet.size(); i++) {
            if (esteet.get(i).equals(poistettava)) {
                poistettavanIndeksi = i;
            }
        }
        
        if (poistettavanIndeksi >= 0) {
            viimeisinValittu = null;
            esteet.remove(poistettavanIndeksi);
        }
    }
    
    /**
     * Valitaan tietty este s.e. este valitaan, 
     * jos annetusta pisteestä sijaitsee este vähintään 10 pikselin (etaisyys) päässä.
     * Muuten ei palauteta mitään.
     * @param x
     * @param y
     * @return 
     */
    public Este valitseEste(int x, int y) {
       
        for (Este este : esteet) {
            int dx = este.getX() - x;
            int dy = este.getY() - y;
            
            if (Math.sqrt(dx*dx + dy*dy) <= etaisyys) {
                viimeisinValittu = este;
                return este;
            }
        }
        
        return null;
    }
    
    /**
     * Palautetaan koko lista esteistä.
     * @return 
     */
    public ArrayList<Este> getEsteet() {
        return esteet;
    }
    
    public void poistaKaikkiEsteet() {
        viimeisinValittu = null;
        esteet.removeAll(esteet);
    }
    
    public Este getViimeisinValittu() {
        return viimeisinValittu;
    }
    
    public void nollaaViimeisinValittu() {
        viimeisinValittu = null;
    }
    
}
