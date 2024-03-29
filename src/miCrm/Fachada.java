/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import lib.model.miCRM.*;
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

  public static Contacto buscarContactoPorId(int id) {
    return Contactos.buscarPorId(id);
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

  public static boolean guardarContacto(Contacto c) {
    return Contactos.guardar(c);
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

  public static ArrayList<Contacto> listarContactosPorCliente(Cliente cliente, Timestamp inicio, Timestamp fin) {
    return Contactos.listarContactosPorCliente(cliente, inicio, fin);
  }

  public static ArrayList<Contacto> listarContactosPorFechaSinAsignar() {
    return Contactos.listarPorFechaSinAsignar();
  }

  public static ArrayList<Contacto> listarContactosPorTecnicoPorEstado(Usuario tecnico, EstadoContacto estado) {
    return Contactos.listarContactosPorTecnicoPorEstado(tecnico, estado);
  }

  public static ArrayList<Contacto> listarContactosPorTecnicoSinFinalizar(Usuario tecnico) {
    return Contactos.listarContactosPorTecnicoSinFinalizar(tecnico);
  }

  public static ArrayList<Contacto> listarContactosProblemasSimilares(String text) {
    return Contactos.listarContactosProblemasSimilares(text);
  }

  public static ArrayList<Contacto> listarContactosRangoFecha(Timestamp inicio, Timestamp fin) {
    return Contactos.listarContactosRangoFecha(inicio, fin);
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

  public static Hashtable<Usuario, Integer> listarRankingTecnicos(Timestamp inicio, Timestamp fin, EstadoContacto estado) {
    return Contactos.listarRankingTecnicos(inicio, fin, estado);
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

  static TipoContacto buscarTipoContactoPorNombre(String string) {
    return TiposContactos.buscarPorNombre(string);
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
