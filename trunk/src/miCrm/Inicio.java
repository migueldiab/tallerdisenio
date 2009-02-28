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
      unUsuario.setId(2);
      unUsuario.setNombre("Natalia");
      char[] pass = {'t', 'e', 's', 't'};
      unUsuario.setPassword(pass);
      Grupo unGrupo = new Grupo();
      unGrupo.setId(2);
      unGrupo.setNombre("Telefonista");
      unUsuario.setGrupo(unGrupo);
      if (!Fachada.guardarGrupo(unGrupo)) {
        System.out.println("No se pudo guardar grupo");
        return;
      }
      if (!Fachada.guardarUsuario(unUsuario)) {
        System.out.println("No se pudo guardar usuario");
        return;
      }
      //Fachada.borrarUsuario(unUsuario);
      Login vLogin = new Login();
      vLogin.setVisible(true);
    }
}
