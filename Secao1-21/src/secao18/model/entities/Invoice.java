package secao18.model.entities;

public class Invoice {

	// ATRIBUTOS
	private Double basicPayment;
	private Double tax;
	
	
	// METODOS CONSTRUTORES
	public Invoice() {
	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	
	// METODOS GETTERS / SETTERS
	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	
	// DEMAIS METODOS
	public Double getTotalPayment() {
		return getBasicPayment() + getTax();
	}
	
	
	
}
