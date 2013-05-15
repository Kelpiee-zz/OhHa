/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import agilitypiirturi.Este;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iitu
 */
public class EsteTestit {
    private Este testiEste;
    
    public EsteTestit() {
        int x = 5;
        int y = 6;
        int kulma = 0;
        testiEste = new Este(x,y,kulma);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testaaPaikka() {
        assertEquals(5, testiEste.getX());
        assertEquals(6, testiEste.getY());
        assertEquals(0, testiEste.getKulma());
    }
    
    @Test
    public void testaaSiirto() {
        int uusiX = 10;
        int uusiY = 10;
        testiEste.siirra(uusiX, uusiY);
        
        assertEquals(uusiX, testiEste.getX());
        assertEquals(uusiY, testiEste.getY());
    }
}