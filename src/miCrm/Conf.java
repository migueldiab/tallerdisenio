/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm;

import lib.model.miCRM.EstadoContacto;
import lib.model.miCRM.Grupo;
import lib.model.miCRM.Prioridad;
import lib.model.miCRM.TipoContacto;
import lib.model.miCRM.Usuario;

/**
 *
 * @author Administrator
 */
public class Conf {
    public static final Boolean DEBUG_MODE = false;
    public static final Integer MAX_LEN_DESC = 600;
    public static final Integer MIN_LEN_RESOLUCION = 10;
    public static final EstadoContacto ESTADO_NUEVO_CONTACTO = Fachada.buscarEstadoPorNombre("Pendiente");
    public static final EstadoContacto ESTADO_ASIGNADO = Fachada.buscarEstadoPorNombre("Asignado");
    public static final EstadoContacto ESTADO_FINALIZADO = Fachada.buscarEstadoPorNombre("Finalizado");
    public static final EstadoContacto ESTADO_EN_PROCESO = Fachada.buscarEstadoPorNombre("En Proceso");
    public static final EstadoContacto ESTADO_EN_VISITA = Fachada.buscarEstadoPorNombre("En Visita");
    public static final Usuario TECNICO_POR_DEFECTO = null;
    public static final Prioridad PRIORIDAD_POR_DEFECTO = null;
    public static final Prioridad PRIORIDAD_BLOQUENATE = Fachada.buscarPrioridadPorNombre("Bloqueante");
    public static final Grupo GRUPO_TELEFONISTA = Fachada.buscarGrupoPorNombre("Telefonista");
    public static final Grupo GRUPO_ADMIN = Fachada.buscarGrupoPorNombre("Administrador");
    public static final Grupo GRUPO_TECNICO = Fachada.buscarGrupoPorNombre("Técnico ");
    public static final TipoContacto TIPO_VISITA = Fachada.buscarTipoContactoPorNombre("Visita Técnica");
    public static final TipoContacto TIPO_CONSULTA = Fachada.buscarTipoContactoPorNombre("Consulta Telefónica");

    private static Usuario usuarioLogueado = null;

    /**
     * @return the usuarioLogueado
     */
    public static Usuario getUsuarioLogueado() {
      return usuarioLogueado;
    }

    /**
     * @param aUsuarioLogueado the usuarioLogueado to set
     */
    public static void setUsuarioLogueado(Usuario aUsuarioLogueado) {
      usuarioLogueado = aUsuarioLogueado;
    }
}
