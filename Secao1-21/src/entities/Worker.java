package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	// Declaração das variaveis da composição
	private Department department;			// Worker tem unico department
	private List<HourContract> contracts = new ArrayList<>() ;	// Worker tem N contracts então vira uma lista de contratos
	

	// Metodos Construtores
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
		// Gerando construtor sem atributo lista<HourContracts> 1 para muitos não deve ser adicionado no construtor
	}

	
	// Metodos Get / Set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	//public void setContracts(List<HourContract> contracts) {	// Não poderá ser usado por deverá usar metodos de add/remove
		//this.contracts = contracts;
	//}
	
	
	// Demais metodos da classe
	public void addContract(HourContract contract) {	// Adiciona na lista de contratos o contrato que veio como argumento pelos parametros 
		this.contracts.add(contract);	
	}
	
	public void removeContract(HourContract contract) {	// Remove da lista de contratos o contrato que veio como arugumento pelos parametros
		this.contracts.remove(contract);
	}
	
	public Double income(int year, int month) {
		double sum = baseSalary;
		
		Calendar cal = Calendar.getInstance();
		
		// Para saber o valor recebido pelo salario base + os contratos do mes/ano recebido por parametros.
		// Preciso declarar um obj calendar
		for (HourContract c : contracts) { 
			cal.setTime(c.getDate());					// Setando esse calendar com a data do contrato
			int c_year  = cal.get(Calendar.YEAR);		// Pegando o ano especificado no calendar
			int c_month = 1 + cal.get(Calendar.MONTH);	// Pegando o mes especificado no calendar

			if (month == c_month && year == c_year) {	// Condicional para comparar cada contrato com a data que devo considerar vinda por parametro
				sum += c.totalValue();					// metodo de valor total do contrato retorna o valor que será incrementado na soma
			}
		}
		
		return sum;
	}
	
}
