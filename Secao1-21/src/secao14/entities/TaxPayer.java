package secao14.entities;

public abstract class TaxPayer {

	// Atributos da class
	private String name;
	private Double anualIncome;
	
	
	// Metodos construtores
	public TaxPayer() {
	}

	public TaxPayer(String name, Double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}
	
	
	// Metodos Getters / Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}
	

	// Metodos de processamento
	public abstract Double tax();	// Metodo abstrato


}
