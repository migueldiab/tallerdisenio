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
public class pContacto {
  public static final String TABLA = "contacto";
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";

  /**
   * Convierte un ResultSet específico en un objeto de tipo Contacto
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static Contacto toContacto(ResultSet rs) {
    try {
      Contacto unContacto = new Contacto();
      unContacto.setId(rs.getInt(pContacto.ID));
      return unContacto;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  @SuppressWarnings("unchecked")
  public static ArrayList listar() {
    ArrayList listaContactos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pContacto.TABLA);
        while (rs.next()) {
          Contacto unContacto = pContacto.toContacto(rs);
          listaContactos.add(unContacto);
        }
        return listaContactos;
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
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pContacto.TABLA+" WHERE id = "+id);
        rs.next();
        Contacto unContacto = pContacto.toContacto(rs);
        if (rs.next()) {
          return null;
        }
        return unContacto;
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
      Contacto unContacto = (Contacto) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pContacto.buscarPorId(unContacto.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pContacto.TABLA+" (nombre, id) VALUES (?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pContacto.TABLA+" SET nombre = ? WHERE id = ?");
        }
        stmt.setInt(2, unContacto.getId());
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
      Contacto unContacto = (Contacto) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pContacto.buscarPorId(unContacto.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pContacto.TABLA+" WHERE "+pContacto.TABLA+" = ?");
          stmt.setInt(1, unContacto.getId());
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
