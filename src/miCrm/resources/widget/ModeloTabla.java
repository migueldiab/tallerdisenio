/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm.resources.widget;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ModeloTabla extends DefaultTableModel {

  @Override
  public boolean isCellEditable(int row, int column) {
      return false;
  }

}
