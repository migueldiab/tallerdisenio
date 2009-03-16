/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import lib.model.miCRM.*;
import lib.model.servicios.Contactos;

/**
 *
 * @author Miguel A. Diab
 */
public class pContacto {
  public static final String TABLA = "contacto";
  public static final String TABLA_ARTICULOS = "articulo_contacto";
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
  public static final String TIEMPO = "tiempo_resolucion";

  public static final String ARTICULO = "articulo_id";
  public static final String CONTACTO = "contacto_id";
  public static final String CANTIDAD = "cantidad";

  
  public static ArrayList<Contacto> listarContactosRangoFecha(Timestamp inicio, Timestamp fin) {
    ArrayList listaContactos = new ArrayList();
    try {
      Connection con=Access.conectar();
      if (con!=null) {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("SELECT * FROM "+pContacto.TABLA+" WHERE "
                +pContacto.RECIBIDO+" >= ? AND "
                +pContacto.RECIBIDO+" <= ? " +
                "ORDER BY "+pContacto.RECIBIDO
                );
        stmt.setTimestamp(1, inicio);
        stmt.setTimestamp(2, fin);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          Contacto unContacto = pContacto.toContacto(rs);
          listaContactos.add(unContacto);
        }
        Access.desconectar(con);
        return listaContactos;
      }
      else {
        return null;
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }

  public static ArrayList<Contacto> listarPorFechaPorEstado(Integer estado) {
    ArrayList listaContactos = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pContacto.TABLA+" WHERE "+pContacto.ESTADO+" = "+estado+" ORDER BY "+pContacto.RECIBIDO);
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

  public static ArrayList<Contacto> listarPorFechaEstadoDistintoDe(Integer estado) {
    ArrayList listaContactos = new ArrayList();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pContacto.TABLA+" WHERE "+pContacto.ESTADO+" <> "+estado+" ORDER BY "+pContacto.PRIORIDAD);
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

  public static Hashtable<Usuario, Integer> listarRankingTecnicosPorFechaPorEstado(Timestamp inicio, Timestamp fin, EstadoContacto estado) {
    Hashtable<Usuario, Integer> ranking = new Hashtable<Usuario, Integer>();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("SELECT Count(*) AS cantidad, "+pContacto.TECNICO+" FROM "+pContacto.TABLA+
                " WHERE ("+pContacto.ESTADO+"=?) AND " +
                "("+pContacto.RECIBIDO+" >= ?) AND "+
                "("+pContacto.RECIBIDO+" <= ?) "+
                " GROUP BY ("+pContacto.TECNICO+")");
        stmt.setInt(1, estado.getId());
        stmt.setTimestamp(2, inicio);
        stmt.setTimestamp(3, fin);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          Usuario unUsuario = pUsuario.buscarPorId(rs.getInt(pContacto.TECNICO));
          if (unUsuario!=null) {
            Integer casos = rs.getInt("cantidad");
            ranking.put(unUsuario, casos);
          }
        }
        Access.desconectar(con);
        return ranking;
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

  private static ArrayList<ArticulosVendidos> listarArticulosPorContacto(Integer id) {
    ArrayList<ArticulosVendidos> articulosVendidos = new ArrayList<ArticulosVendidos>();
    Connection con=Access.conectar();
    if (con!=null) {
      try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+pContacto.TABLA_ARTICULOS+" WHERE "+pContacto.CONTACTO+"="+id);
        while (rs.next()) {
          ArticulosVendidos unArtVendido = pContacto.toArticuloVendido(rs);
          if (unArtVendido!=null) {
            articulosVendidos.add(unArtVendido);
          }
        }
        Access.desconectar(con);
        if (articulosVendidos.size()>0)
          return articulosVendidos;
        else
          return null;
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

  private static ArticulosVendidos toArticuloVendido(ResultSet rs) {
     try {
      Articulo unArticulo = pArticulo.buscarPorId(rs.getInt(pContacto.ARTICULO));
      Integer cantidad = rs.getInt(pContacto.CANTIDAD);
      ArticulosVendidos unArticulosVendidos = null;
      if (unArticulo!=null) {
        unArticulosVendidos = new ArticulosVendidos(unArticulo, cantidad);
      }
      return unArticulosVendidos;
    } catch (Exception e) {
      System.out.println(e.toString());
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
      unContacto.setTiempoResolucion(rs.getInt(pContacto.TIEMPO));
      unContacto.setArticulos(pContacto.listarArticulosPorContacto(unContacto.getId()));
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

  public static Contacto buscarPorId(Integer id) {
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
                  +pContacto.TIPO+", "
                  +pContacto.TIEMPO
                  + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
                  +pContacto.TIPO+"= ?,"
                  +pContacto.TIEMPO+"= ?"
                  +" WHERE "+pContacto.ID+"= ?");
          stmt.setInt(13, unContacto.getId());
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
        if (unContacto.getTiempoResolucion()!=null) {
          stmt.setInt(12, unContacto.getTiempoResolucion());
        }
        else {
          stmt.setInt(12, 0);
        }
        stmt.executeUpdate();

        if (pContacto.buscarPorId(unContacto.getId())==null) {
          Integer id = Access.ultimoId(con);
          unContacto.setId(id);
        }

        stmt = con.prepareStatement("DELETE FROM "+pContacto.TABLA_ARTICULOS+" WHERE "+
                pContacto.CONTACTO+"= ?");
        stmt.setInt(1, unContacto.getId());
        stmt.executeUpdate();

        if (unContacto.getArticulos()!=null) {
          for (ArticulosVendidos a : unContacto.getArticulos()) {
            stmt = con.prepareStatement("INSERT INTO "+pContacto.TABLA_ARTICULOS+" ("+
                    pContacto.ARTICULO+"," +
                    pContacto.CONTACTO+"," +
                    pContacto.CANTIDAD+")" +
                    "VALUES (?, ?, ?)");
            stmt.setInt(1, a.getArticulo().getId());
            stmt.setInt(2, unContacto.getId());
            stmt.setInt(3, a.getCantidad());
            stmt.executeUpdate();
          }
        }
        Access.desconectar(con);
        return unContacto.getId();
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
