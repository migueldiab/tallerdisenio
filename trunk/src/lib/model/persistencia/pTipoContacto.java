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
public class pTipoContacto {
  public static final String TABLA = "tipo_contacto";
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";
  /**
   * Nombre de campo en la base de datos para el Nombre
   */
  public static final String NOMBRE = "nombre";

  /**
   * Convierte un ResultSet específico en un objeto de tipo TipoContacto
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static TipoContacto toTipoContacto(ResultSet rs) {
    try {
      TipoContacto unTipoContacto = new TipoContacto();
      unTipoContacto.setId(rs.getInt(pTipoContacto.ID));
      unTipoContacto.setNombre(rs.getString(pTipoContacto.NOMBRE));
      return unTipoContacto;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  @SuppressWarnings("unchecked")
  public static ArrayList listar() {
    ArrayList listaTipoContactos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pTipoContacto.TABLA);
        while (rs.next()) {
          TipoContacto unTipoContacto = pTipoContacto.toTipoContacto(rs);
          listaTipoContactos.add(unTipoContacto);
        }
        return listaTipoContactos;
      } catch (Exception e) {
        System.out.println(e.toString());
        return null;
      }
    }
    else {
      return null;
    }
  }

  public static TipoContacto buscarPorId(Integer id) {
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pTipoContacto.TABLA+" WHERE "+pTipoContacto.ID+" = "+id);
        if (!rs.next()) {
          return null;
        }
        TipoContacto unTipoContacto = pTipoContacto.toTipoContacto(rs);
        if (rs.next()) {
          return null;
        }
        return unTipoContacto;
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
    ArrayList listaTipoContactos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pTipoContacto.TABLA+" WHERE "+pTipoContacto.NOMBRE+" LIKE '%"+nombre+"%'");
        while (rs.next()) {
          TipoContacto unTipoContacto = pTipoContacto.toTipoContacto(rs);
          listaTipoContactos.add(unTipoContacto);
        }
        return listaTipoContactos;
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
      TipoContacto unTipoContacto = (TipoContacto) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pTipoContacto.buscarPorId(unTipoContacto.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pTipoContacto.TABLA+" ("+pTipoContacto.NOMBRE+", "+pTipoContacto.ID+") VALUES (?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pTipoContacto.TABLA+" SET "+pTipoContacto.NOMBRE+" = ? WHERE "+pTipoContacto.ID+" = ?");
        }
        stmt.setString(1, unTipoContacto.getNombre());
        stmt.setInt(2, unTipoContacto.getId());
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
      TipoContacto unTipoContacto = (TipoContacto) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pTipoContacto.buscarPorId(unTipoContacto.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pTipoContacto.TABLA+" WHERE "+pTipoContacto.ID+" = ?");
          stmt.setInt(1, unTipoContacto.getId());
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
