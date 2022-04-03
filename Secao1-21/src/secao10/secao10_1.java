package secao10;

import java.util.Locale;
import java.util.Scanner;

// Exemplo 1 - manipulação de arrays simples
public class secao10_1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de posições do arrays: ");
		int n = sc.nextInt();
		double[] vect = new double[n];
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Digite o %d° numero: ", i+1);
			vect[i] = sc.nextDouble();
		}
		
		double sum = 0.0;
		for (int i = 0; i < n; i++) {
			sum += vect[i];
		}
		
		double avg = sum / n;
		
		System.out.printf("Media = %.2f%n", avg);
		
		sc.close();

	}

}
