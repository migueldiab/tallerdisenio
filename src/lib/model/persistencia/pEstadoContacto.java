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
public class pEstadoContacto {
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";
  /**
   * Nombre de campo en la base de datos para el Nombre
   */
  public static final String NOMBRE = "nombre";

  /**
   * Convierte un ResultSet específico en un objeto de tipo EstadoContacto
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static EstadoContacto toEstadoContacto(ResultSet rs) {
    try {
      EstadoContacto unEstadoContacto = new EstadoContacto();
      unEstadoContacto.setId(rs.getInt(pEstadoContacto.ID));
      unEstadoContacto.setNombre(rs.getString(pEstadoContacto.NOMBRE));
      return unEstadoContacto;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  @SuppressWarnings("unchecked")
  public static ArrayList listar() {
    ArrayList listaEstadoContactos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM estado_contacto");
        while (rs.next()) {
          EstadoContacto unEstadoContacto = pEstadoContacto.toEstadoContacto(rs);
          listaEstadoContactos.add(unEstadoContacto);
        }
        return listaEstadoContactos;
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
        ResultSet rs = stmt.executeQuery("SELECT * FROM estado_contacto WHERE id = "+id);
        rs.next();
        EstadoContacto unEstadoContacto = pEstadoContacto.toEstadoContacto(rs);
        if (rs.next()) {
          return null;
        }
        return unEstadoContacto;
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
    ArrayList listaEstadoContactos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM estado_contacto WHERE nombre LIKE '%"+nombre+"%'");
        while (rs.next()) {
          EstadoContacto unEstadoContacto = pEstadoContacto.toEstadoContacto(rs);
          listaEstadoContactos.add(unEstadoContacto);
        }
        return listaEstadoContactos;
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
      EstadoContacto unEstadoContacto = (EstadoContacto) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pEstadoContacto.buscarPorId(unEstadoContacto.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO estado_contacto (nombre, id) VALUES (?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE estado_contacto SET nombre = ? WHERE id = ?");
        }
        stmt.setString(1, unEstadoContacto.getNombre());
        stmt.setInt(2, unEstadoContacto.getId());
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
      EstadoContacto unEstadoContacto = (EstadoContacto) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pEstadoContacto.buscarPorId(unEstadoContacto.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM estado_contacto WHERE id = ?");
          stmt.setInt(1, unEstadoContacto.getId());
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
