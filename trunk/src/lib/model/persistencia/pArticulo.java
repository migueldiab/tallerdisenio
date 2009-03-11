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
  public static final String TABLA = "articulo";
  public static final String ID = "id";
  public static final String NOMBRE = "nombre";
  public static final String COSTO = "costo";

  
  /**
   * Convierte un ResultSet específico en un objeto de tipo Articulo
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  @SuppressWarnings("unchecked")
  private static Articulo toArticulo(ResultSet rs) {
    try {
      Articulo unArticulo = new Articulo();
      unArticulo.setId(rs.getInt(pArticulo.ID));
      unArticulo.setNombre(rs.getString(pArticulo.NOMBRE));
      unArticulo.setCosto(rs.getDouble(pArticulo.COSTO));
      ArrayList<Articulo> listaComponentes = pComponente.buscarPorArticulo(unArticulo);
      for (Articulo unComponente : listaComponentes) {
        if (unArticulo.agregarComponente(unComponente)) {
          // Todo bien...
        }
        else {
          throw new Exception("Componente Ilegal");
        }
      }
      return unArticulo;
    }
    catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  
  public static ArrayList<Articulo> listar() {
    ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pArticulo.TABLA);
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

  public static Articulo buscarPorId(Integer id) {
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pArticulo.TABLA+" WHERE "+pArticulo.ID+" = "+id);
        // Si no hay resultados
        if (!rs.next()) {
          return null;
        }
        Articulo unArticulo = pArticulo.toArticulo(rs);
        // Si hay mas de un resultado
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
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pArticulo.TABLA+" WHERE "+pArticulo.NOMBRE+" LIKE '%"+nombre+"%'");
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

  public static Integer guardar(Articulo unArticulo) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pArticulo.buscarPorId(unArticulo.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pArticulo.TABLA+" " +
                  "("+pArticulo.NOMBRE+", "+pArticulo.COSTO+")" +
                  " VALUES (?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pArticulo.TABLA+" SET " +
                  pArticulo.NOMBRE+" = ?, "+
                  pArticulo.COSTO+" = ? " +
                  "WHERE "+pArticulo.ID+" = ?");
          stmt.setInt(3, unArticulo.getId());
        }
        stmt.setString(1, unArticulo.getNombre());
        stmt.setDouble(2, unArticulo.getCosto());
        stmt.executeUpdate();

        Integer id = Access.ultimoId(con);

        stmt = con.prepareStatement("DELETE FROM "+pComponente.TABLA+" WHERE "+pComponente.PADRE+" = ?");
        stmt.setInt(1, unArticulo.getId());
        stmt.executeUpdate();

        if (unArticulo.getComponentes()!=null) {
          for (Articulo unComponente : unArticulo.getComponentes()) {
            pComponente.guardar(unComponente, unArticulo);
          }
        }
        return id;
      }
      else {
        return -1;
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }

  public static boolean borrar(Articulo unArticulo) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pArticulo.buscarPorId(unArticulo.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pArticulo.TABLA+" WHERE "+pArticulo.ID+" = ?");
          stmt.setInt(1, unArticulo.getId());
          stmt.executeUpdate();
          if (unArticulo.getComponentes()!=null) {
            for (Articulo unComponente : unArticulo.getComponentes()) {
              if (!pComponente.borrar(unComponente, unArticulo)) {
                throw new Exception("Error al borrar componente");
              }
            }
          }
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
