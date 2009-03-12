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
  public static final String TABLA = "grupo";
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
  public static ArrayList<Grupo> listar() {
    ArrayList listaGrupos = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pGrupo.TABLA);
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

  public static Grupo buscarPorId(Integer id) {
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pGrupo.TABLA+" WHERE "+pGrupo.ID+" = "+id);
        if (!rs.next()) {
          return null;
        }        
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
  public static Grupo buscarPorNombre(String nombre) {
    Grupo unGrupo = null;
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pGrupo.TABLA+" WHERE "+pGrupo.NOMBRE+" = '"+nombre+"'");
        if (rs.next()) {
          unGrupo = pGrupo.toGrupo(rs);
        }
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

  public static Integer guardar(Grupo unGrupo) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pGrupo.buscarPorId(unGrupo.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pGrupo.TABLA+" ("+pGrupo.NOMBRE+") VALUES (?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pGrupo.TABLA+" SET "+pGrupo.NOMBRE+" = ? WHERE "+pGrupo.ID+" = ?");
          stmt.setInt(2, unGrupo.getId());
        }
        stmt.setString(1, unGrupo.getNombre());
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

  public static boolean borrar(Grupo unGrupo) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pGrupo.buscarPorId(unGrupo.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pGrupo.TABLA+" WHERE "+pGrupo.ID+" = ?");
          stmt.setInt(1, unGrupo.getId());
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
