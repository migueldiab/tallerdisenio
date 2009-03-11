/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.persistencia;

import java.sql.*;
import java.util.ArrayList;
import lib.model.miCRM.*;

/**
 *
 * @author Miguel A. Diab
 */
public class pPrioridad {
  public static final String TABLA = "prioridad";
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";
  /**
   * Nombre de campo en la base de datos para el Nombre
   */
  public static final String NOMBRE = "nombre";

  /**
   * Convierte un ResultSet específico en un objeto de tipo Prioridad
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static Prioridad toPrioridad(ResultSet rs) {
    try {
      Prioridad unPrioridad = new Prioridad();
      unPrioridad.setId(rs.getInt(pPrioridad.ID));
      unPrioridad.setNombre(rs.getString(pPrioridad.NOMBRE));
      return unPrioridad;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  @SuppressWarnings("unchecked")
  public static ArrayList listar() {
    ArrayList listaPrioridads = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pPrioridad.TABLA);
        while (rs.next()) {
          Prioridad unPrioridad = pPrioridad.toPrioridad(rs);
          listaPrioridads.add(unPrioridad);
        }
        return listaPrioridads;
      } catch (Exception e) {
        System.out.println(e.toString());
        return null;
      }
    }
    else {
      return null;
    }
  }

  public static Prioridad buscarPorId(Integer id) {
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pPrioridad.TABLA+" WHERE "+pPrioridad.ID+" = "+id);
        if (!rs.next()) {
          return null;
        }
        Prioridad unPrioridad = pPrioridad.toPrioridad(rs);
        if (rs.next()) {
          return null;
        }
        return unPrioridad;
      } catch (Exception e) {
        System.out.println(e.toString());
        return null;
      }
    }
    else {
      return null;
    }
  }

    @SuppressWarnings("unchecked")
  public static ArrayList buscarPorNombre(String nombre) {
    ArrayList listaPrioridads = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pPrioridad.TABLA+" WHERE "+pPrioridad.NOMBRE+" LIKE '%"+nombre+"%'");
        while (rs.next()) {
          Prioridad unPrioridad = pPrioridad.toPrioridad(rs);
          listaPrioridads.add(unPrioridad);
        }
        return listaPrioridads;
      } catch (Exception e) {
        System.out.println(e.toString());
        return null;
      }
    }
    else {
      return null;
    }
  }

  public static Integer guardar(Prioridad unPrioridad) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pPrioridad.buscarPorId(unPrioridad.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pPrioridad.TABLA+" ("+pPrioridad.NOMBRE+") VALUES (?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pPrioridad.TABLA+" SET "+pPrioridad.NOMBRE+" = ? WHERE "+pPrioridad.ID+" = ?");
          stmt.setInt(2, unPrioridad.getId());
        }
        stmt.setString(1, unPrioridad.getNombre());
        stmt.executeUpdate();
        return Access.ultimoId(con);
      }
      else {
        return -1;
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }

  public static boolean borrar(Prioridad unPrioridad) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pPrioridad.buscarPorId(unPrioridad.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pPrioridad.TABLA+" WHERE "+pPrioridad.ID+" = ?");
          stmt.setInt(1, unPrioridad.getId());
          stmt.executeUpdate();
        }
        return true;
      }
      else {
        return false;
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      return false;
    }
  }

}
