package secao18.model.services;

import secao18.model.entities.CarRental;
import secao18.model.entities.Invoice;

public class RentalService {

	// ATRIBUTOS DA CLASSE
	private Double pricePerDay;
	private Double pricePerHour;
	
	//private BrazilTaxService taxService;	// Comentado pois com interface nao precisaremos mais instancias diretamente essa classe para o brasil e sim uma generica que acessará ela. Assim removemos o acoplamento
	private TaxService taxService;			// Esse serviço de taxas será o responsavel por fazer a ligação entre o serviço de aluguel e o serviço de imposto do país devido


	// METODOS CONSTRUTORES
	//public RentalService() {	// OBRIGATORIO INFORMAR OS 3 PARAMETROS ENTAO NAO USAREMOS ESSE CONSTRUTOR
	//}
	
	public RentalService(Double pricePerDay, Double pricePerHour, /*BrazilTaxService*/TaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}

	
	// METODOS GETTERS / SETTERS
	public Double getPricePerDay() {
		return pricePerDay;
	}
	
	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public Double getPricePerHour() {
		return pricePerHour;
	}
	
	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	//public BrazilTaxService getTaxService() {
		//return taxService;
	//}
	
	//public void setTaxService(BrazilTaxService taxService) {
		//this.taxService = taxService;
	//}
	
	
	// DEMAIS METODOS
	public void processInvoice(CarRental carRental) {	// METODO RESPONSAVEL POR GERAR A NOTA DE PAGAMENTO DO ALUGUEL
		long t1 = carRental.getStart().getTime(); 	// getTime pega o instante em milisegundos da minha data
		long t2 = carRental.getFinish().getTime();
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;	// Data final - Data inicial / miliseg / min / hora
		
		double basicPayment; 
		if (hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour; 		// Quantidade de horas arredondado para cima e multiplica pelo preço por hora. Math.ceil() arredonda para cima
		}
		else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay; 	// Quantidade de dias arredondado para cima e multiplica pelo preço por dia
		}
		
		double tax = taxService.tax(basicPayment);	// calcula o valor do imposto com base no basicPayment
		
		carRental.setInvoice(new Invoice(basicPayment, tax));	// criei um novo obj de nota de pagamento (invoice) e associei ele ao obj de aluguel (carRental)
	}
}
