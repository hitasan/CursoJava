package secao14.entities;

public abstract class Account {

	// Atributos da classe
	private Integer number;
	private String holder;
	protected Double balance;
	
	// Metodos construtores
	public Account() {
	}

	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}
	
	
	// Metodos Getters / Setters
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}


	public Double getBalance() {
		return this.balance;
	}
	
	
	// Demais metodos de processamento
	public void withdraw(double amount) {
		balance -= amount + 5.0;	// Exemplo de sobreposição. Suponha que para o saque cobre os 5.0 de taxa porem para conta SavingsAccount nao deveria cobrar esse valor. Refaremos esse metodo na classe SavingsAccount sobrepondo a regra
	}

	public void deposit(double amount) {
		balance += amount;
	}
}
