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
  public static final String TABLA = "estado_contacto";
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
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pEstadoContacto.TABLA);
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

  public static EstadoContacto buscarPorId(Integer id) {
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pEstadoContacto.TABLA+" WHERE "+pEstadoContacto.ID+" = "+id);
        if (!rs.next()) {
          return null;
        }
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
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pEstadoContacto.TABLA+" WHERE "+pEstadoContacto.NOMBRE+" LIKE '%"+nombre+"%'");
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

  public static boolean guardar(EstadoContacto unEstadoContacto) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pEstadoContacto.buscarPorId(unEstadoContacto.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pEstadoContacto.TABLA+" ("+pEstadoContacto.NOMBRE+") VALUES (?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pEstadoContacto.TABLA+" SET "+pEstadoContacto.NOMBRE+" = ? WHERE "+pEstadoContacto.ID+" = ?");
          stmt.setInt(2, unEstadoContacto.getId());
        }
        stmt.setString(1, unEstadoContacto.getNombre());
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

  public static boolean borrar(EstadoContacto unEstadoContacto) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pEstadoContacto.buscarPorId(unEstadoContacto.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pEstadoContacto.TABLA+" WHERE "+pEstadoContacto.ID+" = ?");
          stmt.setInt(1, unEstadoContacto.getId());
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
