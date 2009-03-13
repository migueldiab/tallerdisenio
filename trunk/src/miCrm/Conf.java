/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm;

import lib.model.miCRM.EstadoContacto;
import lib.model.miCRM.Prioridad;
import lib.model.miCRM.Usuario;

/**
 *
 * @author Administrator
 */
public class Conf {
    public static final Boolean DEBUG_MODE = false;
    public static final Integer MAX_LEN_DESC = 600;
    public static final EstadoContacto ESTADO_NUEVO_CONTACTO = Fachada.buscarEstadoPorNombre("Pendiente");
    public static final Usuario TECNICO_POR_DEFECTO = null;
    public static final Prioridad PRIORIDAD_POR_DEFECTO = Fachada.buscarPrioridadPorNombre("Media");

}
