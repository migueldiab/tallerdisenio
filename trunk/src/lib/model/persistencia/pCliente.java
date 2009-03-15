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
  public static final String TABLA = "cliente";

  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";
  /**
   * Nombre de campo en la base de datos para el Nombre
   */
  public static final String NOMBRE = "nombre";
  public static final String APELLIDO = "apellido";
  public static final String TELEFONO = "telefono";
  public static final String DIRECCION = "direccion";

  public static ArrayList<Cliente> buscarPorApellidoNombre(String nombre, String apellido) {
    ArrayList listaClientes = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM "+pCliente.TABLA+" WHERE "+pCliente.NOMBRE+" LIKE '"+nombre+"%' AND "+pCliente.APELLIDO+" LIKE '"+apellido+"%'";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
          Cliente unCliente = pCliente.toCliente(rs);
          listaClientes.add(unCliente);
        }
        Access.desconectar(con);
        return listaClientes;
      } catch (Exception e) {
        System.out.println(e.toString());
        Access.desconectar(con);
        return null;
      }
    }
    else {
      return null;
    }
  }

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
      unCliente.setApellido(rs.getString(pCliente.APELLIDO));
      unCliente.setTelefono(rs.getString(pCliente.TELEFONO));
      unCliente.setDireccion(rs.getString(pCliente.DIRECCION));
      return unCliente;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  @SuppressWarnings("unchecked")
  public static ArrayList listar() {
    ArrayList listaClientes = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pCliente.TABLA);
        while (rs.next()) {
          Cliente unCliente = pCliente.toCliente(rs);
          listaClientes.add(unCliente);
        }
        Access.desconectar(con);
        return listaClientes;
      } catch (Exception e) {
        System.out.println(e.toString());
        Access.desconectar(con);
        return null;
      }
    }
    else {
      return null;
    }
  }

  public static Cliente buscarPorId(Integer id) {
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pCliente.TABLA+" WHERE "+pCliente.ID+" = "+id);
        if (!rs.next()) {
        Access.desconectar(con);
          return null;
        }
        Cliente unCliente = pCliente.toCliente(rs);
        if (rs.next()) {
        Access.desconectar(con);
          return null;
        }
        Access.desconectar(con);
        return unCliente;
      } catch (Exception e) {
        System.out.println(e.toString());
        Access.desconectar(con);
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
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pCliente.TABLA+" WHERE "+pCliente.NOMBRE+" LIKE '"+nombre+"%'");
        while (rs.next()) {
          Cliente unCliente = pCliente.toCliente(rs);
          listaClientes.add(unCliente);
        }
        Access.desconectar(con);
        return listaClientes;
      } catch (Exception e) {
        System.out.println(e.toString());
        Access.desconectar(con);
        return null;
      }
    }
    else {
      return null;
    }
  }

  public static Integer guardar(Cliente unCliente) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pCliente.buscarPorId(unCliente.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pCliente.TABLA+" ("
                  + pCliente.NOMBRE+", "
                  + pCliente.APELLIDO+", "
                  + pCliente.DIRECCION+", "
                  + pCliente.TELEFONO
                  +") VALUES (?, ?, ?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pCliente.TABLA+" SET "
                  + pCliente.NOMBRE+" = ? ,"
                  + pCliente.APELLIDO+" = ? ,"
                  + pCliente.DIRECCION+" = ? ,"
                  + pCliente.TELEFONO+" = ? "
                  + "WHERE "+pCliente.ID+" = ?");
          stmt.setInt(5, unCliente.getId());
        }
        stmt.setString(1, unCliente.getNombre());
        stmt.setString(2, unCliente.getApellido());
        stmt.setString(3, unCliente.getDireccion());
        stmt.setString(4, unCliente.getTelefono());
        stmt.executeUpdate();

        Integer id = Access.ultimoId(con);
        Access.desconectar(con);
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

  public static boolean borrar(Cliente unCliente) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pCliente.buscarPorId(unCliente.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pCliente.TABLA+" WHERE "+pCliente.ID+" = ?");
          stmt.setInt(1, unCliente.getId());
          stmt.executeUpdate();
        }
        Access.desconectar(con);
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
