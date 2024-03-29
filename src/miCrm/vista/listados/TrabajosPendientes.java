/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistroContactos.java
 *
 * Created on 21/02/2009, 04:16:20 PM
 */

package miCrm.vista.listados;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lib.model.miCRM.Contacto;
import lib.model.miCRM.Usuario;
import lib.utilities.DateUtilities;
import lib.utilities.StringUtilities;
import miCrm.Conf;
import miCrm.Fachada;


/**
 *
 * @author Administrator
 */
public class TrabajosPendientes extends javax.swing.JDialog {
    private JFrame ventanaPadre = null;
    /** Creates new form RegistroContactos */
    public TrabajosPendientes(JFrame parent) {
      super(parent);
      this.ventanaPadre = parent;
      initComponents();
      cargarDatos();
    }

  private void cargarDatos() {
    Date fecha = new Date();
    
    ArrayList<Usuario> tecnicos = Fachada.listarTecnicos();
    cTecnico.removeAllItems();
    for (Usuario u : tecnicos) {
      cTecnico.addItem(u);
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

    pControlAsignaciones = new javax.swing.JSplitPane();
    pAsignacionContacto = new javax.swing.JPanel();
    bGuardar = new javax.swing.JButton();
    bCancelar = new javax.swing.JButton();
    lTecnico = new javax.swing.JLabel();
    lIcon = new javax.swing.JLabel();
    bImprimir = new javax.swing.JButton();
    bExportar = new javax.swing.JButton();
    cTecnico = new javax.swing.JComboBox();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();

    setTitle("Registro de Contactos");

    pControlAsignaciones.setDividerLocation(850);

    pAsignacionContacto.setPreferredSize(new java.awt.Dimension(422, 448));

    bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/report_go.png"))); // NOI18N
    bGuardar.setText("Generar");
    bGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bGuardarActionPerformed(evt);
      }
    });

    bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/cancel.png"))); // NOI18N
    bCancelar.setText("Cancelar");
    bCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCancelarActionPerformed(evt);
      }
    });

    lTecnico.setText("Tecnico");

    lIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/84.png"))); // NOI18N

    bImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/printer.png"))); // NOI18N
    bImprimir.setText("Imprimir");
    bImprimir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bImprimirActionPerformed(evt);
      }
    });

    bExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/report_disk.png"))); // NOI18N
    bExportar.setText("Exportar");
    bExportar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bExportarActionPerformed(evt);
      }
    });

    cTecnico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    javax.swing.GroupLayout pAsignacionContactoLayout = new javax.swing.GroupLayout(pAsignacionContacto);
    pAsignacionContacto.setLayout(pAsignacionContactoLayout);
    pAsignacionContactoLayout.setHorizontalGroup(
      pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pAsignacionContactoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAsignacionContactoLayout.createSequentialGroup()
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(bImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(bGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
            .addGap(53, 53, 53))
          .addGroup(pAsignacionContactoLayout.createSequentialGroup()
            .addComponent(bExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(53, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAsignacionContactoLayout.createSequentialGroup()
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(cTecnico, javax.swing.GroupLayout.Alignment.LEADING, 0, 117, Short.MAX_VALUE)
              .addComponent(lTecnico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(bCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(lIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
            .addGap(53, 53, 53))))
    );

    pAsignacionContactoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCancelar, bGuardar, lTecnico});

    pAsignacionContactoLayout.setVerticalGroup(
      pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pAsignacionContactoLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(lTecnico)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
        .addComponent(bGuardar)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bImprimir)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bExportar)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bCancelar)
        .addGap(89, 89, 89))
    );

    pControlAsignaciones.setRightComponent(pAsignacionContacto);

    jTextArea1.setColumns(20);
    jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12));
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    pControlAsignaciones.setLeftComponent(jScrollPane1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pControlAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pControlAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void limpiarCampos() {
    
  }

  private void mostrarReporte() {
    Usuario tecnico = (Usuario) cTecnico.getSelectedItem();
    ArrayList<Contacto> llamadasTecnico = Fachada.listarContactosPorTecnicoPorEstado(tecnico, Conf.ESTADO_ASIGNADO);

    String reporte = "Llamadas para "+tecnico.toString()+"\r\n";
    reporte += StringUtilities.pad("Fecha", 12);
    reporte += StringUtilities.pad("Cliente", 30);
    reporte += StringUtilities.pad("Telefonista", 30);
    reporte += "\r\n";
    if (llamadasTecnico==null) {
      reporte+="Sin Llamadas";
    }
    else {
      for (Contacto c : llamadasTecnico) {
        String recibido = DateUtilities.toString(c.getRecibidoEl(), DateUtilities.DATE_FORMAT);
        reporte+=StringUtilities.pad(recibido.toString(), 12);
        if (c.getCliente()!=null) {
          reporte+=StringUtilities.pad(c.getCliente().toString(), 30);
        }
        else {
          reporte+=StringUtilities.pad(null,30);
        }
        if (c.getTelefonista()!=null) {
          reporte+=StringUtilities.pad(c.getTelefonista().toString(), 30);
        }
        else {
          reporte+=StringUtilities.pad(null,30);
        }
        reporte+="\r\n";

      }
    }
    jTextArea1.setText(reporte);
    
  }

  private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
    if (validarDatos()) {
      mostrarReporte();
    }
    else {
      JOptionPane.showMessageDialog(
        this,"Los datos para generar el reporte no son correctos\r\nPor Favor, verifique.",
        "Error de Datos",
        JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_bGuardarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
    this.dispose();
}//GEN-LAST:event_bCancelarActionPerformed

    private void bImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImprimirActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_bImprimirActionPerformed

    private void bExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExportarActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_bExportarActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bCancelar;
  private javax.swing.JButton bExportar;
  private javax.swing.JButton bGuardar;
  private javax.swing.JButton bImprimir;
  private javax.swing.JComboBox cTecnico;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JLabel lIcon;
  private javax.swing.JLabel lTecnico;
  private javax.swing.JPanel pAsignacionContacto;
  private javax.swing.JSplitPane pControlAsignaciones;
  // End of variables declaration//GEN-END:variables

  private boolean validarDatos() {
    try {
      if (cTecnico.getSelectedIndex()==-1) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
