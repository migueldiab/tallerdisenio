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
public class pArticulo {
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";
  /**
   * Nombre de campo en la base de datos para el Nombre
   */
  public static final String NOMBRE = "nombre";

  /**
   * Convierte un ResultSet específico en un objeto de tipo Articulo
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static Articulo toArticulo(ResultSet rs) {
    try {
      Articulo unArticulo = new Articulo();
      unArticulo.setId(rs.getInt(pArticulo.ID));
      unArticulo.setNombre(rs.getString(pArticulo.NOMBRE));
      return unArticulo;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  @SuppressWarnings("unchecked")
  public static ArrayList listar() {
    ArrayList listaArticulos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM articulo");
        while (rs.next()) {
          Articulo unArticulo = pArticulo.toArticulo(rs);
          listaArticulos.add(unArticulo);
        }
        return listaArticulos;
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
        ResultSet rs = stmt.executeQuery("SELECT * FROM articulo WHERE id = "+id);
        rs.next();
        Articulo unArticulo = pArticulo.toArticulo(rs);
        if (rs.next()) {
          return null;
        }
        return unArticulo;
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
    ArrayList listaArticulos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM articulo WHERE nombre LIKE '%"+nombre+"%'");
        while (rs.next()) {
          Articulo unArticulo = pArticulo.toArticulo(rs);
          listaArticulos.add(unArticulo);
        }
        return listaArticulos;
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
      Articulo unArticulo = (Articulo) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pArticulo.buscarPorId(unArticulo.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO articulo (nombre, id) VALUES (?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE articulo SET nombre = ? WHERE id = ?");
        }
        stmt.setString(1, unArticulo.getNombre());
        stmt.setInt(2, unArticulo.getId());
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
      Articulo unArticulo = (Articulo) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pArticulo.buscarPorId(unArticulo.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM articulo WHERE id = ?");
          stmt.setInt(1, unArticulo.getId());
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
