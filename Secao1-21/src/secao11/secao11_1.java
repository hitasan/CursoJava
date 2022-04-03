package secao11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class secao11_1 {

	public static void main(String[] args) throws ParseException {

		// Declaração/instanciação da classe de tipo data
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		// Declaração/instanciação de variaveis com as datas a usar
		Date d1 = new Date();							// Data atual
		Date d2 = new Date(System.currentTimeMillis());	// Data atual em milisegundos
		Date d3 = new Date(0L);							// Primeira data contabilizada pelo Java em milisegundos referente a 01/01/1970
		Date d4 = new Date(1000L * 60L * 60L * 5L);		// 5 horas apos a database do Java em 01/01/1970 1000=milisegundos dentro do segundo, 60=segundos dentro do minuto, 60=minutos dentro da hora e 5=horas
		
		Date y1 = sdf1.parse("25/10/2020");							// Data informada sem tempo
		Date y2 = sdf2.parse("25/10/2020 20:51:00");				// Data informada com tempo
		Date y3 = Date.from(Instant.parse("2020-10-25T20:51:00Z"));	// Mesmo acima mas no padrao ISO8601 UTC que é 3 horas a menos daqui
		
		// Impressão
		System.out.println("d1: " + d1);
		System.out.println("d2: " + d2);
		System.out.println("d3: " + d3);
		System.out.println("d4: " + d4);
		System.out.println("y1: " + y1);
		System.out.println("y2: " + y2);
		System.out.println("y3: " + y3);
		System.out.println("-------------------------------------------------------");
		System.out.println("d1: " + sdf2.format(d1));
		System.out.println("d2: " + sdf2.format(d2));
		System.out.println("d3: " + sdf2.format(d3));
		System.out.println("d4: " + sdf2.format(d4));
		System.out.println("y1: " + sdf2.format(y1));
		System.out.println("y2: " + sdf2.format(y2));
		System.out.println("y3: " + sdf2.format(y3));
		System.out.println("-------------------------------------------------------");
		System.out.println("d1: " + sdf3.format(d1));
		System.out.println("d2: " + sdf3.format(d2));
		System.out.println("d3: " + sdf3.format(d3));
		System.out.println("d4: " + sdf3.format(d4));
		System.out.println("y1: " + sdf3.format(y1));
		System.out.println("y2: " + sdf3.format(y2));
		System.out.println("y3: " + sdf3.format(y3));
		
	}

}
