package lib.utilities;

/**
 * Clase con m�todos utilitarios para el manejo de Strings
 * 
 * @author Mart�n Cabrera, Carlos Soderguit,
 *
 */
public class StringUtilities {

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
