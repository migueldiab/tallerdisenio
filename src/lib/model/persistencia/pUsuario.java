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
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pUsuario.TABLA);
        while (rs.next()) {
          Usuario unUsuario = pUsuario.toUsuario(rs);
          listaUsuarios.add(unUsuario);
        }
        Access.desconectar(con);
        return listaUsuarios;
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

  public static Usuario buscarPorId(Integer id) {
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pUsuario.TABLA+" WHERE "+pUsuario.ID+" = "+id);
        if (!rs.next()) {
        Access.desconectar(con);
          return null;
        }
        Usuario unUsuario = pUsuario.toUsuario(rs);
        if (rs.next()) {
        Access.desconectar(con);
          return null;
        }
        Access.desconectar(con);
        return unUsuario;        
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
  public static Usuario buscarPorNombre(String nombre) {
    Usuario unUsuario = null;
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pUsuario.TABLA+" WHERE "+pUsuario.NOMBRE+" = '"+nombre+"'");
        if (rs.next()) {
          unUsuario = pUsuario.toUsuario(rs);          
        }
        if (rs.next()) {
        Access.desconectar(con);
          return null;
        }
        Access.desconectar(con);
        return unUsuario;
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

  public static Integer guardar(Usuario unUsuario) {
    try {
      // No permite agregar un usuario si el grupo no existe
      if (pGrupo.buscarPorId(unUsuario.getGrupo().getId())==null) {
        throw new Exception("El grupo no existe");
      }
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pUsuario.buscarPorId(unUsuario.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pUsuario.TABLA+" ("+
                  pUsuario.NOMBRE+", "+
                  pUsuario.PASSWORD+", "+
                  pUsuario.GRUPO+
                  ") VALUES (?, ?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pUsuario.TABLA+" SET "+
                  pUsuario.NOMBRE+" = ?, "+
                  pUsuario.PASSWORD+" = ?, "+
                  pUsuario.GRUPO+" = ? " +
                  "WHERE "+pUsuario.ID+" = ?");
          stmt.setInt(4, unUsuario.getId());
        }
        stmt.setString(1, unUsuario.getNombre());
        stmt.setString(2, String.valueOf(unUsuario.getPassword()));
        stmt.setInt(3, unUsuario.getGrupo().getId());
        stmt.executeUpdate();
        Integer id = Access.ultimoId(con);
        Access.desconectar(con);
        return id;
      }
      else {
        throw new Exception("No se pudo conectar a la base de datos");
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }

  public static boolean borrar(Usuario unUsuario) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pUsuario.buscarPorId(unUsuario.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pUsuario.TABLA+" WHERE "+pUsuario.ID+" = ?");
          stmt.setInt(1, unUsuario.getId());
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
