package secao08;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class secao8_ex2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Employee func = new Employee();
		
		System.out.print("Name: ");
		func.name = sc.nextLine();
		System.out.print("Gross Salary: ");
		func.grossSalary = sc.nextDouble();
		System.out.print("Tax: ");
		func.tax = sc.nextDouble();
		
		System.out.println("-----------------------------------------");
		System.out.println("Employee: " + func);
		
		System.out.println("");
		System.out.print("Which percentage to increase salary? ");
		double perc = sc.nextDouble();
		func.IncreaseSalary(perc);
		
		System.out.println("-----------------------------------------");
		System.out.println("Updated data: " + func);

	}

}
