package secao14.entities;

public final class SavingsAccount extends Account {
	
	// no exmplo de uso da palavra FINAL, não permite que essa classe seja herdada por outras classes
	// Se colocar o FINAL nos metodos tipo o withdraw, não permitirá sobrepor esse metodo em uma subclasse que acabe herdando essa classe

	// Atributos da classe
	private Double interestRate;
	
	
	// Metodos contrutores
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	
	// Metodos Getters / Setters
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	

	// Demais metodos
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	@Override
	public void withdraw(double amount) {
		balance -= amount;	// Exemplo de sobreposição. Mesmo metodo na classe Account porem sem a tava de 5.0 no calculo. Adicionado o Override para indicar ao compilador que metodo se trata de sobreposição 
	}
	
}
