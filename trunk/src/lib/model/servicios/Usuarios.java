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
    if (pUsuario.borrar(unUsuario)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(Usuario unUsuario) {
    if (pUsuario.guardar(unUsuario)) {
      return true;
    }
    return false;
  }
  public ArrayList listar() {
    return pUsuario.listar();
  }

  public Object buscarPorId(Integer id) {
    return pUsuario.buscarPorId(id);
  }

  public ArrayList buscarPorNombre(String nombre) {
    return pUsuario.buscarPorNombre(nombre);
  }

  public static boolean login(String usuario, char[] password) {
    return true;
  }


}
