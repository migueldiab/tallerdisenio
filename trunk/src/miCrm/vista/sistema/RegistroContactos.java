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

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lib.model.miCRM.Cliente;
import lib.model.miCRM.Contacto;
import lib.model.miCRM.EstadoContacto;
import lib.model.miCRM.Prioridad;
import lib.model.miCRM.TipoContacto;
import lib.model.miCRM.Usuario;
import miCrm.Conf;
import miCrm.Fachada;

/**
 *
 * @author Administrator
 */
public class RegistroContactos extends javax.swing.JDialog {

    /** Creates new form RegistroContactos */
    public RegistroContactos(JFrame parent) {
      super(parent);
      initComponents();
      cargarListas();
      cargarCamposAutomaticos();
    }

  private void buscarCliente(String nombre, String apellido) {
    ArrayList<Cliente> losClientes = Fachada.buscarClientePorApellidoNombre(nombre, apellido);
    if (losClientes.size()!=1) {
      tCliente.setForeground(Color.red);
      dClientes.setVisible(true);
    }
    else {
      tCliente.setForeground(Color.BLACK);
      elCliente = losClientes.get(0);
    }
  }

  private void cargarCamposAutomaticos() {        
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hora = new SimpleDateFormat("H:mm");
    tFecha.setText(fecha.format(new Date()));
    tHora.setText(hora.format(new Date()));
    cEstado.setSelectedItem(Conf.ESTADO_NUEVO_CONTACTO);
    cTecnico.setSelectedItem(Conf.TECNICO_POR_DEFECTO);
    cPrioridad.setSelectedItem(Conf.PRIORIDAD_POR_DEFECTO);
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

  private void guardarContacto() {
    Contacto c = new Contacto();
    c.setCliente(elCliente);

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
    tFecha = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    tHora = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    tCliente = new javax.swing.JTextField();
    tTelefono = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tDescripcion = new javax.swing.JTextArea();
    jLabel7 = new javax.swing.JLabel();
    bGuardar = new javax.swing.JButton();
    tBuscarCliente = new javax.swing.JButton();
    cTipoContacto = new javax.swing.JComboBox();
    cEstado = new javax.swing.JComboBox();
    jLabel8 = new javax.swing.JLabel();
    cTecnico = new javax.swing.JComboBox();
    jLabel9 = new javax.swing.JLabel();
    cPrioridad = new javax.swing.JComboBox();
    bCancelar = new javax.swing.JButton();
    bnuevo = new javax.swing.JButton();

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

    tFecha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tFechaActionPerformed(evt);
      }
    });

    jLabel1.setText("Fecha");

    jLabel2.setText("Hora");

    tHora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tHoraActionPerformed(evt);
      }
    });

    jLabel3.setText("Telefono Origen");

    jLabel4.setText("Cliente");

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

    tTelefono.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tTelefonoActionPerformed(evt);
      }
    });

    jLabel5.setText("Tipo Contacto");

    jLabel6.setText("Descripción");

    tDescripcion.setColumns(20);
    tDescripcion.setRows(5);
    jScrollPane1.setViewportView(tDescripcion);

    jLabel7.setText("Estado");

    bGuardar.setText("Guardar");
    bGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bGuardarActionPerformed(evt);
      }
    });

    tBuscarCliente.setText("...");
    tBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tBuscarClienteActionPerformed(evt);
      }
    });

    cTipoContacto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    cEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cEstado.setEnabled(false);

    jLabel8.setText("Tecnico");

    cTecnico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cTecnico.setEnabled(false);

    jLabel9.setText("Prioridad");

    cPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    bCancelar.setText("Cancelar");
    bCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCancelarActionPerformed(evt);
      }
    });

    bnuevo.setText("Nuevo");
    bnuevo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bnuevoActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(cTipoContacto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jScrollPane1)
              .addComponent(tTelefono)
              .addComponent(cEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 166, Short.MAX_VALUE)
              .addComponent(cTecnico, 0, 166, Short.MAX_VALUE)
              .addComponent(cPrioridad, javax.swing.GroupLayout.Alignment.TRAILING, 0, 166, Short.MAX_VALUE)
              .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(bnuevo)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
            .addGap(63, 63, 63)
            .addComponent(bCancelar)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(17, 17, 17)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tBuscarCliente))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cTipoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addComponent(jLabel6)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7))
        .addGap(7, 7, 7)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel9))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel8))
        .addGap(62, 62, 62)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bCancelar)
          .addComponent(bnuevo)
          .addComponent(bGuardar))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void seleccionarCliente(Object selectedValue) {
    try {
      Cliente unCliente = (Cliente) selectedValue;
      tCliente.setText(unCliente.toString());
      this.elCliente = unCliente;
      dClientes.setVisible(false);
    } catch (Exception e) {
      System.out.println("fallo SeleccionarCliente");
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
      if (validarDatos()) {
        guardarContacto();
      }
      else {
        JOptionPane.showMessageDialog(
        this,"Error en los datos de entrada.\r\n Por favor verifique.",
        "Error en datos",
        JOptionPane.ERROR_MESSAGE);
      }
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
      String cliente[] = tCliente.getText().split(",");
      if (cliente.length==2) {
        buscarCliente(cliente[0], cliente[1]);
      }
      else {
        buscarCliente(tCliente.getText(),null);
      }
    }//GEN-LAST:event_tClienteFocusLost

    private void bSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeleccionarActionPerformed
    seleccionarCliente(lClientes.getSelectedValue());

}//GEN-LAST:event_bSeleccionarActionPerformed

    private void bnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnuevoActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_bnuevoActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bCancelar;
  private javax.swing.JButton bGuardar;
  private javax.swing.JButton bSeleccionar;
  private javax.swing.JButton bnuevo;
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
  private javax.swing.JScrollPane jScrollPane1;
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
  Cliente elCliente = null;
  
  private boolean validarDatos() {
    return true;
  }
}