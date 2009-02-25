/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.Usuario;

/**
 *
 * @author Administrator
 */
public class Articulos implements Servicios {
  
  public ArrayList listar() {
    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    
    return listaUsuarios;

  }

  public Object buscarPorId(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public ArrayList buscarPorNombre(String nombre) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
