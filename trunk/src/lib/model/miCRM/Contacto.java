/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

import java.util.ArrayList;
import java.sql.Date;
import lib.model.miCRM.Usuario;

/**
 *
 * @author Administrator
 */
public class Contacto {
  private Integer id;
  private Date recibidoEl;
  private Date asignadoEl;
  private String numeroEntrante;
  private String desc;
  private String resolucion;
  private EstadoContacto estadoContacto;
  private TipoContacto tipoContacto;
  private Cliente cliente;
  private Prioridad prioridad;
  private Usuario tecnico;
  private Usuario telefonista;
  private ArrayList<Articulo> articulos;

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the recibidoEl
   */
  public Date getRecibidoEl() {
    return recibidoEl;
  }

  /**
   * @param recibidoEl the recibidoEl to set
   */
  public void setRecibidoEl(Date recibidoEl) {
    this.recibidoEl = recibidoEl;
  }

  /**
   * @return the asignadoEl
   */
  public Date getAsignadoEl() {
    return asignadoEl;
  }

  /**
   * @param asignadoEl the asignadoEl to set
   */
  public void setAsignadoEl(Date asignadoEl) {
    this.asignadoEl = asignadoEl;
  }

  /**
   * @return the numeroEntrante
   */
  public String getNumeroEntrante() {
    return numeroEntrante;
  }

  /**
   * @param numeroEntrante the numeroEntrante to set
   */
  public void setNumeroEntrante(String numeroEntrante) {
    this.numeroEntrante = numeroEntrante;
  }

  /**
   * @return the desc
   */
  public String getDesc() {
    return desc;
  }

  /**
   * @param desc the desc to set
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }

  /**
   * @return the estadoContacto
   */
  public EstadoContacto getEstadoContacto() {
    return estadoContacto;
  }

  /**
   * @param estadoContacto the estadoContacto to set
   */
  public void setEstadoContacto(EstadoContacto estadoContacto) {
    this.estadoContacto = estadoContacto;
  }

  /**
   * @return the tipoContacto
   */
  public TipoContacto getTipoContacto() {
    return tipoContacto;
  }

  /**
   * @param tipoContacto the tipoContacto to set
   */
  public void setTipoContacto(TipoContacto tipoContacto) {
    this.tipoContacto = tipoContacto;
  }

  /**
   * @return the cliente
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * @param cliente the cliente to set
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * @return the prioridad
   */
  public Prioridad getPrioridad() {
    return prioridad;
  }

  /**
   * @param prioridad the prioridad to set
   */
  public void setPrioridad(Prioridad prioridad) {
    this.prioridad = prioridad;
  }

  /**
   * @return the tecnico
   */
  public Usuario getTecnico() {
    return tecnico;
  }

  /**
   * @param tecnico the tecnico to set
   */
  public void setTecnico(Usuario tecnico) {
    this.tecnico = tecnico;
  }

  /**
   * @return the telefonista
   */
  public Usuario getTelefonista() {
    return telefonista;
  }

  /**
   * @param telefonista the telefonista to set
   */
  public void setTelefonista(Usuario telefonista) {
    this.telefonista = telefonista;
  }

  /**
   * @return the articulos
   */
  public ArrayList<Articulo> getArticulos() {
    return articulos;
  }

  /**
   * @param articulos the articulos to set
   */
  public void setArticulos(ArrayList<Articulo> articulos) {
    this.setArticulos(articulos);
  }

  /**
   * @return the resolucion
   */
  public String getResolucion() {
    return resolucion;
  }

  /**
   * @param resolucion the resolucion to set
   */
  public void setResolucion(String resolucion) {
    this.resolucion = resolucion;
  }
}
