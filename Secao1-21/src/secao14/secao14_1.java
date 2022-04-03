package secao14;

import secao14.entities.Account;
import secao14.entities.BusinessAccount;
import secao14.entities.SavingsAccount;

public class secao14_1 {

	public static void main(String[] args) {

		//Account acc = new Account(1001, "Alex", 0.0);
		//BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING = Pega o objeto de uma subclasse e atribui na super classe
		//Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);
		

		// DOWNCASTING = Pega o objeto de uma superclasse e atribui na sub classe
		BusinessAccount bacc2 = (BusinessAccount) acc2;		// nesse caso precisamos fazer a conversão(downcasting) dos tipo indicando que acc2 recebido deverá considerada como businessAccount 
		bacc2.loan(100.0);	// Aqui vemos que o novo obj bacc2 tem acesso ao metodo loan
		
		
		// USO DO INSTANCEOF
		// Para tratar fazemos um condicional comparando o obj que origem (acc3) com o instanceof + o tipo (BusinessAccount). Com isso só permitira a atribuição se a condição for TRUE. 
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;  // tentativa que criar uma businessAccount recebendo acc3 fazendo casting como BusinessAccount porem acc3 não BA e sim SavingsAccount. Não dará erro de compilação mas quebra na execução.
			acc5.loan(200.0);
			System.out.println("Loan!");
		}

		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		// Comentado pois em proximo exemplo, tornamos a classe Account abstrata desse modo não é permitido mais realizar a instanciação da mesma.
		//Account acc6 = new Account(1007, "Alex", 1000.0);
		//acc6.withdraw(200.0);
		//System.out.println(acc6.getBalance());
		
		Account acc7 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		acc7.withdraw(200.0);
		System.out.println(acc7.getBalance());
		
		
		Account acc8 = new BusinessAccount(1003, "Jose", 1000.0, 500.0);
		acc8.withdraw(200.0);
		System.out.println(acc8.getBalance());
		
	}

}
