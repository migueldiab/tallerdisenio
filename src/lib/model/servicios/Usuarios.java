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

  public static Iterable<Usuario> listarTecnicos() {
    ArrayList<Usuario> losUsuarios = pUsuario.listar();
    ArrayList<Usuario> losTecnicos = new ArrayList<Usuario>();
    Grupo tecnico = Fachada.buscarGrupoPorNombre("Técnico");
    for (Usuario u : losUsuarios) {
      if (u.getGrupo().equals(tecnico)) {
        losTecnicos.add(u);
      }
    }
    return losTecnicos;
    
  }

  public static boolean login(String usuario, char[] password) {
    Usuario unUsuario = Usuarios.buscarPorNombre(usuario);
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
