/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.model.servicios;

import java.util.Observable;

/**
 *
 * @author Administrator
 */
public class ModeloContactos extends Observable {
  public void cambioContactos(){
		setChanged();
		notifyObservers();
	}
}
