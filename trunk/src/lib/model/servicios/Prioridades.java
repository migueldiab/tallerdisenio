/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.*;
import lib.model.persistencia.pPrioridad;

/**
 *
 * @author Administrator
 */
public class Prioridades {
  
  public ArrayList listar() {
    ArrayList<Prioridades> listaPrioridadess = new ArrayList<Prioridades>();
    return listaPrioridadess;
  }
  public Prioridad buscarPorId(Integer id) {
    return pPrioridad.buscarPorId(id);
  }
  public ArrayList buscarPorNombre(String nombre) {
    return pPrioridad.buscarPorNombre(nombre);
  }
   public static boolean borrar(Prioridad unPrioridad) {
    if (pPrioridad.borrar(unPrioridad)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(Prioridad unPrioridad) {
    if (pPrioridad.guardar(unPrioridad)) {
      return true;
    }
    return false;
  }

}
