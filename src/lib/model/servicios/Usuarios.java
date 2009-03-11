/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import lib.model.miCRM.Usuario;
import lib.model.persistencia.pUsuario;

/**
 *
 * @author Administrator
 */
public class Usuarios {

  public static ArrayList<Usuario> listar() {
    return pUsuario.listar();
  }

  public static Usuario buscarPorId(Integer id) {
    return pUsuario.buscarPorId(id);
  }

  public static ArrayList buscarPorNombre(String nombre) {
    return pUsuario.buscarPorNombre(nombre);
  }

  public static boolean login(Integer usuario, char[] password) {
    Usuario unUsuario = Usuarios.buscarPorId(usuario);
    if (unUsuario!=null) {
      if (password.length == unUsuario.getPassword().length) {
        if (Arrays.equals(unUsuario.getPassword() , password)) {
          return true;
        }
      }
    }
    return false;
  }


}
