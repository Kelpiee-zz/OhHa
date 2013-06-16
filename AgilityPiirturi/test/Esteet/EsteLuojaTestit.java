package Esteet;


import Esteet.AEste;
import Esteet.Aita;
import Esteet.EsteLuoja;
import Esteet.Putki;
import org.junit.Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iitu
 */
public class EsteLuojaTestit {
    private EsteLuoja esteLuoja;
    private int x;
    private int y;
    private int kulma;
    
    public EsteLuojaTestit() {
        esteLuoja = new EsteLuoja();
        x = 100;
        y = 100;
        kulma = 180;
    }
    
    @Test
    public void luodaanAitoja() {
        esteLuoja.luoAitoja();
        
        assert(esteLuoja.luoEste(x, y, kulma).getClass().equals(Aita.class));
    }
    
    @Test
    public void luodaanPutkia() {
        esteLuoja.luoPutkia();
        
        assert(esteLuoja.luoEste(x, y, kulma).getClass().equals(Putki.class));
    }
    
    @Test
    public void luodaanAEsteita() {
        esteLuoja.luoAEsteita();
        
        assert(esteLuoja.luoEste(x, y, kulma).getClass().equals(AEste.class));
    }
}
