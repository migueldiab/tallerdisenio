/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm;

import java.util.ArrayList;
import lib.model.miCRM.*;
import lib.model.servicios.*;

/**
 *
 * @author Administrator
 */
public class Fachada {

  public static boolean borrarUsuario(Usuario unUsuario) {
    return Usuarios.borrar(unUsuario);
  }

  public static boolean guardarGrupo(Grupo unGrupo) {
    return Grupos.guardar(unGrupo);
  }

  public static boolean guardarUsuario(Usuario unUsuario) {
    return Usuarios.guardar(unUsuario);
  }

  public static ArrayList<Grupo> listarGrupos() {
    return Grupos.listar();
  }

  public static ArrayList<Usuario> listarUsuarios() {
    return Usuarios.listar();
  }
  public static boolean loginUsuario(Integer usuario, char[] password) {
    return Usuarios.login(usuario, password);
  }
  
  Fachada fachada = null;
  private Fachada() { }
  public Fachada getInstance() {
    if (this.fachada==null) {
      this.fachada = new Fachada();
    }
    return fachada;
  }

}
