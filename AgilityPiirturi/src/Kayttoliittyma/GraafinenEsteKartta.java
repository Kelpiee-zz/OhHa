/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Agilitypiirturi.Este;
import Agilitypiirturi.EsteKartta;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Perii EsteKartan
 * Huolehtii graafisten esteiden palauttamisesta
 * @author iitu
 */
public class GraafinenEsteKartta extends EsteKartta {
    
    public GraafinenEsteKartta() {
        super();
    }
    
    /**
     * Lisätään graafinen este graafisten esteiden listaan.
     */
    public void lisaaEste(GraafinenEste este) {
        super.lisaaEste(este);
    }
    
    /**
     * Palautetaan lista kaikista graafisista esteistä
     * @return 
     */
    public ArrayList<GraafinenEste> getGraafisetEsteet() {
        ArrayList<GraafinenEste> esteet = new ArrayList<GraafinenEste>();
        for (Este este : super.getEsteet())
            esteet.add((GraafinenEste) este);
        
        return esteet;
    }
    
    /**
     * Valitaan graafinen este muiden joukosta, tietyltä etäisyydeltä
     * @param x
     * @param y
     * @return 
     */
    public GraafinenEste valitseGraafinenEste(int x, int y) {
         return (GraafinenEste) super.valitseEste(x, y);
    }
    
    /**
     * Poistetaan kaikki esteet
     */
    public void poistaKaikkiGraafisetEsteet() {
        super.poistaKaikkiEsteet();
    }
    
}
