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
    return null;
  }
  public static int cantidadComponentes()
  {
    return pArticulo.cantidadComponentes();
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
   public static boolean borrar(Articulo unArticulo) {
    if (pArticulo.borrar(unArticulo)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(Articulo unArticulo) {
    if (pArticulo.guardar(unArticulo)) {
      return true;
    }
    return false;
  }

}
