package secao14;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao14.entities.Company;
import secao14.entities.Individual;
import secao14.entities.TaxPayer;

// Exercicio de fixação de classes/metodos abstratos 
public class secao14_ex2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int npay = sc.nextInt();

		List<TaxPayer> lst = new ArrayList<TaxPayer>();

		for (int i = 0; i < npay; i++) {
			System.out.println("");
			System.out.printf("Tax payer #%d data: ", i+1);
			System.out.println("");
			
			System.out.print("Individual or company (i/c)? ");
			char opc = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if (opc == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				
				TaxPayer tp = new Individual(name, anualIncome, healthExpenditures);
				lst.add(tp);
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();

				TaxPayer tp = new Company(name, anualIncome, numberOfEmployees);
				lst.add(tp);
			}
		}
		
		double sum = 0.0;
		System.out.println("");
		System.out.println("============================================================================================");
		System.out.println("TAXES PAID:");
		
		for (TaxPayer tp : lst) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		System.out.println("============================================================================================");
		
		sc.close();
	}

}
