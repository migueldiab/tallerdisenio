/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Articulos.java
 *
 * Created on 21/02/2009, 04:00:29 PM
 */

package miCrm.vista.admin;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lib.model.miCRM.*;
import miCrm.Fachada;
import miCrm.vista.ModeloArbol;

/**
 *
 * @author Administrator
 */
public class Articulos extends javax.swing.JDialog {

    /** Creates new form Articulos */
    public Articulos(JFrame parent) {
      super(parent);
      initComponents();
      limpiarCampos();
      cargarListas();
    }

  private void agregarComponente() {
    if (lArticulos.getSelectedIndex()==-1) {
      JOptionPane.showMessageDialog(
        this,"Debe seleccionar un artículo a agregar",
        "Error al agregar",
        JOptionPane.ERROR_MESSAGE);
    }
    else {
      try {
        Articulo elArticulo = (Articulo) arbolComponentes.getRoot();
        Articulo elComponente = (Articulo) lArticulos.getSelectedValue();
        if (elArticulo.equals(elComponente)) {
          JOptionPane.showMessageDialog(
            null,"No puede agregar a un articulo el mismo como componente",
            "Error al agregar",
            JOptionPane.ERROR_MESSAGE);
        }
        else {
          if (elArticulo.agregarComponente(elComponente)) {
            tComponentes.updateUI();
          }
          else {
            JOptionPane.showMessageDialog(
              this,"No puede agregar el componente seleccionado.\r\nVerifique dependencia circular.",
              "Error al agregar",
              JOptionPane.ERROR_MESSAGE);
          }
        }
      } catch (Exception e) {
        System.out.println(e.toString());
        JOptionPane.showMessageDialog(
              this,"Error al agregar componente. Verifique los datos.\r\n"+
              "Si el error persiste, por favor consulte con el administrador.\r\n"
              +e.toString(),
              "Error al agregar componente",
              JOptionPane.ERROR_MESSAGE);
      }

    }
  }

