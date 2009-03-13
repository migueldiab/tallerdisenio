/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.*;
import lib.model.persistencia.pArticulo;

/**
 *
 * @author Administrator
 */
public class Articulos {

  public static ArrayList<Articulo> listadoCompuestos() {
    ArrayList<Articulo> articulos = listar();
    ArrayList<Articulo> articulosCompuestos = new ArrayList<Articulo>();
    for (Articulo u : articulos) {
        if (u.getComponentes()!=null && u.getComponentes().size()>0) {
            articulosCompuestos.add(u);
        }
    }
    return articulosCompuestos;
  }
  public static ArrayList<Articulo> listar() {
    return pArticulo.listar();
  }
  public static Articulo buscarPorId(Integer id) {
    return pArticulo.buscarPorId(id);
  }
  public static ArrayList buscarPorNombre(String nombre) {
    return pArticulo.buscarPorNombre(nombre);
  }
  public static boolean validarComponente(Articulo unArticulo, Articulo unComponente) {
    if (unComponente.equals(unArticulo)) {
      return false;
    }
    if (unComponente.contarComponentes()>0) {
      ArrayList<Articulo> componentes = unComponente.getComponentes();
      for (Articulo u : componentes) {
        if (u.equals(unArticulo)) {
          return false;
        }
        if (u.contarComponentes()>0) {
          if (!validarComponente(unArticulo, u)) {
            return false;
          }
        }
      }
    }
    return true;
  }

}
