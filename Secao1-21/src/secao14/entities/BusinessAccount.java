package secao14.entities;

// Classe exemplo de herança onde essa classe esta atraves do descritivo EXTENDS herdando dados e comportamentos da classe descrita a seguir
public class BusinessAccount extends Account {

	// Atributos da classe
	private Double loanLimit;
	
	// Metodos construtores
	public BusinessAccount() {
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance); // Chamada do construtor da superclasse, nesse caso é o construtor da classe account
		this.loanLimit = loanLimit;
	}


	// Metodos Getters / Setters
	public Double getLoanLimit() {
		return loanLimit;
	}
	
	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	
	// Demais metodos de processamento
	public void loan(double amount) {
		if (amount <= loanLimit) {
			//deposit(amount);	// Como a funcionalidade de emprestimos é um recebimento de dinheiro(deposito na conta), chamamos o metodo deposito da superclasse
			balance += amount - 10.0;
		}
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);	// exemplo de uso de sobreposição porem usando o metodo de saque da clase principal dentro desse metodo
		balance -= 2.0;
	}
	
}
