package lib.utilities;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Utilidades para la manipulaci�n de fechas.
 * 
 * Observaci�n: Todos los m�todos esperan par�metros no nulos y tiran
 * NullPointerException en caso de recibir alguno nulo.
 * 
 * @author Carlos Soderguit, Mart�n Cabrera
 */
public class DateUtilities {

	/** Indica que la fecha se transforme a formato fecha-hora */
	public static final int DATE_TIME_FORMAT = 1;

	/** Indica que la fecha se transforme a formato fecha */
	public static final int DATE_FORMAT = 2;

	/** Indica que la fecha se transforme a formato hora */
	public static final int TIME_FORMAT = 3;

	// Calendario utilizado para los c�lculos en los m�todos.
	private static GregorianCalendar calendar = new GregorianCalendar();
	private static SimpleDateFormat dateTimeFormatter = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat(
			"dd/MM/yyyy");
	private static SimpleDateFormat timeFormatter = new SimpleDateFormat(
			"HH:mm");
	private static int[] dayOfWeekOrdinals = new int[8];
	private static String[] dayOfWeekNames = new String[8];

	// Inicialización estática
	static {
		dayOfWeekOrdinals[Calendar.MONDAY] = 1;
		dayOfWeekOrdinals[Calendar.TUESDAY] = 2;
		dayOfWeekOrdinals[Calendar.WEDNESDAY] = 3;
		dayOfWeekOrdinals[Calendar.THURSDAY] = 4;
		dayOfWeekOrdinals[Calendar.FRIDAY] = 5;
		dayOfWeekOrdinals[Calendar.SATURDAY] = 6;
		dayOfWeekOrdinals[Calendar.SUNDAY] = 7;

		dayOfWeekNames[Calendar.MONDAY] = "LUN";
		dayOfWeekNames[Calendar.TUESDAY] = "MAR";
		dayOfWeekNames[Calendar.WEDNESDAY] = "MIE";
		dayOfWeekNames[Calendar.THURSDAY] = "JUE";
		dayOfWeekNames[Calendar.FRIDAY] = "VIE";
		dayOfWeekNames[Calendar.SATURDAY] = "SAB";
		dayOfWeekNames[Calendar.SUNDAY] = "DOM";

	}

  public static String parseTimestamp(Timestamp value, int format) {
    if (value == null) {
			return null;
		}
    if (format == DATE_TIME_FORMAT) {
      return dateTimeFormatter.format(value);
    }
    if (format == DATE_FORMAT) {
      return dateFormatter.format(value);
    }
    if (format == TIME_FORMAT) {
      return timeFormatter.format(value);
    }
    return null;
  }

  public static java.sql.Date toSQLDate(String string, int tipo) {
    try {
      Date DateAString = toDate(string, tipo);
      //System.out.println(DateAString.getTime());
      java.sql.Date sqlDate = new java.sql.Date(DateAString.getTime());
      //System.out.println(sqlDate.getTime());
      return sqlDate;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }    
  }

	/**
	 * Transforma una fecha a String.
	 * 
	 * @param value
	 *            Valor a transformar.
	 * @param format
	 *            Formato de transformaci�n de la fecha.
	 * 
	 * @return El valor transformado a String.
	 */
	public static String toString(Date value, int format) {
		if (value == null) {
			return null;
		}
		if (format == DATE_TIME_FORMAT) {
			return dateTimeFormatter.format(value);
		}
		if (format == DATE_FORMAT) {
			return dateFormatter.format(value);
		}
		if (format == TIME_FORMAT) {
			return timeFormatter.format(value);
		}
		throw new IllegalArgumentException(
				"[DateUtilities] Formato de fecha inválido");
	}

	/**
	 * Transforma la fecha en formato texto a un objeto Date.
	 * 
	 * @param value
	 *            Valor a transformar.
	 * @param format
	 *            Formato de trasnformaci�n de la fecha.
	 * @return El objeto Date correspondiente.
	 */
	public static Date toDate(String value, int format) {
		if (value == null) {
			return null;
		}
		try {
			if (format == DATE_TIME_FORMAT) {
				return dateTimeFormatter.parse(value);
			}
			if (format == DATE_FORMAT) {
				return dateFormatter.parse(value);
			}
			if (format == TIME_FORMAT) {
				return timeFormatter.parse(value);
			}
		} catch (ParseException pe) {
			throw new IllegalArgumentException(
					"Ocurrió un error al intentar parsear el texto "
							+ value + "\n" + pe.getMessage());
		}
		throw new IllegalArgumentException("Formato de fecha inválido");
	}

	/**
	 * Obtiene la fecha del actual.
	 */
	public static final Date getCurrentDateTime() {
		return new Date();
	}

