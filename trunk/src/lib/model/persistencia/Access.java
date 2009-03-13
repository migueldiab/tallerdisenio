/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.persistencia;

import java.sql.*;
import miCrm.Conf;

/**
 *
 * @author Miguel A. Diab
 */
public class Access {

  public static Connection conectar() {
    try {      
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");      
      String baseAccess = "miCRM.mdb";
      String strcon= "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + baseAccess;
      Connection con = DriverManager.getConnection(strcon);
      if (Conf.DEBUG_MODE) {
        System.out.println(con.toString());
      }
      return con;
    }
    catch (Exception e) {
      System.out.println("No se pudo conectar a la base de datos");
      if (Conf.DEBUG_MODE) {
        System.out.println(e.toString());
      }
      return null;
    }
  }
  public static Integer ultimoId(Connection con) {
    try {
      Integer id = 0;
      Statement stmtId = con.createStatement();
      ResultSet rs = stmtId.executeQuery("SELECT @@Identity");
      while (rs.next()) {
        id = rs.getInt(1);
      }
      if (Conf.DEBUG_MODE) {
        System.out.println("Ultimo ID : "+id);
      }
      return id;
    } catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }
  public static void desconectar(Connection con) {
    try {
      if (Conf.DEBUG_MODE) {
        System.out.println("Cerrando : "+con.toString());
      }
      con.close();
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }
}
