package entities;

public class Employee_Lst {

	private Integer id;
	private String name;
	private Double salary;
	
	// ----------------------------------------------------------------------
	// Criação de metodos construtor e sobrecarga 
	// ----------------------------------------------------------------------
	public Employee_Lst() {
	}
	
	public Employee_Lst(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}


	// ----------------------------------------------------------------------
	// Criação de metodos GET/SET
	// ----------------------------------------------------------------------
	public Integer getId() { return id; }
	public String getName() { return name; }
	public Double getSalary() { return salary; }
	
	public void setId(Integer id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setSalary(Double salary) { this.salary = salary; }
	
	
	// ----------------------------------------------------------------------
	// Criação de motodos complementares + toString
	// ----------------------------------------------------------------------
	public void IncreaseSalary(double percentage) {
		this.salary += (this.salary * percentage) / 100;
	}

	// Adicionando o metodo toString para imprimir os dados porem sempre usar o @Override para evitar erros na criação do metodo
	@Override
	public String toString() {
		return id + ", " + name + ", $ " + String.format("%.2f", this.salary);
	}
}
