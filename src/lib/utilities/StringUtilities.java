package lib.utilities;

/**
 * Clase con m�todos utilitarios para el manejo de Strings
 * 
 * @author Mart�n Cabrera, Carlos Soderguit,
 *
 */
public class StringUtilities {

	public static final String pad(String texto, int largo)  {
    StringBuffer buffer = new StringBuffer();
    if (texto==null) {
      texto = "-null-";
    }
    buffer.append(texto);
    for (int i = texto.length(); i < largo; i++) {
	      buffer.append(' ');
	   }
    return buffer.toString();
  }
	public static final String padLeft(int param, int length, char pad)
	{
	    StringBuffer buffer = new StringBuffer(length);
	    buffer.append(param);
	    int padLength = length - buffer.length();
	    for (int i = padLength; i > 0; i--) {
	      buffer.insert(0, pad);
	   }
	    return buffer.toString();
	}
	
}
