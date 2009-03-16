/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.utilities;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class OrdenadorHashtablePorValor implements Comparator {

  public OrdenadorHashtablePorValor() {
     super();
  }

  public int compare(Object obj1, Object obj2){

  int result=0;Map.Entry e1 = (Map.Entry)obj1 ;

  Map.Entry e2 = (Map.Entry)obj2 ;//Sort based on values.

  Integer value1 = (Integer)e1.getValue();
  Integer value2 = (Integer)e2.getValue();

  if(value1.compareTo(value2)==0){

  String word1=(String)e1.getKey().toString();
  String word2=(String)e2.getKey().toString();

  //Sort String in an alphabetical order
  result=word1.compareToIgnoreCase(word2);

  } else{
  //Sort values in a descending order
  result=value2.compareTo( value1 );
  }

  return result;
  }

}
