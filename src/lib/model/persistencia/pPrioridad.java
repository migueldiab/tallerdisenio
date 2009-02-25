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
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM prioridad");
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

  public static Object buscarPorId(Integer id) {
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM prioridad WHERE id = "+id);
        rs.next();
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
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM prioridad WHERE nombre LIKE '%"+nombre+"%'");
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

  public static boolean guardar(Object o) {
    try {
      Prioridad unPrioridad = (Prioridad) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pPrioridad.buscarPorId(unPrioridad.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO prioridad (nombre, id) VALUES (?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE prioridad SET nombre = ? WHERE id = ?");
        }
        stmt.setString(1, unPrioridad.getNombre());
        stmt.setInt(2, unPrioridad.getId());
        stmt.executeUpdate();
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

  public static boolean borrar(Object o) {
    try {
      Prioridad unPrioridad = (Prioridad) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pPrioridad.buscarPorId(unPrioridad.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM prioridad WHERE id = ?");
          stmt.setInt(1, unPrioridad.getId());
          stmt.executeUpdate();
        }
        return true;
      }
      else {
        return false;
      }
    } catch (SQLException e) {
      System.out.println(e.toString());
      return false;
    }
  }

}
