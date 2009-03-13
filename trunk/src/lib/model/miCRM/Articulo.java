/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

import java.util.ArrayList;
import lib.model.persistencia.pArticulo;
import lib.model.persistencia.pComponente;
import miCrm.Fachada;

/**
 *
 * @author Administrator
 */
public class Articulo {
  private Integer id;
  private String nombre;
  private Double costo;
  private ArrayList<Articulo> componentes = null;

  public boolean agregarComponente(Articulo unComponente) {
    if (componentes==null) {
      componentes = new ArrayList<Articulo>();      
    }
    if (Fachada.validarComponente(this, unComponente)) {
      if (componentes.add(unComponente)) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }

  public boolean borrar() {
    if (pArticulo.borrar(this)) {
      return true;
    }
    return false;
  }

  public int contarComponentes() {
    if (componentes==null) {
      return 0;
    }
    else {
      return componentes.size();
    }
  }

  public boolean eliminarComponente(Articulo elComponente) {
    if (componentes.indexOf(elComponente)!=-1) {
      if (!componentes.remove(elComponente)) {
        return false;
      }
    }
    else {
      return false;
    }
    if (componentes.size()==0) {
      componentes = null;
    }
    return true;
  }

  public boolean esHoja() {
    if (componentes==null) {
      return true;
    }
    else {
      return false;
    }
  }

  public ArrayList<Articulo> getComponentes() {
    return componentes;
  }

  public Object getHijo(int posicion) {
    if (componentes==null) {
      return null;
    }
    else {
      return componentes.get(posicion);
    }
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  public int getPosComponente(Articulo articulo) {
    if (componentes==null) {
      return -1;
    }
    else {
      return componentes.indexOf(articulo);
    }
  }

    public boolean guardar() {
      Integer autoId = pArticulo.guardar(this);
      if (autoId!=-1) {
        this.setId(autoId);
        return true;
      }
      return false;
    }

  public void remplazarComponentes(ArrayList<Articulo> nuevosComponentes) {
    if (nuevosComponentes!=null) {
      if (componentes == null) {
        componentes = new ArrayList<Articulo>();
      }
      else {
        componentes.clear();
      }
      for (Articulo u : nuevosComponentes) {
        componentes.add(u);
      }
    }
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
      Articulo unArticulo = (Articulo) obj;
      if (this.getNombre().equals(unArticulo.getNombre())) {
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
    return this.getNombre();
  }
  
}


