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

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lib.model.miCRM.Usuario;
import lib.utilities.DateUtilities;
import lib.utilities.StringUtilities;
import miCrm.Conf;
import miCrm.Fachada;


/**
 *
 * @author Administrator
 */
public class RankingTecnicos extends javax.swing.JDialog {
    private JFrame ventanaPadre = null;
    /** Creates new form RegistroContactos */
    public RankingTecnicos(JFrame parent) {
      super(parent);
      this.ventanaPadre = parent;
      initComponents();
      cargarDatos();
    }

  private void cargarDatos() {
    Date fecha = new Date();
    
    tFecha.setText(DateUtilities.toString(fecha, DateUtilities.DATE_FORMAT));
    tFecha1.setText(DateUtilities.toString(fecha, DateUtilities.DATE_FORMAT));
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
    lFecha = new javax.swing.JLabel();
    tFecha = new javax.swing.JTextField();
    lIcon = new javax.swing.JLabel();
    tFecha1 = new javax.swing.JTextField();
    lFecha1 = new javax.swing.JLabel();
    bImprimir = new javax.swing.JButton();
    bExportar = new javax.swing.JButton();
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

    lFecha.setText("Fecha Inicio");

    tFecha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tFechaActionPerformed(evt);
      }
    });

    lIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/81.png"))); // NOI18N

    tFecha1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tFecha1ActionPerformed(evt);
      }
    });

    lFecha1.setText("Fecha Fin");

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

    javax.swing.GroupLayout pAsignacionContactoLayout = new javax.swing.GroupLayout(pAsignacionContacto);
    pAsignacionContacto.setLayout(pAsignacionContactoLayout);
    pAsignacionContactoLayout.setHorizontalGroup(
      pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pAsignacionContactoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pAsignacionContactoLayout.createSequentialGroup()
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(tFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(lFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(tFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(lFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(lIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
            .addGap(53, 53, 53))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAsignacionContactoLayout.createSequentialGroup()
            .addGroup(pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(bImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
              .addComponent(bGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
            .addGap(53, 53, 53))
          .addGroup(pAsignacionContactoLayout.createSequentialGroup()
            .addComponent(bExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(53, Short.MAX_VALUE))))
    );

    pAsignacionContactoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCancelar, bGuardar, lFecha, lFecha1, tFecha, tFecha1});

    pAsignacionContactoLayout.setVerticalGroup(
      pAsignacionContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pAsignacionContactoLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(lFecha)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(lFecha1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
    Timestamp inicio = DateUtilities.toTimestamp(tFecha.getText(), DateUtilities.DATE_FORMAT);
    Timestamp fin = DateUtilities.toTimestamp(tFecha1.getText(), DateUtilities.DATE_FORMAT);
    Calendar now = Calendar.getInstance();
    now.setTime(fin);
    now.add(Calendar.DAY_OF_MONTH, 1);
    fin.setTime(now.getTimeInMillis());
    Hashtable<Usuario, Integer> rankingTecnicos = Fachada.listarRankingTecnicos(inicio, fin, Conf.ESTADO_FINALIZADO);

    String reporte = "Ranking técnicos entre "+tFecha.getText()+" y "+tFecha1.getText()+"\r\n";
    reporte += StringUtilities.pad("Tecnico", 30);
    reporte += StringUtilities.pad("Cantidad de casos", 15);
    reporte += "\r\n";
    if (rankingTecnicos==null) {
      reporte+="Sin casos resueltos";
    }
    else {
      Enumeration ranking = rankingTecnicos.keys();
      while (ranking.hasMoreElements())
      {
        Usuario tecnico = (Usuario) ranking.nextElement();
        Integer casos = (Integer) rankingTecnicos.get(tecnico);
        reporte+=StringUtilities.pad(tecnico.toString(), 30);
        reporte+=StringUtilities.pad(casos.toString(), 15);
        reporte+="\r\n";
      }
    }
    jTextArea1.setText(reporte);
    
  }

  private void tFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFechaActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tFechaActionPerformed

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

    private void tFecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFecha1ActionPerformed
      // TODO add your handling code here:
}//GEN-LAST:event_tFecha1ActionPerformed

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
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JLabel lFecha;
  private javax.swing.JLabel lFecha1;
  private javax.swing.JLabel lIcon;
  private javax.swing.JPanel pAsignacionContacto;
  private javax.swing.JSplitPane pControlAsignaciones;
  private javax.swing.JTextField tFecha;
  private javax.swing.JTextField tFecha1;
  // End of variables declaration//GEN-END:variables

  private boolean validarDatos() {
    try {
      Timestamp inicio = DateUtilities.toTimestamp(tFecha.getText(), DateUtilities.DATE_FORMAT);
      if (inicio==null) {
        return false;
      }
      Timestamp fin = DateUtilities.toTimestamp(tFecha1.getText(), DateUtilities.DATE_FORMAT);
      if (fin==null) {
        return false;
      }
      if ((inicio.getTime()-fin.getTime()) > 0) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
