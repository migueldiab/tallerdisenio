/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.TipoContacto;
import lib.model.persistencia.pTipoContacto;

/**
 *
 * @author Administrator
 */
public class TiposContactos {
  public static ArrayList<TipoContacto> listar() {
    return pTipoContacto.listar();
  }
  public static TipoContacto buscarPorId(Integer id) {
    return pTipoContacto.buscarPorId(id);
  }
  public static ArrayList<TipoContacto> buscarPorNombre(String nombre) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  public static boolean borrar(TipoContacto unTipoContacto) {
    if (pTipoContacto.borrar(unTipoContacto)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(TipoContacto unTipoContacto) {
    if (pTipoContacto.guardar(unTipoContacto)) {
      return true;
    }
    return false;
  }
}