	/**
	 * Obtiene la fecha del actual sin el componente hora.
	 */
	public static final Date getCurrentDate() {
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * @param date
	 *            Fecha
	 * @return El d�a de la semana que corresponde a la fecha, ver las
	 *         constantes de java.util.Calendar
	 */
	public static final int getDayOfWeek(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * @param date
	 *            Fecha
	 * @return El nombre del d�a de la semana que corresponde a la fecha, ver
	 *         las constantes de java.util.Calendar
	 */
	public static final String getDayOfWeekAsString(Date date) {
		calendar.setTime(date);
		return dayOfWeekNames[calendar.get(Calendar.DAY_OF_WEEK)];
	}

	/**
	 * Obtiene la fecha del sin las horas.
	 */
	public static final Date getDateFromDateTime(Date dateTime) {
		calendar.setTime(dateTime);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * Obtiene una FechaHora a partir de una fecha sin las horas. La hora se
	 * inicializa en 00:00:00.000
	 */
	public static final Date getDateTimeFromDate(Date date) {
		return getDateTimeFromDate(date, false);
	}

	/**
	 * Obtiene una FechaHora a partir de una fecha sin las horas. Si horaMaxima
	 * es true la hora es 23:59:59.999 si no 00:00:00.000
	 */
	public static final Date getDateTimeFromDate(Date date, boolean horaMaxima) {
		calendar.setTime(date);
		if (horaMaxima) {
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MILLISECOND, 999);
		} else {
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
		}
		return calendar.getTime();
	}

	/**
	 * Compara dos fechas. Retorna -1 si la segunda es menor que la primera, 0
	 * si son iguales y 1 si la segunda es mayor que la primera.
	 */
	public static final int compare(Date date1, Date date2) {
		return date2.compareTo(date1);
	}

	/**
	 * Verifica que la segunda fecha sea estrictamente posterior a la primera.
	 */
	public static final boolean after(Date date1, Date date2) {
		return date2.after(date1);
	}

	/**
	 * Verifica que la segunda fecha sea estrictamente anterior a la primera.
	 */
	public static final boolean before(Date date1, Date date2) {
		return date2.before(date1);
	}

	/**
	 * Verifica que las dos fechas sean iguales.
	 */
	public static final boolean equals(Date date1, Date date2) {
		return date2.equals(date1);
	}

	/**
	 * Compara dos fechas. Ignora las componentes de tiempo (horas, minutos,
	 * segundos). Retorna -1 si la segunda es menor que la primera, 0 si son
	 * iguales y 1 si la segunda es mayor que la primera.
	 */
	public static final int compareIgnoreTime(Date date1, Date date2) {
		calendar.setTime(date2);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Date d2 = calendar.getTime();

		calendar.setTime(date1);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Date d1 = calendar.getTime();

		return d2.compareTo(d1);
	}

	/**
	 * Verifica que la segunda fecha sea estrictamente posterior a la primera.
	 * Ignora las componentes de tiempo (horas, minutos, segundos).
	 */
	public static final boolean afterIgnoreTime(Date date1, Date date2) {
		calendar.setTime(date2);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Date d2 = calendar.getTime();

		calendar.setTime(date1);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Date d1 = calendar.getTime();

		return d2.after(d1);
	}

	/**
	 * Verifica que la segunda fecha sea estrictamente anterior a la primera.
	 * Ignora las componentes de tiempo (horas, minutos, segundos).
	 */
	public static final boolean beforeIgnoreTime(Date date1, Date date2) {
		calendar.setTime(date2);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Date d2 = calendar.getTime();

		calendar.setTime(date1);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Date d1 = calendar.getTime();

		return d2.before(d1);
	}

	/**
	 * Verifica que las dos fechas sean iguales. Ignora las componentes de
	 * tiempo (horas, minutos, segundos).
	 */
	public static final boolean equalsIgnoreTime(Date date1, Date date2) {
		calendar.setTime(date2);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Date d2 = calendar.getTime();

		calendar.setTime(date1);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Date d1 = calendar.getTime();

		return d2.equals(d1);
	}

	/**
	 * @return El d�a del mes en formato String(2), p.e. si el d�a es 5 retorna
	 *         el String 05
	 */
	public static final String getDayAsString(Date date) {
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return StringUtilities.padLeft(day, 2, '0');
	}

	/**
	 * @return El mes en formato String(2), p.e. si el mes es 5 retorna el
	 *         String 05
	 */
	public static final String getMonthAsString(Date date) {
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		return StringUtilities.padLeft(month, 2, '0');
	}

	/**
	 * @return El a�o en formato String(4).
	 */
	public static final String getYearAsString(Date date) {
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		StringBuffer buffer = new StringBuffer();
		buffer.append(year);
		return buffer.toString();
	}

	/**
	 * Compara las horas ignorando la fecha. Retorna -1 si la segunda es menor
	 * que la primera, 0 si son iguales y 1 si la segunda es mayor que la
	 * primera.
	 */
	public static final int compareHoursMinutes(Date date1, Date date2) {

		calendar.setTime(date2);
		int hours2 = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes2 = calendar.get(Calendar.MINUTE);

		int absMinutes2 = hours2 * 60 + minutes2;

		calendar.setTime(date1);
		int hours1 = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes1 = calendar.get(Calendar.MINUTE);
		int absMinutes1 = hours1 * 60 + minutes1;

		int ret = 0;
		if (absMinutes1 > absMinutes2) {
			ret = -1;
		} else if (absMinutes1 < absMinutes2) {
			ret = 1;
		} else {
			ret = 0;

		}
		return ret;
	}

  public static Timestamp toTimestamp(String string, int tipo) {
    try {
      Date DateAString = toDate(string, tipo);
      //System.out.println(DateAString.getTime());
      java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(DateAString.getTime());
      //System.out.println(sqlDate.getTime());
      return sqlTimestamp;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;
    }
  }

}
