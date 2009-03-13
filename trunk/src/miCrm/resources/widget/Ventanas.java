/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm.resources.widget;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class Ventanas {
  public static void centrarVentana(JFrame ventana) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    int x = (screenSize.width - ventana.getWidth()) / 2;
    int y = (screenSize.height - ventana.getHeight()) / 2;
    ventana.setLocation(x, y);
  }
}
