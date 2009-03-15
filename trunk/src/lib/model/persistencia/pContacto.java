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
public class pContacto {
  public static final String TABLA = "contacto";
  /**
   * Nombre de campo en la base de datos para el ID
   */
  public static final String ID = "id";
  public static final String RECIBIDO = "recibido_el";
  public static final String ASIGNADO = "asignado_el";
  public static final String NUMERO_ENTRANTE = "numero_entrante";
  public static final String DESC = "descripcion";
  public static final String RESOLUCION = "resolucion";
  public static final String ESTADO = "id_estado_contacto";
  public static final String TIPO = "id_tipo_contacto";
  public static final String CLIENTE = "id_cliente";
  public static final String PRIORIDAD = "id_prioridad";
  public static final String TECNICO = "id_tecnico";
  public static final String TELEFONISTA = "id_telefonista";

  public static ArrayList<Contacto> listarPorFechaSinAsignar() {
    ArrayList listaContactos = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pContacto.TABLA+" ORDER BY "+pContacto.ASIGNADO+", "+pContacto.RECIBIDO);
        while (rs.next()) {
          Contacto unContacto = pContacto.toContacto(rs);
          listaContactos.add(unContacto);
        }
        Access.desconectar(con);
        return listaContactos;
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
   * Convierte un ResultSet específico en un objeto de tipo Contacto
   * en base a los campos definidos
   *
   * @parm rs ResultSet definido
   */
  private static Contacto toContacto(ResultSet rs) {
    try {
      Contacto unContacto = new Contacto();
      unContacto.setId(rs.getInt(pContacto.ID));
      unContacto.setAsignadoEl(rs.getTimestamp(pContacto.ASIGNADO));
      unContacto.setCliente(pCliente.buscarPorId(rs.getInt(pContacto.CLIENTE)));
      unContacto.setDesc(rs.getString(pContacto.DESC));
      unContacto.setEstadoContacto(pEstadoContacto.buscarPorId(rs.getInt(pContacto.ESTADO)));
      unContacto.setNumeroEntrante(rs.getString(pContacto.NUMERO_ENTRANTE));
      unContacto.setPrioridad(pPrioridad.buscarPorId(rs.getInt(pContacto.PRIORIDAD)));
      unContacto.setRecibidoEl(rs.getTimestamp(pContacto.RECIBIDO));
      unContacto.setResolucion(rs.getString(pContacto.RESOLUCION));
      unContacto.setTecnico(pUsuario.buscarPorId(rs.getInt(pContacto.TECNICO)));
      unContacto.setTelefonista(pUsuario.buscarPorId(rs.getInt(pContacto.TELEFONISTA)));
      unContacto.setTipoContacto(pTipoContacto.buscarPorId(rs.getInt(pContacto.TIPO)));
      return unContacto;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }
  public static ArrayList<Contacto> listar() {
    ArrayList listaContactos = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pContacto.TABLA);
        while (rs.next()) {
          Contacto unContacto = pContacto.toContacto(rs);
          listaContactos.add(unContacto);
        }
        Access.desconectar(con);
        return listaContactos;
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

  public static Object buscarPorId(Integer id) {
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pContacto.TABLA+" WHERE "+pContacto.ID+" = "+id);
        if (!rs.next()) {
        Access.desconectar(con);
          return null;
        }
        Contacto unContacto = pContacto.toContacto(rs);
        if (rs.next()) {
        Access.desconectar(con);
          return null;
        }
        Access.desconectar(con);
        return unContacto;
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

  public static Integer guardar(Contacto unContacto) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pContacto.buscarPorId(unContacto.getId())==null) {
          stmt = con.prepareStatement("INSERT INTO "+pContacto.TABLA+" ("
                  +pContacto.ASIGNADO+", "
                  +pContacto.CLIENTE+", "
                  +pContacto.DESC+", "
                  +pContacto.ESTADO+", "
                  +pContacto.NUMERO_ENTRANTE+", "
                  +pContacto.PRIORIDAD+", "
                  +pContacto.RECIBIDO+", "
                  +pContacto.RESOLUCION+", "
                  +pContacto.TECNICO+", "
                  +pContacto.TELEFONISTA+", "
                  +pContacto.TIPO
                  + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        }
        else {
          stmt = con.prepareStatement("UPDATE "+pContacto.TABLA+" SET "
                  +pContacto.ASIGNADO+"= ?,"
                  +pContacto.CLIENTE+"= ?,"
                  +pContacto.DESC+"= ?,"
                  +pContacto.ESTADO+"= ?,"
                  +pContacto.NUMERO_ENTRANTE+"= ?,"
                  +pContacto.PRIORIDAD+"= ?,"
                  +pContacto.RECIBIDO+"= ?,"
                  +pContacto.RESOLUCION+"= ?,"
                  +pContacto.TECNICO+"= ?,"
                  +pContacto.TELEFONISTA+"= ?,"
                  +pContacto.TIPO+"= ?"
                  +" WHERE "+pContacto.ID+"= ?");
          stmt.setInt(12, unContacto.getId());
        }
        stmt.setTimestamp(1, unContacto.getAsignadoEl());
        stmt.setInt(2, unContacto.getCliente().getId());
        stmt.setString(3, unContacto.getDesc());
        stmt.setInt(4, unContacto.getEstadoContacto().getId());
        stmt.setString(5, unContacto.getNumeroEntrante());
        if (unContacto.getTecnico()!=null) {
          stmt.setInt(6, unContacto.getPrioridad().getId());
        }
        else {
          stmt.setInt(6, -1);
        }
        stmt.setTimestamp(7, unContacto.getRecibidoEl());
        stmt.setString(8, unContacto.getResolucion());
        if (unContacto.getTecnico()!=null) {
          stmt.setInt(9, unContacto.getTecnico().getId());
        }
        else {
          stmt.setInt(9, -1);
        }
        stmt.setInt(10, unContacto.getTelefonista().getId());
        stmt.setInt(11, unContacto.getTipoContacto().getId());
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

  public static boolean borrar(Contacto unContacto) {
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        if (pContacto.buscarPorId(unContacto.getId())!=null) {
          stmt = con.prepareStatement("DELETE FROM "+pContacto.TABLA+" WHERE "+pContacto.TABLA+" = ?");
          stmt.setInt(1, unContacto.getId());
          stmt.executeUpdate();
        }
        Access.desconectar(con);
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
