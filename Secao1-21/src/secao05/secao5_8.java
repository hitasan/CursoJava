package secao05;

import java.util.Locale;
import java.util.Scanner;

public class secao5_8 {

	public static void main(String[] args) {
		double salary, imposto;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o valor do salario: ");
		salary = sc.nextDouble();
		
		System.out.println("------------------------------------------------");
		
		if (salary <= 2000.0)
			imposto = 0.0;
		else if (salary <= 3000.0)
			imposto = (salary - 2000.0) * 0.08;
		else if (salary <= 4500.0)
			imposto = (salary - 3000.0) * 0.18 + 1000.0 * 0.08;
		else 
			imposto = (salary - 4500.0) * 0.28 + 1500.0 * 0.18 + 1000.0 * 0.08;

		if (imposto == 0.0)
			System.out.println("Isento de impostos");
		else
			System.out.printf("Valor a pagar de imposto: R$ %.2f%n", imposto);
		
		sc.close();
		
	}

}
