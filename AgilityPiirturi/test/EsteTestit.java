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
        testiEste = new Este(x, y, kulma);
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
    public void testaaSiirto1() {
        int uusiX = 10;
        int uusiY = 10;
        testiEste.siirra(uusiX, uusiY);

        assertEquals(uusiX, testiEste.getX());
        assertEquals(uusiY, testiEste.getY());
    }

    @Test
    public void testaaSiirto2() {
        int uusiX = 3;
        int uusiY = 14;
        testiEste.siirra(uusiX, uusiY);

        assertEquals(uusiX, testiEste.getX());
        assertEquals(uusiY, testiEste.getY());
    }

    @Test
    public void testaaKaanto1() {
        int uusiKulma = 45;
        testiEste.kaanna(uusiKulma);

        assertEquals(uusiKulma, testiEste.getKulma());
    }

    @Test
    public void testaaKaanto2() {
        int uusiKulma = 180;
        testiEste.kaanna(uusiKulma);

        assertEquals(uusiKulma, testiEste.getKulma());
    }
}