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
  public static final String TABLA = "compuestos";
  public static final String PADRE = "id_articulo";
  public static final String COMPONENTE = "id_componente";
  public static final String CANTIDAD = "cantidad";

  public static boolean borrar(Articulo unComponente, Articulo padre) {
    try {
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM "+pComponente.TABLA+" WHERE "
                + pComponente.PADRE+" = ?, "
                + pComponente.COMPONENTE+" = ?");
        stmt.setInt(1, padre.getId());
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

  public static boolean guardar(Articulo unComponente, Articulo padre) {
    try {      
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO "+pComponente.TABLA+" SET "+pComponente.PADRE+" = ?, "+pComponente.COMPONENTE+" = ?, "+pComponente.CANTIDAD+" = ?, ");
        stmt.setInt(1, padre.getId());
        stmt.setInt(2, unComponente.getId());
        //stmt.setInt(3, unComponente.getCantidad());
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
  private static Articulo toComponente(ResultSet rs) {
    try {
      Articulo unComponente = pArticulo.buscarPorId(rs.getInt(pComponente.COMPONENTE));
      //unComponente.setCantidad(rs.getInt(pComponente.CANTIDAD));
      return unComponente;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  
  public static ArrayList buscarPorArticulo(Articulo unArticulo) {
    ArrayList<Articulo> listaComponentes = new ArrayList<Articulo>();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pComponente.TABLA+" WHERE id_articulo = "+unArticulo.getId());
        while (rs.next()) {
          Articulo unComponente = pComponente.toComponente(rs);
          listaComponentes.add(unComponente);
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
