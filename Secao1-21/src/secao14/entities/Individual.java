package secao14.entities;

public class Individual extends TaxPayer {

	// Atributos da classe
	private Double healthExpenditures;
	
	
	// Metodos construtores
	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	

	// Metodos Getters / Setters
	public Double getHealthExpenditures() {
		return healthExpenditures;
	}
	
	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	
	// Metodos de processamento
	@Override
	public Double tax() {			// implementação de metodo abstrato de superclasse TaxPayer

		if ( getAnualIncome() < 20000.0 ) {
			return getAnualIncome() * 0.15 - healthExpenditures * 0.5;
		}
		else {
			return getAnualIncome() * 0.25 - healthExpenditures * 0.5;
		}
	}
}
