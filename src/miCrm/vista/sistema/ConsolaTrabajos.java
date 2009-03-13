/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistroContactos.java
 *
 * Created on 21/02/2009, 04:16:20 PM
 */

package miCrm.vista.sistema;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import lib.model.miCRM.Cliente;
import lib.model.miCRM.EstadoContacto;
import lib.model.miCRM.Prioridad;
import lib.model.miCRM.TipoContacto;
import lib.model.miCRM.Usuario;
import miCrm.Fachada;

/**
 *
 * @author Administrator
 */
public class ConsolaTrabajos extends javax.swing.JDialog {

    /** Creates new form RegistroContactos */
    public ConsolaTrabajos(JFrame parent) {
      super(parent);
      initComponents();
      cargarListas();
      cargarCamposAutomaticos();
    }

  private void cargarCamposAutomaticos() {        
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hora = new SimpleDateFormat("H:mm");
    tFecha.setText(fecha.format(new Date()));
    tHora.setText(hora.format(new Date()));
    Prioridad p = Fachada.buscarPrioridadPorNombre("Pendiente");
    cPrioridad.setSelectedIndex(WIDTH);
  }

  private void cargarListas() {
    ArrayList<Cliente> lista = Fachada.listarClientes();
    listaClientes.clear();
    for (Cliente c : lista) {
      listaClientes.addElement(c);
    }
    cEstado.removeAllItems();
    for (EstadoContacto e : Fachada.listarEstados()) {
      cEstado.addItem(e);
    }
    cPrioridad.removeAllItems();
    for (Prioridad e : Fachada.listarPrioridades()) {
      cPrioridad.addItem(e);
    }
    cTecnico.removeAllItems();
    for (Usuario e : Fachada.listarTecnicos()) {
      cTecnico.addItem(e);
    }
    cTipoContacto.removeAllItems();
    for (TipoContacto e : Fachada.listarTipoContactos()) {
      cTipoContacto.addItem(e);
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

    dClientes = new javax.swing.JDialog();
    sCleintes = new javax.swing.JScrollPane();
    lClientes = new javax.swing.JList();
    bSeleccionar = new javax.swing.JButton();
    jSplitPane1 = new javax.swing.JSplitPane();
    jPanel1 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    cTipoContacto = new javax.swing.JComboBox();
    tCliente = new javax.swing.JTextField();
    tBuscarCliente = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tDescripcion = new javax.swing.JTextArea();
    tTelefono = new javax.swing.JTextField();
    cEstado = new javax.swing.JComboBox();
    cTecnico = new javax.swing.JComboBox();
    cPrioridad = new javax.swing.JComboBox();
    tFecha = new javax.swing.JTextField();
    tHora = new javax.swing.JTextField();
    bGuardar = new javax.swing.JButton();
    bCancelar = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();

    dClientes.setAlwaysOnTop(true);
    dClientes.setBounds(new java.awt.Rectangle(0, 0, 150, 300));

    lClientes.setModel(listaClientes);
    sCleintes.setViewportView(lClientes);

    dClientes.getContentPane().add(sCleintes, java.awt.BorderLayout.CENTER);

    bSeleccionar.setText("Seleccionar");
    bSeleccionar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bSeleccionarActionPerformed(evt);
      }
    });
    dClientes.getContentPane().add(bSeleccionar, java.awt.BorderLayout.PAGE_END);

    setTitle("Registro de Contactos");

    jSplitPane1.setDividerLocation(400);
    jSplitPane1.setMinimumSize(new java.awt.Dimension(850, 454));
    jSplitPane1.setPreferredSize(new java.awt.Dimension(900, 454));

    jPanel1.setMinimumSize(new java.awt.Dimension(450, 452));
    jPanel1.setPreferredSize(new java.awt.Dimension(450, 452));

    jLabel3.setText("Telefono Origen");

    jLabel4.setText("Cliente");

    jLabel1.setText("Fecha");

    jLabel2.setText("Hora");

    jLabel6.setText("Descripción");

    jLabel5.setText("Tipo Contacto");

    jLabel9.setText("Prioridad");

    jLabel7.setText("Estado");

    jLabel8.setText("Tecnico");

    cTipoContacto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    tCliente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tClienteActionPerformed(evt);
      }
    });
    tCliente.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        tClienteFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        tClienteFocusLost(evt);
      }
    });

    tBuscarCliente.setText("...");
    tBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tBuscarClienteActionPerformed(evt);
      }
    });

    tDescripcion.setColumns(20);
    tDescripcion.setRows(5);
    jScrollPane1.setViewportView(tDescripcion);

    tTelefono.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tTelefonoActionPerformed(evt);
      }
    });

    cEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    cTecnico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    cPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    tFecha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tFechaActionPerformed(evt);
      }
    });

    tHora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tHoraActionPerformed(evt);
      }
    });

    bGuardar.setText("Guardar");
    bGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bGuardarActionPerformed(evt);
      }
    });

    bCancelar.setText("Cancelar");
    bCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCancelarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3)
          .addComponent(jLabel4)
          .addComponent(jLabel1)
          .addComponent(jLabel2)
          .addComponent(jLabel6)
          .addComponent(jLabel5)
          .addComponent(jLabel9)
          .addComponent(jLabel7)
          .addComponent(jLabel8))
        .addGap(51, 51, 51)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(cTipoContacto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane1)
          .addComponent(tTelefono)
          .addComponent(cEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 166, Short.MAX_VALUE)
          .addComponent(cTecnico, 0, 166, Short.MAX_VALUE)
          .addComponent(cPrioridad, javax.swing.GroupLayout.Alignment.TRAILING, 0, 166, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(bGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(bCancelar))))
        .addContainerGap(139, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel2)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(bGuardar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bCancelar)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tBuscarCliente))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cTipoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addComponent(jLabel6)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7))
        .addGap(7, 7, 7)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel9))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel8))
        .addContainerGap(119, Short.MAX_VALUE))
    );

    jSplitPane1.setRightComponent(jPanel1);

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane2.setViewportView(jTable1);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(30, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(37, Short.MAX_VALUE))
    );

    jSplitPane1.setLeftComponent(jPanel2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void seleccionarCliente(Object selectedValue) {
    try {
      Cliente unCliente = (Cliente) selectedValue;
      tCliente.setText(unCliente.toString());
      dClientes.setVisible(false);
    } catch (Exception e) {
    }
  }

    private void tFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFechaActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tFechaActionPerformed

    private void tHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHoraActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tHoraActionPerformed

    private void tClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tClienteActionPerformed
      // TODO add your handling code here:
      
}//GEN-LAST:event_tClienteActionPerformed

    private void tTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTelefonoActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tTelefonoActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_bGuardarActionPerformed

    private void tBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuscarClienteActionPerformed
      dClientes.setVisible(true);
}//GEN-LAST:event_tBuscarClienteActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_bCancelarActionPerformed

    private void tClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tClienteFocusGained

    }//GEN-LAST:event_tClienteFocusGained

    private void tClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tClienteFocusLost

    }//GEN-LAST:event_tClienteFocusLost

    private void bSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeleccionarActionPerformed
    seleccionarCliente(lClientes.getSelectedValue());
}//GEN-LAST:event_bSeleccionarActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bCancelar;
  private javax.swing.JButton bGuardar;
  private javax.swing.JButton bSeleccionar;
  private javax.swing.JComboBox cEstado;
  private javax.swing.JComboBox cPrioridad;
  private javax.swing.JComboBox cTecnico;
  private javax.swing.JComboBox cTipoContacto;
  private javax.swing.JDialog dClientes;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JSplitPane jSplitPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JList lClientes;
  private javax.swing.JScrollPane sCleintes;
  private javax.swing.JButton tBuscarCliente;
  private javax.swing.JTextField tCliente;
  private javax.swing.JTextArea tDescripcion;
  private javax.swing.JTextField tFecha;
  private javax.swing.JTextField tHora;
  private javax.swing.JTextField tTelefono;
  // End of variables declaration//GEN-END:variables
  DefaultListModel listaClientes = new DefaultListModel();
}
