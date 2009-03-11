/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 20/02/2009, 02:28:27 PM
 */

package miCrm.vista;

/**
 *
 * @author Administrator
 */
public class Principal extends javax.swing.JFrame {

    /** Creates new form Principal */
    public Principal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTextField1 = new javax.swing.JTextField();
    jInternalFrame1 = new javax.swing.JInternalFrame();
    jPanel1 = new javax.swing.JPanel();
    jMenuBar1 = new javax.swing.JMenuBar();
    mArchivo = new javax.swing.JMenu();
    mSalir = new javax.swing.JMenuItem();
    mAdministracion = new javax.swing.JMenu();
    mArticulos = new javax.swing.JMenuItem();
    mClientes = new javax.swing.JMenuItem();
    mGrupos = new javax.swing.JMenuItem();
    mUsuarios = new javax.swing.JMenuItem();
    mOperaciones = new javax.swing.JMenu();
    mContactos = new javax.swing.JMenu();
    mNuevoContacto = new javax.swing.JMenuItem();
    mControlAsignaciones = new javax.swing.JMenuItem();
    mListados = new javax.swing.JMenu();
    mLlamadasFecha = new javax.swing.JMenuItem();
    mTrabajosPendientes = new javax.swing.JMenuItem();
    mRankingTecnicos = new javax.swing.JMenuItem();

    jTextField1.setText("jTextField1");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("miCRM - Líder en manejo de contactos");

    jInternalFrame1.setClosable(true);
    jInternalFrame1.setIconifiable(true);
    jInternalFrame1.setVisible(true);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 413, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 224, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
    jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
    jInternalFrame1Layout.setHorizontalGroup(
      jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
      .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addContainerGap()))
    );
    jInternalFrame1Layout.setVerticalGroup(
      jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 235, Short.MAX_VALUE)
      .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addContainerGap()))
    );

    mArchivo.setText("Archivo");

    mSalir.setText("Salir");
    mSalir.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        mSalirMouseClicked(evt);
      }
    });
    mArchivo.add(mSalir);

    jMenuBar1.add(mArchivo);

    mAdministracion.setText("Administracion");

    mArticulos.setText("Articulos");
    mArticulos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mArticulosActionPerformed(evt);
      }
    });
    mAdministracion.add(mArticulos);

    mClientes.setText("Clientes");
    mClientes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mClientesActionPerformed(evt);
      }
    });
    mAdministracion.add(mClientes);

    mGrupos.setText("Grupos");
    mGrupos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mGruposActionPerformed(evt);
      }
    });
    mAdministracion.add(mGrupos);

    mUsuarios.setText("Usuarios");
    mUsuarios.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mUsuariosActionPerformed(evt);
      }
    });
    mAdministracion.add(mUsuarios);

    jMenuBar1.add(mAdministracion);

    mOperaciones.setText("Operaciones");

    mContactos.setText("Contactos");

    mNuevoContacto.setText("Nuevo Contacto");
    mNuevoContacto.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mNuevoContactoActionPerformed(evt);
      }
    });
    mContactos.add(mNuevoContacto);

    mControlAsignaciones.setText("Control de Asignaciones");
    mContactos.add(mControlAsignaciones);

    mOperaciones.add(mContactos);

    jMenuBar1.add(mOperaciones);

    mListados.setText("Listados");

    mLlamadasFecha.setText("Llamadas por Fecha");
    mListados.add(mLlamadasFecha);

    mTrabajosPendientes.setText("Trabajos Pendientes");
    mListados.add(mTrabajosPendientes);

    mRankingTecnicos.setText("Ranking Técnicos");
    mListados.add(mRankingTecnicos);

    jMenuBar1.add(mListados);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(794, Short.MAX_VALUE)
        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(173, 173, 173))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(107, 107, 107)
        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(380, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void mSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mSalirMouseClicked
      
    }//GEN-LAST:event_mSalirMouseClicked

    private void mUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUsuariosActionPerformed
      Usuarios vUsuarios = new Usuarios(this);
      vUsuarios.setVisible(true);
    }//GEN-LAST:event_mUsuariosActionPerformed

    private void mNuevoContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNuevoContactoActionPerformed
      RegistroContactos vRegistroContactos = new RegistroContactos(this);
      vRegistroContactos.setVisible(true);
    }//GEN-LAST:event_mNuevoContactoActionPerformed

    private void mGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGruposActionPerformed
      Grupos vGrupos = new Grupos(this);
      vGrupos.setVisible(true);
    }//GEN-LAST:event_mGruposActionPerformed

    private void mClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClientesActionPerformed
      Clientes vClientes = new Clientes(this);
      vClientes.setVisible(true);
    }//GEN-LAST:event_mClientesActionPerformed

    private void mArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mArticulosActionPerformed
      Articulos vArticulos = new Articulos(this);
      vArticulos.setVisible(true);
    }//GEN-LAST:event_mArticulosActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JInternalFrame jInternalFrame1;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JMenu mAdministracion;
  private javax.swing.JMenu mArchivo;
  private javax.swing.JMenuItem mArticulos;
  private javax.swing.JMenuItem mClientes;
  private javax.swing.JMenu mContactos;
  private javax.swing.JMenuItem mControlAsignaciones;
  private javax.swing.JMenuItem mGrupos;
  private javax.swing.JMenu mListados;
  private javax.swing.JMenuItem mLlamadasFecha;
  private javax.swing.JMenuItem mNuevoContacto;
  private javax.swing.JMenu mOperaciones;
  private javax.swing.JMenuItem mRankingTecnicos;
  private javax.swing.JMenuItem mSalir;
  private javax.swing.JMenuItem mTrabajosPendientes;
  private javax.swing.JMenuItem mUsuarios;
  // End of variables declaration//GEN-END:variables

}
