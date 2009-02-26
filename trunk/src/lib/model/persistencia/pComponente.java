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
public class pComponente {
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String TABLA = "componente";
  public static final String PADRE = "id_articulo";
  public static final String COMPONENTE = "id_componente";
  public static final String CANTIDAD = "cantidad";

  public static boolean borrar(Componente unComponente, Articulo unArticulo) {
    try {
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM "+pComponente.TABLA+" WHERE "
                + pComponente.PADRE+" = ?, "
                + pComponente.COMPONENTE+" = ?");
        stmt.setInt(1, unArticulo.getId());
        stmt.setInt(2, unComponente.getId());        
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

  public static boolean guardar(Componente unComponente, Articulo unArticulo) {
    try {      
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO "+pComponente.TABLA+" SET "+pComponente.PADRE+" = ?, "+pComponente.COMPONENTE+" = ?, "+pComponente.CANTIDAD+" = ?, ");
        stmt.setInt(1, unArticulo.getId());
        stmt.setInt(2, unComponente.getId());
        stmt.setInt(3, unComponente.getCantidad());
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

  /**
   * Convierte un ResultSet específico en un objeto de tipo Componente
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static Componente toComponente(ResultSet rs) {
    try {
      Componente unComponente = (Componente) pArticulo.buscarPorId(rs.getInt(pComponente.COMPONENTE));
      unComponente.setCantidad(rs.getInt(pComponente.CANTIDAD));       
      return unComponente;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  
  public static ArrayList buscarPorArticulo(Articulo unArticulo) {
    ArrayList<Componente> listaComponentes = new ArrayList<Componente>();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pComponente.TABLA+" WHERE id_articulo = "+unArticulo.getId());
        while (rs.next()) {
          listaComponentes.add(pComponente.toComponente(rs));
        }        
        return listaComponentes;
      } catch (Exception e) {
        System.out.println(e.toString());
        return null;
      }
    }
    else {
      return null;
    }
  }

  

}
