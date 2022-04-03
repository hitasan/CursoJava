package secao15.entities;

import secao15.exceptions.DomainException;

public class Account {

	// Atributos da classe
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	// Metodos construtores
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		if (number <= 0) {
			throw new DomainException("Enter a valid account number!");
		}

		if (holder == null) {
			throw new DomainException("Enter a valid holder name!");
		}

		if (balance <= 0) {
			throw new DomainException("Enter a valid balance value!");
		}

		if (withdrawLimit <= 0) {
			throw new DomainException("Enter a valid withdraw limit value!");
		}

		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
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
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	

	// Metodos de processamento
	public void deposit(Double amount) {
		if (amount <= 0) { 
			throw new DomainException("Enter a valid amount for deposit!");
		}

		balance += amount;
	}
	
	public void withdraw(Double amount) {
		if (balance <= 0 || amount > balance) { 
			throw new DomainException("Not enough balance!");
		}
		if (amount <= 0) { 
			throw new DomainException("Enter a valid amount for deposit!");
		}
		if (amount > withdrawLimit) { 
			throw new DomainException("The Amount exceeds the withdrawal limit!");
		}

		balance -= amount;
	}
	
}
