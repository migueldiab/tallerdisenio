/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.*;
import lib.model.persistencia.pGrupo;

/**
 *
 * @author Administrator
 */
public class Grupos implements Servicios {

  public ArrayList listar() {
    ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();
    return listaGrupos;
  }
  public Object buscarPorId(Integer id) {
    return pGrupo.buscarPorId(id);
  }
  public ArrayList buscarPorNombre(String nombre) {
    return pGrupo.buscarPorNombre(nombre);
  }
   public static boolean borrar(Grupo unGrupo) {
    if (pGrupo.borrar(unGrupo)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(Grupo unGrupo) {
    if (pGrupo.guardar(unGrupo)) {
      return true;
    }
    return false;
  }

}
