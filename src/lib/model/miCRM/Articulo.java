/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Articulo {
  private Integer id;
  private String nombre;
  private Double costo;
  private ArrayList<Componente> componentes;


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
   * @return the costo
   */
  public Double getCosto() {
    return costo;
  }

  /**
   * @param costo the costo to set
   */
  public void setCosto(Double costo) {
    this.costo = costo;
  }

  /**
   * @return the componentes
   */
  public ArrayList<Componente> getComponentes() {
    return componentes;
  }

  public boolean agregarComponente(Componente componente) {
    if (this.componentes.add(componente)) {
      return true;
    }
    else {
      return false;
    }
  }
  
}
