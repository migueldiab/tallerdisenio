/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.miCRM;

import lib.model.persistencia.pUsuario;

/**
 *
 * @author Administrator
 */
public class Usuario {

    private Integer id;
    private char[] password;
    private String nombre;
    private Grupo grupo;

  public boolean borrar() {
    if (pUsuario.borrar(this)) {
      return true;
    }
    return false;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  public boolean guardar() {
    Integer id = pUsuario.guardar(this);
    if (id!=-1) {
      return true;
    }
    return false;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the grupo
   */
  public Grupo getGrupo() {
    return grupo;
  }

  /**
   * @param grupo the grupo to set
   */
  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }

  /**
   * @return the password
   */
  public char[] getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(char[] password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object obj) {
    try {
      Usuario unUsuario = (Usuario) obj;
      if (this.getId().equals(unUsuario.getId())) {
        return true;
      }
      else {
        return false;
      }
    } catch (Exception e) {
      System.out.println(e.toString());
      return false;
    }
  }

  @Override
  public String toString() {
    return this.getNombre()+" ("+this.getId()+")";
  }

}
