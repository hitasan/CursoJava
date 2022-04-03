package secao05;

import java.util.Locale;
import java.util.Scanner;

public class secao5_3 {

	public static void main(String[] args) {
		int nr1, nr2;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o primeiro numero: ");
		nr1 = sc.nextInt();

		System.out.print("Digite o segundo numero: ");
		nr2 = sc.nextInt();
		
		if (nr1 % nr2 == 0 || nr2 % nr1 == 0) {
			System.out.println("Sao Multiplos");
		}
		else {
			System.out.println("Nao sao Multiplos");
		}
		
		sc.close();
	}

}
