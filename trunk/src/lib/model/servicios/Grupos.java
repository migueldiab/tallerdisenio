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
public class Grupos {

  public static ArrayList listar() {
    return pGrupo.listar();
  }
  public static Grupo buscarPorId(Integer id) {
    return pGrupo.buscarPorId(id);
  }
  public static Grupo buscarPorNombre(String nombre) {
    return pGrupo.buscarPorNombre(nombre);
  }
}
