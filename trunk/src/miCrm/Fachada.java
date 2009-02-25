/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm;

import lib.model.miCRM.*;
import lib.model.servicios.*;

/**
 *
 * @author Administrator
 */
public class Fachada {

  static boolean borrarUsuario(Usuario unUsuario) {
    return Usuarios.borrar(unUsuario);
  }

  static boolean guardarUsuario(Usuario unUsuario) {
    return Usuarios.guardar(unUsuario);
  }
  Fachada fachada = null;
  private Fachada() { }
  public Fachada getInstance() {
    if (this.fachada==null) {
      this.fachada = new Fachada();
    }
    return fachada;
  }
  public static boolean loginUsuario(String usuario, char[] password) {
    return Usuarios.login(usuario, password);
  }

}
