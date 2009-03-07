/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Prioridads.java
 *
 * Created on 21/02/2009, 04:00:29 PM
 */

package miCrm.vista;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import lib.model.miCRM.*;
import miCrm.Fachada;

/**
 *
 * @author Administrator
 */
public class Prioridades extends javax.swing.JFrame {

    /** Creates new form Prioridads */
    public Prioridades() {
        initComponents();
        cargarListas();
    }

  private void cargarDatos(Prioridad u) {
    tId.setText(u.getId().toString());
    tId.setEnabled(false);
    tNombre.setText(u.getNombre());
  }
  private void limpiarCampos() {
    tId.setText("");
    tId.setEnabled(true);
    tNombre.setText("");
    cargarListas();
  }
  private boolean validarCampos() {
    return true;
  }
  private void cargarListas() {
    lista.clear();
    for (Prioridad u : Fachada.listarPrioridades()) {
      lista.addElement(u);
    }
  }
  private boolean guardarDatos(Prioridad u) {
    try {
      if (u==null) {
        u = new Prioridad();
        u.setId(Integer.parseInt(tId.getText()));
      }
      u.setNombre(tNombre.getText());
      if (Fachada.guardarPrioridad(u)) {
        return true;
      }
      else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panelABM = new javax.swing.JSplitPane();
    panelEditar = new javax.swing.JPanel();
    lId = new javax.swing.JLabel();
    tId = new javax.swing.JTextField();
    tNombre = new javax.swing.JTextField();
    lNombre = new javax.swing.JLabel();
    bGuardar = new javax.swing.JButton();
    bEliminar = new javax.swing.JButton();
    bCerrar = new javax.swing.JButton();
    bNuevo = new javax.swing.JButton();
    panelLista = new javax.swing.JScrollPane();
    lista = new DefaultListModel();
    jListado = new javax.swing.JList(lista);

    setTitle("Usuarios");

    panelABM.setDividerLocation(150);

    panelEditar.setMinimumSize(new java.awt.Dimension(160, 160));

    lId.setText("Id");

    lNombre.setText("Nombre");

    bGuardar.setText("Guardar");
    bGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bGuardarActionPerformed(evt);
      }
    });

    bEliminar.setText("Eliminar");
    bEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bEliminarActionPerformed(evt);
      }
    });

    bCerrar.setText("Cerrar");
    bCerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCerrarActionPerformed(evt);
      }
    });

    bNuevo.setText("Nuevo");
    bNuevo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bNuevoActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panelEditarLayout = new javax.swing.GroupLayout(panelEditar);
    panelEditar.setLayout(panelEditarLayout);
    panelEditarLayout.setHorizontalGroup(
      panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelEditarLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(panelEditarLayout.createSequentialGroup()
              .addComponent(lId)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelEditarLayout.createSequentialGroup()
              .addComponent(lNombre)
              .addGap(30, 30, 30)
              .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(panelEditarLayout.createSequentialGroup()
            .addComponent(bNuevo)
            .addGap(18, 18, 18)
            .addComponent(bGuardar)
            .addGap(18, 18, 18)
            .addComponent(bEliminar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
            .addComponent(bCerrar)))
        .addContainerGap())
    );
    panelEditarLayout.setVerticalGroup(
      panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelEditarLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lId)
          .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lNombre)
          .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bCerrar)
          .addComponent(bNuevo)
          .addComponent(bGuardar)
          .addComponent(bEliminar))
        .addContainerGap())
    );

    panelABM.setRightComponent(panelEditar);

    panelLista.setMinimumSize(new java.awt.Dimension(80, 80));
    panelLista.setPreferredSize(new java.awt.Dimension(80, 160));

    jListado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jListado.setMinimumSize(new java.awt.Dimension(80, 160));
    jListado.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        jListadoValueChanged(evt);
      }
    });
    panelLista.setViewportView(jListado);

    panelABM.setLeftComponent(panelLista);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelABM, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelABM, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
      try {
        if (!validarCampos()) {
          return;
        }
        Prioridad unPrioridad = Fachada.buscarPrioridadPorId(Integer.parseInt(tId.getText()));
        if(tId.isEnabled()) {
          if (unPrioridad!=null) {
            if (JOptionPane.showConfirmDialog(
              null,"El Prioridad con ID "+tId.getText()+" ya existe ("+unPrioridad.toString()+"). Deseea reemplazarlo?",
              "Confirma reemplazar?",
              JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION) {
                return;
            }
          }
        }
        if (!guardarDatos(unPrioridad)) {
          throw new Exception("falló guardarDatos(unPrioridad)");
        }
        else {
          JOptionPane.showMessageDialog(
              null,"Prioridad guardado",
              "Prioridad guardado",
              JOptionPane.INFORMATION_MESSAGE);
        }
        limpiarCampos();
      } catch (Exception e) {
        System.out.println(e.toString());
        JOptionPane.showMessageDialog(
              null,"Error al guardar el Prioridad. Verifique los datos.\r\n"+
              "Si el error persiste, por favor consulte con el administrador.\r\n"
              +e.toString(),
              "Error al guardar",
              JOptionPane.ERROR_MESSAGE);
      }

}//GEN-LAST:event_bGuardarActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
      limpiarCampos();
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
      try {
        Prioridad unPrioridad = Fachada.buscarPrioridadPorId(Integer.parseInt(tId.getText()));
        if (unPrioridad==null) {
          throw new Exception("No existe Prioridad con ID = "+tId.getText());
        }
        if (!Fachada.borrarPrioridad(unPrioridad)) {
          throw new Exception("Falló borrarPrioridad(unPrioridad)");
        }
        else {
          JOptionPane.showMessageDialog(
              null,"El Prioridad "+unPrioridad.toString()+" fue eliminado",
              "Prioridad Eliminado",
              JOptionPane.INFORMATION_MESSAGE);
          limpiarCampos();
        }
      } catch (Exception e) {
        System.out.println(e.toString());
        JOptionPane.showMessageDialog(
              null,"Error al eliminar el Prioridad. Verifique los datos.\r\n"+
              "Si el error persiste, por favor consulte con el administrador.\r\n"
              +e.toString(),
              "Error al eliminar",
              JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void jListadoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListadoValueChanged
      if (jListado.getSelectedIndex()!=-1) {
        cargarDatos((Prioridad) jListado.getSelectedValue());
      }
}//GEN-LAST:event_jListadoValueChanged

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
      this.dispose();
    }//GEN-LAST:event_bCerrarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prioridades().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bCerrar;
  private javax.swing.JButton bEliminar;
  private javax.swing.JButton bGuardar;
  private javax.swing.JButton bNuevo;
  private javax.swing.JList jListado;
  private javax.swing.JLabel lId;
  private javax.swing.JLabel lNombre;
  private javax.swing.JSplitPane panelABM;
  private javax.swing.JPanel panelEditar;
  private javax.swing.JScrollPane panelLista;
  private javax.swing.JTextField tId;
  private javax.swing.JTextField tNombre;
  // End of variables declaration//GEN-END:variables
  private javax.swing.DefaultListModel lista;


}
