/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.EstadoContacto;
import lib.model.persistencia.pEstadoContacto;

/**
 *
 * @author Administrator
 */
public class Estados {
  public static ArrayList<EstadoContacto> listar() {
    return pEstadoContacto.listar();
  }
  public static Object buscarPorId(Integer id) {
    return pEstadoContacto.buscarPorId(id);
  }
  public static ArrayList<EstadoContacto> buscarPorNombre(String nombre) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  public static boolean borrar(EstadoContacto unEstadoContacto) {
    if (pEstadoContacto.borrar(unEstadoContacto)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(EstadoContacto unEstadoContacto) {
    if (pEstadoContacto.guardar(unEstadoContacto)) {
      return true;
    }
    return false;
  }
}
