/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

/**
 *
 * @author Administrator
 */
public class TipoContacto {
  private Integer id;
  private String nombre;
  private Double costo;

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

  @Override
  public boolean equals(Object obj) {
    try {
      TipoContacto unTipoContacto = (TipoContacto) obj;
      if (this.getId().equals(unTipoContacto.getId())) {
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
