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
      
      if (tipo_msg==MSG.ERROR) {
          this.setForeground(Color.RED);
          message = "Error : " + message;
      }
      else if (tipo_msg==MSG.HELP) {
          this.setForeground(Color.BLUE);
          message = "Tip : " + message;
      }
      else if (tipo_msg==MSG.INFO) {
          this.setForeground(Color.GREEN);
      }
      else {
          this.setForeground(Color.BLACK);
      }
      setText(message);
    }
}
