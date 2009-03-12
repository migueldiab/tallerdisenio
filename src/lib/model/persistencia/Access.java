/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.persistencia;

import java.sql.*;

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
      return con;
    }
    catch (Exception e) {
      System.out.println(e.toString());
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
      return id;
    } catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }
}
