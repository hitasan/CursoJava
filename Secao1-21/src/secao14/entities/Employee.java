package secao14.entities;

public class Employee {

	// Atributos da classe
	private String name;
	private Integer hours;
	private Double valuePerHour;

	// Metodos Construtores
	public Employee() {
	}

	public Employee(String name, Integer hours, Double valuePerHour) {
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	// Metodos Getters / Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	// Metodos de processamento
	public Double payment() {
		return hours * valuePerHour;
	}
	
	@Override
	public String toString() {
		return "Funcionario:";
	}
}
