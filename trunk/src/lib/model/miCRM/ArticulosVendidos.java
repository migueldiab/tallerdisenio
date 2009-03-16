/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

/**
 *
 * @author Administrator
 */
public class ArticulosVendidos {
  private Articulo articulo = null;
  private Integer cantidad = 0;

  public ArticulosVendidos(Articulo unArticulo, Integer cantidad) {
    this.setArticulo(unArticulo);
    this.setCantidad(cantidad);
  }

  public void agregar() {
    this.cantidad++;
  }

  /**
   * @return the unArticulo
   */
  public Articulo getArticulo() {
    return articulo;
  }

  public void quitar() {
    if (cantidad>0)
      this.cantidad--;    
  }

  /**
   * @param unArticulo the unArticulo to set
   */
  public void setArticulo(Articulo unArticulo) {
    this.articulo = unArticulo;
  }

  /**
   * @return the cantidad
   */
  public Integer getCantidad() {
    return cantidad;
  }

  /**
   * @param cantidad the cantidad to set
   */
  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  @Override
  public boolean equals(Object obj) {
    try {
      ArticulosVendidos unArticulo = (ArticulosVendidos) obj;
      if (this.getArticulo().equals(unArticulo.getArticulo())) {
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
    return "("+cantidad.toString()+") "+articulo.toString();
  }

  
}
