/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agilitypiirturi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iitu
 */

public class EsteKartta {
    private ArrayList<Este> esteet;
    private final int etaisyys;
    
    public EsteKartta() {
        esteet = new ArrayList<Este>();
        etaisyys = 10;
    }
    
    public void lisaaEste(Este este) {
        esteet.add(este);
    }
    
    public void poistaEste(Este poistettava) {
        int poistettavanIndeksi = -1;
        
        for (int i = 0; i < esteet.size(); i++) {
            if (esteet.get(i).equals(poistettava)) {
                poistettavanIndeksi = i;
            }
        }
        
        if (poistettavanIndeksi >= 0) {
            esteet.remove(poistettavanIndeksi);
        }
    }
    
    public Este valitseEste(int x, int y) {
       
        for (Este este : esteet) {
            int dx = este.getX() - x;
            int dy = este.getY() - y;
            
            if (Math.sqrt(dx*dx + dy*dy) <= etaisyys) {
                return este;
            }
        }
        
        return null;
    }
    
    public ArrayList<Este> getEsteet() {
        return esteet;
    }
    
    
}
