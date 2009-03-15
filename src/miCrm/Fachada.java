/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm;

import java.util.ArrayList;
import lib.model.miCRM.*;
import lib.model.miCRM.Usuario;
import lib.model.servicios.*;

/**
 *
 * @author Administrator
 */
public class Fachada {

  public static Articulo buscarArticuloPorId(int id) {
    return Articulos.buscarPorId(id);
  }

  public static ArrayList<Cliente> buscarClientePorApellidoNombre(String nombre, String apellido) {
    return Clientes.buscarPorApellidoNombre(nombre, apellido);
  }

  public static Cliente buscarClientePorId(int id) {
    return Clientes.buscarPorId(id);
  }

  public static ArrayList<Cliente> buscarClientePorNombre(String nombre) {
    return Clientes.buscarPorNombre(nombre);
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

  public static Prioridad buscarPrioridadPorNombre(String nombre) {
    return Prioridades.buscarPorNombre(nombre);
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

  public static ArrayList<Contacto> listarContactos() {
    return Contactos.listar();
  }

  public static ArrayList<Contacto> listarContactosPorFechaSinAsignar() {
    return Contactos.listarPorFechaSinAsignar();
  }

  public static ArrayList<Contacto> listarContactosPorTecnicoSinFinalizar(Usuario tecnico) {
    return Contactos.listarContactosPorTecnicoSinFinalizar(tecnico);
  }

  public static ArrayList<EstadoContacto> listarEstados() {
    return Estados.listar();
  }

  public static ArrayList<Grupo> listarGrupos() {
    return Grupos.listar();
  }

  public static ArrayList<Prioridad> listarPrioridades() {
    return Prioridades.listar();
  }

  public static ArrayList<Usuario> listarTecnicos() {
    return Usuarios.listarPorGrupo("Técnico");
  }

  public static ArrayList<Usuario> listarTelefonistas() {
    return Usuarios.listarPorGrupo("Telefonista");
  }

  public static ArrayList<TipoContacto> listarTipoContactos() {
    return TiposContactos.listar();
  }

  public static ArrayList<Usuario> listarUsuarios() {
    return Usuarios.listar();
  }

  public static Usuario loginUsuario(String usuario, char[] password) {
    return Usuarios.login(usuario, password);
  }

  public static boolean validarComponente(Articulo unArticulo, Articulo unComponente) {
    return Articulos.validarComponente(unArticulo, unComponente);
  }

  static EstadoContacto buscarEstadoPorNombre(String nombre) {
    return Estados.buscarPorNombre(nombre);
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
