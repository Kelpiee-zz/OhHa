/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Esteet;

import Kayttoliittyma.GraafinenEste;

/**
 * EsteLuoja pitää kirjaa valitun esteen tyypistä Oletuksena aita
 *
 * @author iitu
 */
public class EsteLuoja {

    private enum EsteLaji {

        Aita, Putki, AEste
    }
    private EsteLaji valittuTyyppi;

    public EsteLuoja() {
        valittuTyyppi = EsteLaji.Aita;
    }

    /**
     * Luodaan uusi este tyypin mukaan, muuten palautetaan GraafinenEste
     *
     * @param x
     * @param y
     * @param kulma
     * @return
     */
    public GraafinenEste luoEste(int x, int y, int kulma) {
        if (valittuTyyppi == EsteLaji.Aita) {
            return new Aita(x, y, kulma);
        } else if (valittuTyyppi == EsteLaji.Putki) {
            return new Putki(x, y, kulma);
        } else if (valittuTyyppi == EsteLaji.AEste) {
            return new AEste(x, y, kulma);
        }

        return new GraafinenEste(x, y, kulma);
    }

    /**
     * Tyypiksi valitaan aita
     */
    public void luoAitoja() {
        valittuTyyppi = EsteLaji.Aita;
    }

    /**
     * Tyypiksi valitaan putki
     */
    public void luoPutkia() {
        valittuTyyppi = EsteLaji.Putki;
    }
    
    /**
     * Tyypiksi valitaan AEste
     */
    public void luoAEsteita() {
        valittuTyyppi = EsteLaji.AEste;
    }
}
