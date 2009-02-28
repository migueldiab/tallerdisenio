/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm.resources.widget;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Miguel A. Diab
 */
public class StatusBar extends JLabel {
    public static enum MSG {
      ERROR,
      INFO,
      HELP
    }
    public StatusBar() {
        super();
        super.setPreferredSize(new Dimension(100, 16));
        setMessage("Bienvenido al sistema...", StatusBar.MSG.HELP);
    }

    public void setMessage(String message, StatusBar.MSG tipo_msg) {
      this.setHorizontalAlignment(CENTER);
      
      switch(tipo_msg) {
        case ERROR:
          this.setForeground(Color.RED);
          message = "Error : " + message;
          break;
        case HELP:
          this.setForeground(Color.BLUE);
          message = "Tip : " + message;
          break;
        case INFO:
          this.setForeground(Color.GREEN);
          break;
        default:
          this.setForeground(Color.BLACK);
          break;
      }
      setText(message);
    }
}
