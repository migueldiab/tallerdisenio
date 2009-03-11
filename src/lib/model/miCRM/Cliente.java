/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

import lib.model.persistencia.pCliente;

/**
 *
 * @author Administrator
 */
public class Cliente {
  private Integer id;
  private String nombre;
  private String apellido;
  private String telefono;
  private String direccion;

  public boolean borrar() {
    if (pCliente.borrar(this)) {
      return true;
    }
    return false;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  public boolean guardar() {    
    Integer id = pCliente.guardar(this);
    if (id!=-1) {
      return true;
    }
    return false;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the apellido
   */
  public String getApellido() {
    return apellido;
  }

  /**
   * @param apellido the apellido to set
   */
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  /**
   * @return the telefono
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * @param telefono the telefono to set
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * @return the direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  @Override
  public boolean equals(Object obj) {
    try {
      Cliente unCliente = (Cliente) obj;
      if (this.getId().equals(unCliente.getId())) {
        return true;
      }
      else {
        return false;
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      return false;
    }
  }

  @Override
  public String toString() {
    return this.getNombre()+" ("+this.getId()+")";
  }

}