  private void eliminarArticulo() {
    try {
      Articulo unArticulo = Fachada.buscarArticuloPorId(Integer.parseInt(tId.getText()));
      if (unArticulo==null) {
        throw new Exception("No existe Articulo con ID = "+tId.getText());
      }
      if (!unArticulo.borrar()) {
        throw new Exception("Falló borrarArticulo(unArticulo)");
      }
      else {
        JOptionPane.showMessageDialog(
            this,"El Articulo "+unArticulo.toString()+" fue eliminado",
            "Articulo Eliminado",
            JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      JOptionPane.showMessageDialog(
            this,"Error al eliminar el Articulo. Verifique los datos.\r\n"+
            "Si el error persiste, por favor consulte con el administrador.\r\n"
            +e.toString(),
            "Error al eliminar",
            JOptionPane.ERROR_MESSAGE);
    }
  }



  private void guardarArticulo() {
    try {
        if (!validarCampos()) {
          return;
        }
        Articulo u = new Articulo();
        if (!tId.getText().equals("")) {
          u.setId(Integer.parseInt(tId.getText()));
        }
        u.setNombre(tNombre.getText());
        u.setCosto(Double.parseDouble(tCosto.getText()));
        u.remplazarComponentes(((Articulo) arbolComponentes.getRoot()).getComponentes());
        if (u.guardar()) {
          JOptionPane.showMessageDialog(
              this,"Articulo guardado",
              "Articulo guardado",
              JOptionPane.INFORMATION_MESSAGE);
        }
        else {
          throw new Exception("falló guardarDatos(unArticulo)");
        }
        limpiarCampos();
      } catch (Exception e) {
        System.out.println(e.toString());
        JOptionPane.showMessageDialog(
              this,"Error al guardar el Articulo. Verifique los datos.\r\n"+
              "Si el error persiste, por favor consulte con el administrador.\r\n"
              +e.toString(),
              "Error al guardar",
              JOptionPane.ERROR_MESSAGE);
      }
  }
  private void quitarComponete() {
    try {
      Articulo elArticulo = (Articulo) arbolComponentes.getRoot();
      Articulo elComponente = (Articulo) tComponentes.getLastSelectedPathComponent();
      if (elComponente==null) {
        JOptionPane.showMessageDialog(
          this,"Debe seleccionar un artículo a eliminar",
          "Error al eliminar",
          JOptionPane.ERROR_MESSAGE);
      }
      if (elArticulo.equals(elComponente)) {
        JOptionPane.showMessageDialog(
          this,"No puede eliminar la base el articulo",
          "Error al eliminar",
          JOptionPane.ERROR_MESSAGE);
      }
      else {
        if (elArticulo.eliminarComponente(elComponente)) {
          tComponentes.updateUI();
        }
        else {
          JOptionPane.showMessageDialog(
            this,"No puede eliminar el componente seleccionado.",
            "Error al eliminar",
            JOptionPane.ERROR_MESSAGE);
        }
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      JOptionPane.showMessageDialog(
            this,"Error al eliminar componente. Verifique los datos.\r\n"+
            "Si el error persiste, por favor consulte con el administrador.\r\n"
            +e.toString(),
            "Error al eliminar componente",
            JOptionPane.ERROR_MESSAGE);
    }
  }

  private void cargarDatos(Articulo u) {
    tId.setText(u.getId().toString());
    tNombre.setText(u.getNombre());
    tCosto.setText(u.getCosto().toString());
    arbolComponentes=new ModeloArbol(u);
    tComponentes.setModel(arbolComponentes);
    tComponentes.updateUI();
  }
  private void limpiarCampos() {
    tId.setText("");
    tNombre.setText("");
    tCosto.setText("0.00");
    arbolComponentes=new ModeloArbol(new Articulo());
    tComponentes.setModel(arbolComponentes);
    tComponentes.updateUI();
    cargarListas();
  }

  private boolean validarCampos() {
    return true;
  }
  private void cargarListas() {
    
    lista.clear();
    for (Articulo u : Fachada.listarArticulos()) {
      lista.addElement(u);
    }
    articulos.clear();
    for (Articulo u : Fachada.listarArticulos()) {
      articulos.addElement(u);
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
    lCosto = new javax.swing.JLabel();
    tCosto = new javax.swing.JTextField();
    sComponentes = new javax.swing.JScrollPane();
    tComponentes = new javax.swing.JTree();
    lComponentes = new javax.swing.JLabel();
    bAgregar = new javax.swing.JButton();
    bQuitar = new javax.swing.JButton();
    sArticulos = new javax.swing.JScrollPane();
    articulos = new DefaultListModel();
    lArticulos = new javax.swing.JList(articulos);
    lIcon1 = new javax.swing.JLabel();
    panelLista = new javax.swing.JScrollPane();
    lista = new DefaultListModel();
    jListado = new javax.swing.JList(lista);

    setTitle("Articulos");
    setResizable(false);

    panelABM.setDividerLocation(150);

    panelEditar.setMinimumSize(new java.awt.Dimension(160, 160));

    lId.setText("Id");

    tId.setEnabled(false);

    lNombre.setText("Nombre");

    bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/computer_edit.png"))); // NOI18N
    bGuardar.setText("Guardar");
    bGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bGuardarActionPerformed(evt);
      }
    });

    bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/computer_delete.png"))); // NOI18N
    bEliminar.setText("Eliminar");
    bEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bEliminarActionPerformed(evt);
      }
    });

    bCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/cancel.png"))); // NOI18N
    bCerrar.setText("Cerrar");
    bCerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCerrarActionPerformed(evt);
      }
    });

    bNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/computer_add.png"))); // NOI18N
    bNuevo.setText("Nuevo");
    bNuevo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bNuevoActionPerformed(evt);
      }
    });

    lCosto.setText("Costo");

    sComponentes.setViewportView(tComponentes);

    lComponentes.setText("Componentes");

    bAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/add.png"))); // NOI18N
    bAgregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bAgregarActionPerformed(evt);
      }
    });

    bQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/delete.png"))); // NOI18N
    bQuitar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bQuitarActionPerformed(evt);
      }
    });

    sArticulos.setViewportView(lArticulos);

    lIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/22.png"))); // NOI18N

    javax.swing.GroupLayout panelEditarLayout = new javax.swing.GroupLayout(panelEditar);
    panelEditar.setLayout(panelEditarLayout);
    panelEditarLayout.setHorizontalGroup(
      panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelEditarLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panelEditarLayout.createSequentialGroup()
            .addComponent(bNuevo)
            .addGap(18, 18, 18)
            .addComponent(bGuardar)
            .addGap(18, 18, 18)
            .addComponent(bEliminar)
            .addGap(209, 209, 209))
          .addGroup(panelEditarLayout.createSequentialGroup()
            .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lNombre)
              .addComponent(lCosto)
              .addComponent(lComponentes)
              .addComponent(lId))
            .addGap(30, 30, 30)
            .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(bCerrar)
              .addGroup(panelEditarLayout.createSequentialGroup()
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(panelEditarLayout.createSequentialGroup()
                    .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addComponent(tNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                      .addComponent(sComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(bQuitar)
                      .addComponent(bAgregar)))
                  .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(sArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(lIcon1)))))))
    );
    panelEditarLayout.setVerticalGroup(
      panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelEditarLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panelEditarLayout.createSequentialGroup()
            .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(lId)
              .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(lNombre)
              .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(lCosto)
              .addComponent(tCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(lIcon1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(sArticulos, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
          .addComponent(lComponentes, javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditarLayout.createSequentialGroup()
            .addComponent(bAgregar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bQuitar))
          .addComponent(sComponentes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bNuevo)
          .addComponent(bGuardar)
          .addComponent(bEliminar)
          .addComponent(bCerrar))
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
      .addComponent(panelABM, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelABM, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
      guardarArticulo();
}//GEN-LAST:event_bGuardarActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
      limpiarCampos();
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
      eliminarArticulo();
    }//GEN-LAST:event_bEliminarActionPerformed

    private void jListadoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListadoValueChanged
      if (jListado.getSelectedIndex()!=-1) {
        cargarDatos((Articulo) jListado.getSelectedValue());
      }
}//GEN-LAST:event_jListadoValueChanged

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
      this.dispose();
    }//GEN-LAST:event_bCerrarActionPerformed

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
      agregarComponente();
}//GEN-LAST:event_bAgregarActionPerformed

    private void bQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQuitarActionPerformed
      quitarComponete();
    }//GEN-LAST:event_bQuitarActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bAgregar;
  private javax.swing.JButton bCerrar;
  private javax.swing.JButton bEliminar;
  private javax.swing.JButton bGuardar;
  private javax.swing.JButton bNuevo;
  private javax.swing.JButton bQuitar;
  private javax.swing.JList jListado;
  private javax.swing.JList lArticulos;
  private javax.swing.JLabel lComponentes;
  private javax.swing.JLabel lCosto;
  private javax.swing.JLabel lIcon1;
  private javax.swing.JLabel lId;
  private javax.swing.JLabel lNombre;
  private javax.swing.JSplitPane panelABM;
  private javax.swing.JPanel panelEditar;
  private javax.swing.JScrollPane panelLista;
  private javax.swing.JScrollPane sArticulos;
  private javax.swing.JScrollPane sComponentes;
  private javax.swing.JTree tComponentes;
  private javax.swing.JTextField tCosto;
  private javax.swing.JTextField tId;
  private javax.swing.JTextField tNombre;
  // End of variables declaration//GEN-END:variables
  private javax.swing.DefaultListModel lista;
  private javax.swing.DefaultListModel articulos;
  private ModeloArbol arbolComponentes = null;  //  @jve:decl-index=0:

}
