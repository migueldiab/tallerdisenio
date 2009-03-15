/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import lib.model.miCRM.*;
import lib.model.persistencia.pContacto;
import miCrm.Conf;

/**
 *
 * @author Administrator
 */
public class Contactos {

  public static ArrayList<Contacto> listar() {
    return pContacto.listar();
  }

  public static ArrayList<Contacto> listarContactosPorTecnicoPorEstado(Usuario tecnico, EstadoContacto estado) {
    ArrayList<Contacto> contactos = pContacto.listarPorFechaPorEstado(estado.getId());
    ArrayList<Contacto> contactosPorTecnico = new ArrayList<Contacto>();
    for (Contacto c : contactos) {
      if (tecnico.equals(c.getTecnico())) {
        contactosPorTecnico.add(c);
      }
    }
    return contactosPorTecnico;
  }

  public static ArrayList<Contacto> listarContactosPorTecnicoSinFinalizar(Usuario tecnico) {
    ArrayList<Contacto> contactosSinFinalizar = pContacto.listarPorFechaEstadoDistintoDe(Conf.ESTADO_FINALIZADO.getId());
    ArrayList<Contacto> contactosPorTecnico = new ArrayList<Contacto>();
    for (Contacto c : contactosSinFinalizar) {
      if (tecnico.equals(c.getTecnico())) {
        contactosPorTecnico.add(c);
      }
    }
    return contactosPorTecnico;
  }

  public static ArrayList<Contacto> listarContactosRangoFecha(Timestamp inicio, Timestamp fin) {
    return pContacto.listarContactosRangoFecha(inicio, fin);
    
  }

  public static ArrayList<Contacto> listarPorFechaSinAsignar() {
    return pContacto.listarPorFechaSinAsignar();
  }

  public static Hashtable<Usuario, Integer> listarRankingTecnicos(Timestamp inicio, Timestamp fin, EstadoContacto estado) {
    return pContacto.listarRankingTecnicosPorFechaPorEstado(inicio, fin, estado);
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
  public static Integer guardar(Contacto unContacto) {
    return pContacto.guardar(unContacto);
  }


}
