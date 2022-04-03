package secao14.entities;

public class ImportedProduct extends Product {

	// Atributos da classe
	private Double customsFee;

	
	// Metodos construtores
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	
	// Metodos Getters / Setters
	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	
	// Metodos de processamento
	@Override
	public String priceTag() {
		return getName() 
			   + " $ " + String.format("%.2f", totalPrice())
			   + " (Customs fee: $ " + String.format("%.2f", customsFee) + ")";
	}
	
	public Double totalPrice() {
		return getPrice() + customsFee;
	}
	
}
