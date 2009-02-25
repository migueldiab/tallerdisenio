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
public class ConnectDB {

  public static Connection conectar() {
    try {      
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");      
      Connection con = DriverManager.getConnection("jdbc:odbc:miCRM","Admin","test123");
      return con;
    }
    catch (Exception e) {
      return null;
    }

  }
}
