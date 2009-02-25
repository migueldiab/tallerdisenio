/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.persistencia;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public interface Persistencia {
  ArrayList listar();
  Object buscarPorId(Integer id);
  ArrayList buscarPorNombre(String nombre);
  boolean guardar(Object o);
  boolean borrar(Object o);
}
