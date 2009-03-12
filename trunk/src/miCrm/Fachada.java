/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm;

import java.util.ArrayList;
import lib.model.miCRM.*;
import lib.model.persistencia.pGrupo;
import lib.model.servicios.*;

/**
 *
 * @author Administrator
 */
public class Fachada {

  public static Articulo buscarArticuloPorId(int id) {
    return Articulos.buscarPorId(id);
  }

  public static Cliente buscarClientePorId(int id) {
    return Clientes.buscarPorId(id);
  }

  public static Grupo buscarGrupoPorId(int id) {
    return Grupos.buscarPorId(id);
  }

  public static Grupo buscarGrupoPorNombre(String nombre) {
    return Grupos.buscarPorNombre(nombre);
  }

  public static Prioridad buscarPrioridadPorId(int id) {
    return Prioridades.buscarPorId(id);
  }

  public static Usuario buscarUsuarioPorId(int id) {
    return Usuarios.buscarPorId(id);
  }

  public static ArrayList<Articulo> listarArticulos() {
    return Articulos.listar();
  }

  public static ArrayList<Cliente> listarClientes() {
    return Clientes.listar();
  }

  public static ArrayList<EstadoContacto> listarEstados() {
    return Estados.listar();
  }

  public static ArrayList<Grupo> listarGrupos() {
    return Grupos.listar();
  }

  public static Iterable<Prioridad> listarPrioridades() {
    return Prioridades.listar();
  }

  public static Iterable<Usuario> listarTecnicos() {
    return Usuarios.listarTecnicos();
  }

  public static ArrayList<TipoContacto> listarTipoContactos() {
    return TiposContactos.listar();
  }

  public static ArrayList<Usuario> listarUsuarios() {
    return Usuarios.listar();
  }

  public static boolean loginUsuario(String usuario, char[] password) {
    return Usuarios.login(usuario, password);
  }

  public static boolean validarComponente(Articulo unArticulo, Articulo unComponente) {
    return Articulos.validarComponente(unArticulo, unComponente);
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
