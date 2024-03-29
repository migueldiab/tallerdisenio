/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Login.java
 *
 * Created on 20/02/2009, 02:31:18 PM
 */

package miCrm.vista;

import lib.model.miCRM.Usuario;
import miCrm.Conf;
import miCrm.Fachada;
import miCrm.resources.widget.StatusBar.MSG;
import miCrm.resources.widget.Ventanas;

/**
 *
 * @author Administrator
 */
public class Login extends javax.swing.JFrame {

    /** Creates new form Login */
    public Login() {
        initComponents();
        Ventanas.centrarVentana(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    bCerrar = new javax.swing.JButton();
    bEntrar = new javax.swing.JButton();
    lPassword = new javax.swing.JLabel();
    lUsuario = new javax.swing.JLabel();
    tUsuario = new javax.swing.JTextField();
    tPassword = new javax.swing.JPasswordField();
    pImagen = new javax.swing.JPanel();
    lBgImage = new javax.swing.JLabel();
    StatusBar = new miCrm.resources.widget.StatusBar();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Ingresar a miCRM");

    bCerrar.setText("Cerrar");
    bCerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCerrarActionPerformed(evt);
      }
    });

    bEntrar.setText("Entrar");
    bEntrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bEntrarActionPerformed(evt);
      }
    });

    lPassword.setText("Contraseña");

    lUsuario.setText("Usuario");

    tUsuario.setText("admin");
    tUsuario.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tUsuarioActionPerformed(evt);
      }
    });

    tPassword.setText("test");

    lBgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miCrm/resources/images/49.png"))); // NOI18N

    javax.swing.GroupLayout pImagenLayout = new javax.swing.GroupLayout(pImagen);
    pImagen.setLayout(pImagenLayout);
    pImagenLayout.setHorizontalGroup(
      pImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(lBgImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    pImagenLayout.setVerticalGroup(
      pImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pImagenLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(lBgImage, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(pImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lPassword)
          .addComponent(lUsuario))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(tUsuario)
          .addComponent(tPassword)
          .addGroup(layout.createSequentialGroup()
            .addComponent(bEntrar)
            .addGap(18, 18, 18)
            .addComponent(bCerrar)))
        .addContainerGap(26, Short.MAX_VALUE))
      .addComponent(StatusBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(pImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lUsuario))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lPassword))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(bEntrar)
              .addComponent(bCerrar))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(StatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void bEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEntrarActionPerformed
      try {
        Usuario unUsuario = Fachada.loginUsuario(tUsuario.getText(), tPassword.getPassword());
        if (unUsuario!=null) {
          Conf.setUsuarioLogueado(unUsuario);
          Principal vPrincipal = new Principal();
          vPrincipal.setVisible(true);
          this.dispose();
        }
        else {
         StatusBar.setMessage("Login Error", MSG.ERROR);
        }
      } catch (Exception e) {
        System.out.println(e.toString());
      }
    }//GEN-LAST:event_bEntrarActionPerformed

    private void tUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tUsuarioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_tUsuarioActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
      this.dispose();
    }//GEN-LAST:event_bCerrarActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private miCrm.resources.widget.StatusBar StatusBar;
  private javax.swing.JButton bCerrar;
  private javax.swing.JButton bEntrar;
  private javax.swing.JLabel lBgImage;
  private javax.swing.JLabel lPassword;
  private javax.swing.JLabel lUsuario;
  private javax.swing.JPanel pImagen;
  private javax.swing.JPasswordField tPassword;
  private javax.swing.JTextField tUsuario;
  // End of variables declaration//GEN-END:variables

}
