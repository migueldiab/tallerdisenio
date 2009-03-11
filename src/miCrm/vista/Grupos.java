/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Grupos.java
 *
 * Created on 21/02/2009, 04:00:29 PM
 */

package miCrm.vista;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lib.model.miCRM.*;
import miCrm.Fachada;

/**
 *
 * @author Administrator
 */
public class Grupos extends javax.swing.JDialog {

    /** Creates new form Grupos */
    public Grupos(JFrame parent) {
      super(parent);
        initComponents();
        cargarListas();
    }

  private void cargarDatos(Grupo u) {
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
    for (Grupo u : Fachada.listarGrupos()) {
      lista.addElement(u);
    }
  }
  private boolean guardarDatos(Grupo u) {
    try {
      if (u==null) {
        u = new Grupo();
        u.setId(Integer.parseInt(tId.getText()));
      }
      u.setNombre(tNombre.getText());
      if (u.guardar()) {
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
    panelListado = new javax.swing.JScrollPane();
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

    panelListado.setMinimumSize(new java.awt.Dimension(80, 80));
    panelListado.setPreferredSize(new java.awt.Dimension(80, 160));

    jListado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jListado.setMinimumSize(new java.awt.Dimension(80, 160));
    jListado.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        jListadoValueChanged(evt);
      }
    });
    panelListado.setViewportView(jListado);

    panelABM.setLeftComponent(panelListado);

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
        Grupo unGrupo = Fachada.buscarGrupoPorId(Integer.parseInt(tId.getText()));
        if(tId.isEnabled()) {
          if (unGrupo!=null) {
            if (JOptionPane.showConfirmDialog(
              this,"El Grupo con ID "+tId.getText()+" ya existe ("+unGrupo.toString()+"). Deseea reemplazarlo?",
              "Confirma reemplazar?",
              JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION) {
                return;
            }
          }
        }
        if (!guardarDatos(unGrupo)) {
          throw new Exception("falló guardarDatos(unGrupo)");
        }
        else {
          JOptionPane.showMessageDialog(
              this,"Grupo guardado",
              "Grupo guardado",
              JOptionPane.INFORMATION_MESSAGE);
        }
        limpiarCampos();
      } catch (Exception e) {
        System.out.println(e.toString());
        JOptionPane.showMessageDialog(
              null,"Error al guardar el Grupo. Verifique los datos.\r\n"+
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
        Grupo unGrupo = Fachada.buscarGrupoPorId(Integer.parseInt(tId.getText()));
        if (unGrupo==null) {
          throw new Exception("No existe Grupo con ID = "+tId.getText());
        }
        if (!unGrupo.borrar()) {
          throw new Exception("Falló borrarGrupo(unGrupo)");
        }
        else {
          JOptionPane.showMessageDialog(
              this,"El Grupo "+unGrupo.toString()+" fue eliminado",
              "Grupo Eliminado",
              JOptionPane.INFORMATION_MESSAGE);
          limpiarCampos();
        }
      } catch (Exception e) {
        System.out.println(e.toString());
        JOptionPane.showMessageDialog(
              this,"Error al eliminar el Grupo. Verifique los datos.\r\n"+
              "Si el error persiste, por favor consulte con el administrador.\r\n"
              +e.toString(),
              "Error al eliminar",
              JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void jListadoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListadoValueChanged
      if (jListado.getSelectedIndex()!=-1) {
        cargarDatos((Grupo) jListado.getSelectedValue());
      }
}//GEN-LAST:event_jListadoValueChanged

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
      this.dispose();
    }//GEN-LAST:event_bCerrarActionPerformed

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
  private javax.swing.JScrollPane panelListado;
  private javax.swing.JTextField tId;
  private javax.swing.JTextField tNombre;
  // End of variables declaration//GEN-END:variables
  private javax.swing.DefaultListModel lista;


}
