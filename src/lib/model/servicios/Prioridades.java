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
  
  public static ArrayList<Prioridad> listar() {
    return pPrioridad.listar();
  }
  public static Prioridad buscarPorId(Integer id) {
    return pPrioridad.buscarPorId(id);
  }
  public static Prioridad buscarPorNombre(String nombre) {
    return pPrioridad.buscarPorNombre(nombre);
  }
}
