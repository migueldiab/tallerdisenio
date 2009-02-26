/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.ArrayList;
import lib.model.miCRM.*;
import lib.model.persistencia.pCliente;

/**
 *
 * @author Administrator
 */
public class Clientes implements Servicios {

  public ArrayList listar() {
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    return listaClientes;
  }
  public Object buscarPorId(Integer id) {
    return pCliente.buscarPorId(id);
  }
  public ArrayList buscarPorNombre(String nombre) {
    return pCliente.buscarPorNombre(nombre);
  }
   public static boolean borrar(Cliente unCliente) {
    if (pCliente.borrar(unCliente)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(Cliente unCliente) {
    if (pCliente.guardar(unCliente)) {
      return true;
    }
    return false;
  }

}
