/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import lib.model.miCRM.*;
import lib.model.persistencia.pContacto;
import lib.utilities.OrdenadorHashtablePorValor;
import miCrm.Conf;
import miCrm.Inicio;

/**
 *
 * @author Administrator
 */
public class Contactos {
  public static ModeloContactos modContactos = new ModeloContactos();
  
  public static ArrayList<Contacto> listar() {
    return pContacto.listar();
  }

  public static ArrayList<Contacto> listarContactosPorCliente(Cliente cliente, Timestamp inicio, Timestamp fin) {
    ArrayList<Contacto> contactos = pContacto.listarContactosRangoFecha(inicio, fin);
    ArrayList<Contacto> contactosPorCliente = new ArrayList<Contacto>();
    for (Contacto c : contactos) {
      if (cliente.equals(c.getCliente())) {
        contactosPorCliente.add(c);
      }
    }
    return contactosPorCliente;
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

  public static ArrayList<Contacto> listarContactosProblemasSimilares(String text) {
    ArrayList<Contacto> contactos = pContacto.listarPorFechaPorEstado(Conf.ESTADO_FINALIZADO.getId());
    Hashtable<Contacto, Integer> ranking = new Hashtable<Contacto, Integer>();
    
    String[] claves = text.split(" ");
    for (Contacto c : contactos) {
      for (String s : claves) {
        if ((c.getDesc()!=null) && (c.getDesc().toUpperCase().contains(s.toUpperCase()))) {
          Integer rank = ranking.get(c);
          if (rank!=null) {
            rank++;
          }
          else {
            rank = 1;
          }
          ranking.put(c, rank);
        }
        if ((c.getResolucion()!=null) && (c.getResolucion().toUpperCase().contains(s.toUpperCase()))) {
          Integer rank = ranking.get(c);
          if (rank!=null) {
            rank++;
          }
          else {
            rank = 1;
          }
          ranking.put(c, rank);
        }
      }
    }
    ArrayList rankOrdenado=new ArrayList(ranking.entrySet());
    Collections.sort(rankOrdenado, new OrdenadorHashtablePorValor());

    
    return rankOrdenado;

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

  public static Contacto buscarPorId(Integer id) {
    return pContacto.buscarPorId(id);
  }
  public ArrayList buscarPorNombre(String nombre) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  public static boolean borrar(Contacto unContacto) {
    modContactos.cambioContactos();
    if (pContacto.borrar(unContacto)) {
      return true;
    }
    return false;
  }
  public static boolean guardar(Contacto unContacto) {
    Integer autoId = pContacto.guardar(unContacto);
    if (autoId!=-1) {
      unContacto.setId(autoId);
      modContactos.cambioContactos();
      return true;
    }
    return false;
  }
  public static ModeloContactos getObserbavle() {
    return modContactos;
  }
}
