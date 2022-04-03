package secao14.entities;

public class OutsourcedEmployee extends Employee {

	// Atributos da Classe
	private Double  additionalCharge;

	
	// Metodos construtores
	public OutsourcedEmployee() {
		super();
	}
	
	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	
	// Metodos Getters / Setters
	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
		
	@Override
	public Double payment() {	// Sobreposição para mudar regra nesse tipo de funcionario
		return super.payment() + (additionalCharge * 1.1); // Super chamo a função de pagamento normal para me retornar o valor e realizo a soma de mais 100% do additionalCharge
	}
}
