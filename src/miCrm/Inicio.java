/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm;

import lib.model.miCRM.*;
import miCrm.vista.*;

/**
 *
 * @author Administrator
 */
public class Inicio {
    public static void main(String[] args) {
      Usuario unUsuario = new Usuario();
      unUsuario.setId(1);
      unUsuario.setNombre("Miguel");
      Grupo unGrupo = new Grupo();
      unGrupo.setId(1);
      unGrupo.setNombre("Admin");
      unUsuario.setGrupo(unGrupo);
      //Fachada.guardarUsuario(unUsuario);
      Fachada.borrarUsuario(unUsuario);
      Login vLogin = new Login();
      vLogin.setVisible(true);
    }
}
