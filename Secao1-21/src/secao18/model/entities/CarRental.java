package secao18.model.entities;

import java.util.Date;

public class CarRental {

	// ATRIBUTOS DA CLASSE
	private Date start;
	private Date finish;
	
	private Vehicle vehicle;	// Como a classe CarRental esta ligada com as de vehicle e invoice, ambas estão associadas aqui
	private Invoice invoice;


	// METODOS CONSTRUTORES
	public CarRental() {
	}

	public CarRental(Date start, Date finish, Vehicle vehicle) {
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;	// INVOICE NAO ESTA ADICIONADO POIS PODE NAO EXISTIR O PROCESSAMENTO DO PAGAMENTO AINDA
	}
	
	
	// METODOS GETTERS / SETTERS
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}
	
	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}


	// DEMAIS METODOS
	
	
}
