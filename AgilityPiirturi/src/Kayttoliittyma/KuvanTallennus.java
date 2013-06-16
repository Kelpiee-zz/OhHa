/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Luokka, joka hoitaa radan kuvan tallentamisen
 * @author iitu
 */
public class KuvanTallennus {

    /**
     * Tallentaa kuvan radasta
     * @param rata
     * @throws IOException 
     */
    public void tallennaKuva(BufferedImage rata) throws IOException {
            BufferedImage bi = rata;
            File outputfile = new File("rata.png");
            ImageIO.write(bi, "png", outputfile);
    }
}
