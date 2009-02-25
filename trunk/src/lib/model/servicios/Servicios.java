/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public interface Servicios {
  public ArrayList listar();
  public Object buscarPorId(Integer id);
  public ArrayList buscarPorNombre(String nombre);
  
}
