/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miCrm.vista;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import lib.model.miCRM.Articulo;

/**
 *
 * @author Miguel A. Diab
 */
class ModeloArbol implements TreeModel {
  private Articulo raiz;

  public ModeloArbol(Articulo r){
    raiz=r;
  }
  public boolean eliminar(Articulo unComponente){
//    Componente padre=raiz.getPadre(unComponente);
//    if(padre!=null){
//      return padre.eliminarComponente(unComponente);
//    }
    return false;
  }
  public Object getChild(Object nodo, int posicion) {
    try {
      Articulo padre = (Articulo) nodo;
      return padre.getHijo(posicion);
    } catch (Exception e) {
      Articulo padre = (Articulo) nodo;
      return padre.getHijo(posicion);
    }
  }

  public int getChildCount(Object n) {
    try {
      Articulo nodo=(Articulo)n;
      return nodo.contarComponentes();
    }
    catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }

  public int getIndexOfChild(Object p, Object hijo) {
    try {
      Articulo padre=(Articulo)p;
      return padre.getPosComponente((Articulo) hijo);
    } catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }

  public Object getRoot() {
    return raiz;
  }

  public boolean isLeaf(Object n) {
    try {
      Articulo nodo=(Articulo)n;
      return nodo.esHoja();

    } catch (Exception e) {
      return false;
    }
  }

  public void removeTreeModelListener(TreeModelListener arg0) {
  }
  public void valueForPathChanged(TreePath arg0, Object arg1) {
  }
  public void addTreeModelListener(TreeModelListener arg0) {
  }

}
