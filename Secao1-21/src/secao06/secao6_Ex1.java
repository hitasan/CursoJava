package secao06;

import java.util.Locale;
import java.util.Scanner;

public class secao6_Ex1 {

	public static void main(String[] args) {
		
		double grauC, grauF;
		char continua;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("Digite a temperatura em Celsius: ");
			grauC = sc.nextDouble();
			
			grauF = ((9.0 * grauC) / 5.0) + 32.0;
			
			System.out.printf("Equivalente em Fahrenheit: %.1f", grauF);
			System.out.println("");
		
			System.out.print("Deseja repetir (s/n): ");
			continua = sc.next().charAt(0);
			System.out.println("-----------------------------------------------");
		} while (continua == 's');
		
		
		if (continua != 's' && continua != 'n')
			System.out.println("Resposta não reconhecida. Programa finalizado!!!");
		else
			System.out.println("Programa finalizado!!!");
		
		sc.close();

	}

}
