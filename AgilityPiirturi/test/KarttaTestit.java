
import agilitypiirturi.Este;
import agilitypiirturi.EsteKartta;
import org.junit.Test;
import static org.junit.Assert.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iitu
 */
public class KarttaTestit {
    private EsteKartta kartta;
    
    public KarttaTestit() {
        kartta = new EsteKartta();
    }
    
    @Test
    public void onkoListaTyhja() {
        assert(kartta.getEsteet().isEmpty());
    }
    
    @Test
    public void toimiikoYhdenPoistaminen() {
        Este eka = new Este(50, 50, 90);
        Este toka = new Este(100, 50, 0);
        
        kartta.lisaaEste(eka);
        kartta.lisaaEste(toka);
        
        kartta.poistaEste(eka);
        
        assertEquals(1, kartta.getEsteet().size());
    }
    
    @Test
    public void toimiikoYhdenPoistaminen2() {
        Este eka = new Este(100, 200, 0);
        Este toka = new Este(50, 10, 90);
        
        kartta.lisaaEste(eka);
        kartta.lisaaEste(toka);
        
        kartta.poistaEste(eka);
        kartta.poistaEste(toka);
        
        assertEquals(0, kartta.getEsteet().size());
    }
    
    @Test
    public void poistetaanSamaKahdesti() {
        Este eka = new Este(100, 200, 0);
        Este toka = new Este(50, 10, 90);
        
        kartta.lisaaEste(eka);
        kartta.lisaaEste(toka);
        
        kartta.poistaEste(eka);
        kartta.poistaEste(eka);
        
        assertEquals(1, kartta.getEsteet().size());
    }
    
    @Test
    public void poistetaanKaikkiEsteet() {
        Este eka = new Este(100, 200, 0);
        Este toka = new Este(50, 10, 90);
        Este kolmas = new Este(50, 50, 90);
        Este neljas = new Este(100, 50, 0);
        
        kartta.lisaaEste(eka);
        kartta.lisaaEste(toka);
        kartta.lisaaEste(kolmas);
        kartta.lisaaEste(neljas);
        
        kartta.poistaKaikkiEsteet();
        
        assert(kartta.getEsteet().isEmpty());
    }
}
