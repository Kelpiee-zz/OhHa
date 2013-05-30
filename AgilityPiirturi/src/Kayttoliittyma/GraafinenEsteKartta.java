/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import agilitypiirturi.Este;
import agilitypiirturi.EsteKartta;
import java.util.ArrayList;

/**
 *
 * @author iitu
 */
public class GraafinenEsteKartta extends EsteKartta {
    
    public GraafinenEsteKartta() {
        super();
    }
    
    public void lisaaEste(GraafinenEste este) {
        super.lisaaEste(este);
    }
    
    public ArrayList<GraafinenEste> getGraafisetEsteet() {
        ArrayList<GraafinenEste> esteet = new ArrayList<GraafinenEste>();
        for (Este este : super.getEsteet())
            esteet.add((GraafinenEste) este);
        
        return esteet;
    }
    
    public GraafinenEste valitseGraafinenEste(int x, int y) {
        return (GraafinenEste) super.valitseEste(x, y);
    }
}
