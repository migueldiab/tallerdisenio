/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.*;
import lib.model.persistencia.pContacto;

/**
 *
 * @author Administrator
 */
public class Contactos {

  public ArrayList listar() {
    return pContacto.listar();
  }
  public Object buscarPorId(Integer id) {
    return pContacto.buscarPorId(id);
  }
  public ArrayList buscarPorNombre(String nombre) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  public static boolean borrar(Contacto unContacto) {
    if (pContacto.borrar(unContacto)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(Contacto unContacto) {
    if (pContacto.guardar(unContacto)) {
      return true;
    }
    return false;
  }


}
