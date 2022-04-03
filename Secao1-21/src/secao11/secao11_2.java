package secao11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class secao11_2 {

	public static void main(String[] args) throws ParseException {

		// Declaração/instanciação da classe de tipo data
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		// Declaração/instanciação de variaveis com as datas a usar
		Date d = Date.from(Instant.parse("2020-10-25T20:51:00Z"));	// Mesmo acima mas no padrao ISO8601 UTC que é 3 horas a menos daqui
		
		// Impressão
		System.out.println("d: " + sdf1.format(d));
		
		Calendar c = Calendar.getInstance();	// instancia de um novo calendario
		c.setTime(d);							// repassei a data d para o calendario
		c.add(Calendar.HOUR_OF_DAY, 4);			// acrecentando na hora do calendario 4 horas
		d = c.getTime();						// repassa a data autal para a variavel d
		
		System.out.println("d: " + sdf1.format(d));
		
		// Pegando minuto referente a data/hora especificada no calendar
		int minutes = c.get(Calendar.MINUTE);	// retorna qual o minuto da hora informada
		System.out.println("Minutes: " + minutes);

		// Pegando referente a data/hora especificada no calendar
		int month = 1 + c.get(Calendar.MONTH);		// retorna qual o minuto da hora informada. Somando 1 pois começa em zero.
		System.out.println("Month: " + month);
		

	}

}
