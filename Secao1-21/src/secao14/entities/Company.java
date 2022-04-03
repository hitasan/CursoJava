package secao14.entities;

public class Company extends TaxPayer {
	
	// Atributos da classe
	private Integer numberOfEmployees;

	
	// Metodos construtores
	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}
	
	
	// Metodos Getters / Setters
	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}
	
	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	
	// Metodos de processamento
	@Override
	public Double tax() { 			// implementação de metodo abstrato de superclasse TaxPayer
		
		if ( numberOfEmployees > 10 ) {
			return getAnualIncome() * 0.14;
		}
		else {
			return getAnualIncome() * 0.16;
		}

	}
}
