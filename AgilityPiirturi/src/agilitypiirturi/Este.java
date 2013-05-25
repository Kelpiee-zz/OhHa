/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agilitypiirturi;

/**
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
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getKulma() {
        return kulma;
    }
    
    public void siirra(int uusiX, int uusiY) {
        this.x = uusiX;
        this.y = uusiY;
    }
    
    public void kaanna(int uusiKulma) {
        this.kulma = uusiKulma;
    }
}
