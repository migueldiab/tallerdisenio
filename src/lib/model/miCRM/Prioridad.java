/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

import lib.model.persistencia.pPrioridad;

/**
 *
 * @author Administrator
 */
public class Prioridad {  
  private Integer id;
  private String nombre;

  public boolean borrar() {
    if (pPrioridad.borrar(this)) {
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
    Integer id = pPrioridad.guardar(this);
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

  @Override
  public boolean equals(Object obj) {
    try {
      Prioridad unPrioridad = (Prioridad) obj;
      if (this.getId().equals(unPrioridad.getId())) {
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
