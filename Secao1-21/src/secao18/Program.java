package secao18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import secao18.model.entities.CarRental;
import secao18.model.entities.Vehicle;
import secao18.model.services.BrazilTaxService;
import secao18.model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter rental data!");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd:MM:YYYY hh:ss): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd:MM:YYYY hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel)); // instanciando o obj vehicle diretamento na passagem de parametro do construtor mas poderia ser instanciado em variavel separada antes
		
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		// Instanciando o serviço de aluguel - No caso esta usando o service de taxas do Brasil mas poderia ter condicional para tratar cada pais e instanciar conforme a necessidade (serviço para outros países)
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService()); // instanciando o obj taxservice diretamento na passagem de parametro do construtor mas poderia ser instanciado em variavel separada antes
		
		// Processando o pagamento
		rentalService.processInvoice(cr);
		
		// Imprimindo os dados processados
		System.out.println();
		System.out.println("INVOICE");
		System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Total payment:" + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		System.out.println();
		
		
		sc.close();
	}

}
