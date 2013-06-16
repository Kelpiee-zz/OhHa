/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agilitypiirturi;

/**
 * Yhden esteen ominaisuudet
 *
 * @author iitu
 */
public class Este {

    private int x;
    private int y;
    private int kulma;

    public Este(int x, int y, int kulma) {
        this.x = x;
        this.y = y;
        this.kulma = kulma;
    }

    /**
     * Palauttaa esteen x-koordinaatin
     */
    public int getX() {
        return x;
    }

    /**
     * Palauttaa esteen y-koordinaatin
     */
    public int getY() {
        return y;
    }

    /**
     * Palauttaa kulman, jossa este sijaitsee kartalla.
     */
    public int getKulma() {
        return kulma;
    }

    /**
     * Annetaan esteelle uusi sijainti. Uudet koordinaatit:
     *
     * @param uusiX
     * @param uusiY
     */
    public void siirra(int uusiX, int uusiY) {
        this.x = uusiX;
        this.y = uusiY;
    }

    /**
     * Annetaan esteelle uusi kulma.
     *
     * @param uusiKulma
     */
    public void kaanna(int uusiKulma) {
        this.kulma = uusiKulma;
    }
}
