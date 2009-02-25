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
public class pGrupo {
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";
  /**
   * Nombre de campo en la base de datos para el Nombre
   */
  public static final String NOMBRE = "nombre";

  /**
   * Convierte un ResultSet específico en un objeto de tipo Grupo
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static Grupo toGrupo(ResultSet rs) {
    try {      
      Grupo unGrupo = new Grupo();
      unGrupo.setId(rs.getInt(pGrupo.ID));
      unGrupo.setNombre(rs.getString(pGrupo.NOMBRE));
      return unGrupo;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  @SuppressWarnings("unchecked")
  public static ArrayList listar() {
    ArrayList listaGrupos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM grupo");
        while (rs.next()) {
          Grupo unGrupo = pGrupo.toGrupo(rs);
          listaGrupos.add(unGrupo);
        }
        return listaGrupos;
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
        ResultSet rs = stmt.executeQuery("SELECT * FROM grupo WHERE id = "+id);
        rs.next();
        Grupo unGrupo = pGrupo.toGrupo(rs);
        if (rs.next()) {
          return null;
        }
        return unGrupo;
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
    ArrayList listaGrupos = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM grupo WHERE nombre LIKE '%"+nombre+"%'");
        while (rs.next()) {
          Grupo unGrupo = pGrupo.toGrupo(rs);
          listaGrupos.add(unGrupo);
        }
        return listaGrupos;
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
      Grupo unGrupo = (Grupo) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pGrupo.buscarPorId(unGrupo.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO grupo (nombre, id) VALUES (?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE grupo SET nombre = ? WHERE id = ?");
        }
        stmt.setString(1, unGrupo.getNombre());
        stmt.setInt(2, unGrupo.getId());
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
      Grupo unGrupo = (Grupo) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pGrupo.buscarPorId(unGrupo.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM grupo WHERE id = ?");
          stmt.setInt(1, unGrupo.getId());
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
