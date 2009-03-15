/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import lib.model.miCRM.Grupo;
import lib.model.miCRM.Usuario;
import lib.model.persistencia.pUsuario;
import miCrm.Fachada;

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

  public static Usuario buscarPorNombre(String nombre) {
    return pUsuario.buscarPorNombre(nombre);
  }

  public static ArrayList<Usuario> listarPorGrupo(String grupo) {
    ArrayList<Usuario> losUsuarios = pUsuario.listar();
    ArrayList<Usuario> subgrupo = new ArrayList<Usuario>();
    Grupo tecnico = Fachada.buscarGrupoPorNombre(grupo);
    for (Usuario u : losUsuarios) {
      if (u.getGrupo().equals(tecnico)) {
        subgrupo.add(u);
      }
    }
    return subgrupo;
    
  }

  public static Usuario login(String usuario, char[] password) {
    Usuario unUsuario = Usuarios.buscarPorNombre(usuario);
    if (unUsuario!=null) {
      if (password.length == unUsuario.getPassword().length) {
        if (Arrays.equals(unUsuario.getPassword() , password)) {
          return unUsuario;
        }
      }
    }
    return null;
  }



}
