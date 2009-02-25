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
public class pGrupo implements Persistencia {
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
      return null;
    }
  }
  public ArrayList listar() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Object buscarPorId(Integer id) {
    Connection con=ConnectDB.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM grupo WHERE id = "+id);
        rs.next();
        Grupo unGrupo = pGrupo.toGrupo(rs);
        if (rs.next()) return null;
        return unGrupo;
      } catch (Exception e) {
        return null;
      }
    }
    else {
      return null;
    }
  }

  public ArrayList buscarPorNombre(String nombre) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public boolean guardar(Object o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public boolean borrar(Object o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
