/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.Usuario;
import lib.model.persistencia.pUsuario;

/**
 *
 * @author Administrator
 */
public class Usuarios implements Servicios {

  public static boolean borrar(Usuario unUsuario) {
    pUsuario unPUsuario = new pUsuario();
    if (unPUsuario.borrar(unUsuario)) {
      return true;
    }
    return false;
  }

  public static boolean guardar(Usuario unUsuario) {
    pUsuario unPUsuario = new pUsuario();
    if (unPUsuario.guardar(unUsuario)) {
      return true;
    }
    return false;
  }

  public ArrayList listar() {
    return null;
  }

  public Object buscarPorId(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public ArrayList buscarPorNombre(String nombre) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public static boolean login(String usuario, char[] password) {
    return true;
  }


}
