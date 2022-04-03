package secao14;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import secao14.entities.Account;
import secao14.entities.BusinessAccount;
import secao14.entities.SavingsAccount;

// Exemplo de uso de classe Abstrata
public class sexao14_3 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		// Instanciando 3 obj Account porem de tipos diferentes cada uma (Polimorfismo)
		//Account acc1 = new Account(1001, "Alex", 1000.0);	// Mudando a classe Account para abstract, ela nao pode ser mais instanciada
		//Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		//Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		
		// Polimorfismo usando a classe abstrata. Foi adicionado 4 contas de caracteriscas diferentes em lista de tipo da conta normal Account.
		List<Account> lst = new ArrayList<Account>();
		
		lst.add(new SavingsAccount(1001, "Alex", 500.0, 0.01));
		lst.add(new BusinessAccount(1002, "Maria", 1000.0, 400.0));
		lst.add(new SavingsAccount(1003, "Bob", 300.0, 0.01));
		lst.add(new BusinessAccount(1004, "Ana", 500.0, 500.0));
		
		Double sum = 0.0;
		for (Account acc : lst) {
			sum += acc.getBalance();
		}
		
		System.out.printf("Total balance: %.2f%n", sum);
		
		for (Account acc : lst) {
			acc.deposit(10.0);
		}
		
		for (Account acc : lst) {
			System.out.printf("Updated balance form account %d: %.2f%n", acc.getNumber(), acc.getBalance());
		}
		
		

	}

}
