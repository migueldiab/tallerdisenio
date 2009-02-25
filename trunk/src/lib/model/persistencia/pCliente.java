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
public class pCliente {
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";
  /**
   * Nombre de campo en la base de datos para el Nombre
   */
  public static final String NOMBRE = "nombre";

  /**
   * Convierte un ResultSet específico en un objeto de tipo Cliente
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static Cliente toCliente(ResultSet rs) {
    try {
      Cliente unCliente = new Cliente();
      unCliente.setId(rs.getInt(pCliente.ID));
      unCliente.setNombre(rs.getString(pCliente.NOMBRE));
      return unCliente;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  @SuppressWarnings("unchecked")
  public static ArrayList listar() {
    ArrayList listaClientes = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
        while (rs.next()) {
          Cliente unCliente = pCliente.toCliente(rs);
          listaClientes.add(unCliente);
        }
        return listaClientes;
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
        ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE id = "+id);
        rs.next();
        Cliente unCliente = pCliente.toCliente(rs);
        if (rs.next()) {
          return null;
        }
        return unCliente;
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
    ArrayList listaClientes = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE nombre LIKE '%"+nombre+"%'");
        while (rs.next()) {
          Cliente unCliente = pCliente.toCliente(rs);
          listaClientes.add(unCliente);
        }
        return listaClientes;
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
      Cliente unCliente = (Cliente) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pCliente.buscarPorId(unCliente.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO cliente (nombre, id) VALUES (?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE cliente SET nombre = ? WHERE id = ?");
        }
        stmt.setString(1, unCliente.getNombre());
        stmt.setInt(2, unCliente.getId());
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
      Cliente unCliente = (Cliente) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pCliente.buscarPorId(unCliente.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
          stmt.setInt(1, unCliente.getId());
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
