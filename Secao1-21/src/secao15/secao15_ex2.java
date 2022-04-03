package secao15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import secao15.entities.*;
import secao15.exceptions.*;

public class secao15_ex2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			// CAPTURA DE DADOS PELA TELA
			System.out.println("ENTER ACCOUNT DATA");
			System.out.print("Number: #");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: $");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: $");
			double withdrawLimit = sc.nextDouble();

			// INSTANCIA DE OBJETO COM DADOS INFORMADOS
			Account acc = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();

			acc.withdraw(amount);
			System.out.printf("New balance: $%.2f", acc.getBalance());
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error" + e.getMessage());
		}

		sc.close();
	}

}
