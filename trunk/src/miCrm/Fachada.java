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

  public static boolean borrarArticulo(Articulo unArticulo) {
    return Articulos.borrar(unArticulo);
  }

  public static boolean borrarCliente(Cliente unCliente) {
    return Clientes.borrar(unCliente);
  }

  public static boolean borrarGrupo(Grupo unGrupo) {
    return Grupos.borrar(unGrupo);
  }

  public static boolean borrarPrioridad(Prioridad unPrioridad) {
    return Prioridades.borrar(unPrioridad);
  }

  public static boolean borrarUsuario(Usuario unUsuario) {
    return Usuarios.borrar(unUsuario);
  }

  public static Articulo buscarArticuloPorId(int id) {
    return Articulos.buscarPorId(id);
  }

  public static Cliente buscarClientePorId(int id) {
    return Clientes.buscarPorId(id);
  }

  public static Grupo buscarGrupoPorId(int id) {
    return Grupos.buscarPorId(id);
  }

  public static Prioridad buscarPrioridadPorId(int id) {
    return Prioridades.buscarPorId(id);
  }

  public static Usuario buscarUsuarioPorId(int id) {
    return Usuarios.buscarPorId(id);
  }

  public static boolean guardarArticulo(Articulo u) {
    return Articulos.guardar(u);
  }

  public static boolean guardarCliente(Cliente u) {
    return Clientes.guardar(u);
  }

  public static boolean guardarGrupo(Grupo unGrupo) {
    return Grupos.guardar(unGrupo);
  }

  public static boolean guardarPrioridad(Prioridad u) {
    return Prioridades.guardar(u);
  }

  public static boolean guardarUsuario(Usuario unUsuario) {
    return Usuarios.guardar(unUsuario);
  }

  public static ArrayList<Articulo> listarArticulos() {
    return Articulos.listar();
  }

  public static ArrayList<Cliente> listarClientes() {
    return Clientes.listar();
  }

  public static ArrayList<Grupo> listarGrupos() {
    return Grupos.listar();
  }

  public static Iterable<Prioridad> listarPrioridades() {
    return Prioridades.listar();
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
