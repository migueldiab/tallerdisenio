/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

/**
 *
 * @author Administrator
 */
public class Articulo {
  private Integer id;
  private String nombre;
  private Articulo padre;
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
   * @return the padre
   */
  public Articulo getPadre() {
    return padre;
  }

  /**
   * @param padre the padre to set
   */
  public void setPadre(Articulo padre) {
    this.padre = padre;
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
  
}