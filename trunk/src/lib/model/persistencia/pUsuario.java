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
public class pUsuario implements Persistencia {
  public static final String ID = "id";
  public static final String NOMBRE = "nombre";
  public static final String GRUPO = "id_grupo";

  private static Usuario toUsuario(ResultSet rs) {


    try {
      Usuario unUsuario = new Usuario();
      Integer test = null;      
      unUsuario.setId(rs.getInt(pUsuario.ID));
      unUsuario.setNombre(rs.getString(pUsuario.NOMBRE));
      pGrupo unPGrupo = new pGrupo();
      unUsuario.setGrupo((Grupo) unPGrupo.buscarPorId(rs.getInt(pUsuario.GRUPO)));
      return unUsuario;
    } catch (Exception e) {
      return null;
    }
  }

  public ArrayList listar() {
    ArrayList listaUsuarios = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
        while (rs.next()) {
          Usuario unUsuario = pUsuario.toUsuario(rs);
          listaUsuarios.add(unUsuario);
        }
        return listaUsuarios;
      } catch (Exception e) {
        return null;
      }      
    }
    else {
      return null;
    }
  }

  public Object buscarPorId(Integer id) {
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE id = "+id);
        rs.next();
        Usuario unUsuario = pUsuario.toUsuario(rs);
        if (rs.next()) return null;
        return unUsuario;        
      } catch (Exception e) {
        return null;
      }
    }
    else {
      return null;
    }
  }

  public ArrayList buscarPorNombre(String nombre) {
    ArrayList listaUsuarios = new ArrayList();
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE nombre LIKE '%"+nombre+"%'");
        while (rs.next()) {
          Usuario unUsuario = pUsuario.toUsuario(rs);
          listaUsuarios.add(unUsuario);
        }
        return listaUsuarios;
      } catch (Exception e) {
        return null;
      }
    }
    else {
      return null;
    }
  }

  public boolean guardar(Object o) {
    try {
      Usuario unUsuario = (Usuario) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (this.buscarPorId(unUsuario.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO usuario (nombre, id_grupo, id) VALUES (?, ?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE usuario SET nombre = ?, id_grupo = ? WHERE id = ?");
        }
        stmt.setString(1, unUsuario.getNombre());
        stmt.setInt(2, unUsuario.getGrupo().getId());
        stmt.setInt(3, unUsuario.getId());
        stmt.executeUpdate();
        return true;
      }
      else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }

  public boolean borrar(Object o) {
    try {
      Usuario unUsuario = (Usuario) o;
      Connection con=ConnectDB.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (this.buscarPorId(unUsuario.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
          stmt.setInt(1, unUsuario.getId());
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
