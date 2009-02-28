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
public class pUsuario {
  public static final String TABLA = "usuario";
  public static final String ID = "id";
  public static final String PASSWORD = "password";
  public static final String NOMBRE = "nombre";
  public static final String GRUPO = "id_grupo";

  private static Usuario toUsuario(ResultSet rs) {

    try {
      Usuario unUsuario = new Usuario();
      unUsuario.setId(rs.getInt(pUsuario.ID));
      unUsuario.setNombre(rs.getString(pUsuario.NOMBRE));
      unUsuario.setPassword(rs.getString(pUsuario.PASSWORD).toCharArray());
      pGrupo unPGrupo = new pGrupo();
      unUsuario.setGrupo((Grupo) pGrupo.buscarPorId(rs.getInt(pUsuario.GRUPO)));
      return unUsuario;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }

  @SuppressWarnings("unchecked")
  public static ArrayList<Usuario> listar() {
    ArrayList listaUsuarios = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pUsuario.TABLA);
        while (rs.next()) {
          Usuario unUsuario = pUsuario.toUsuario(rs);
          listaUsuarios.add(unUsuario);
        }
        return listaUsuarios;
      } catch (Exception e) {
        System.out.println(e.toString());
        return null;
      }      
    }
    else {
      return null;
    }
  }

  public static Usuario buscarPorId(Integer id) {
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pUsuario.TABLA+" WHERE "+pUsuario.ID+" = "+id);
        if (!rs.next()) {
          return null;
        }
        Usuario unUsuario = pUsuario.toUsuario(rs);
        if (rs.next()) {
          return null;
        }
        return unUsuario;        
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
    ArrayList listaUsuarios = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pUsuario.TABLA+" WHERE "+pUsuario.NOMBRE+" LIKE '%"+nombre+"%'");
        while (rs.next()) {
          Usuario unUsuario = pUsuario.toUsuario(rs);
          listaUsuarios.add(unUsuario);
        }
        return listaUsuarios;
      } catch (Exception e) {
        System.out.println(e.toString());
        return null;
      }
    }
    else {
      return null;
    }
  }

  public static boolean guardar(Usuario unUsuario) {
    try {
      // No permite agregar un usuario si el grupo no existe
      if (pGrupo.buscarPorId(unUsuario.getGrupo().getId())==null) {
        throw new Exception("El grupo no existe");
      }
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pUsuario.buscarPorId(unUsuario.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pUsuario.TABLA+" ("+pUsuario.NOMBRE+", "+pUsuario.PASSWORD+", "+pUsuario.GRUPO+", "+pUsuario.ID+") VALUES (?, ?, ?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pUsuario.TABLA+" SET "+pUsuario.NOMBRE+" = ?, "+pUsuario.PASSWORD+" = ?, "+pUsuario.GRUPO+" = ? WHERE "+pUsuario.ID+" = ?");
        }
        stmt.setString(1, unUsuario.getNombre());
        stmt.setString(2, String.valueOf(unUsuario.getPassword()));
        stmt.setInt(3, unUsuario.getGrupo().getId());
        stmt.setInt(4, unUsuario.getId());
        stmt.executeUpdate();
        return true;
      }
      else {
        throw new Exception("No se pudo conectar a la base de datos");
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      return false;
    }
  }

  public static boolean borrar(Object o) {
    try {
      Usuario unUsuario = (Usuario) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pUsuario.buscarPorId(unUsuario.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pUsuario.TABLA+" WHERE "+pUsuario.ID+" = ?");
          stmt.setInt(1, unUsuario.getId());
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
