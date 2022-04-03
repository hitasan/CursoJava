package secao05;

import java.util.Locale;
import java.util.Scanner;

public class secao5_2 {

	public static void main(String[] args) {
		Double nr1;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		
		System.out.print("Digite o numero: ");
		nr1 = sc.nextDouble();
		
		if ( (nr1 % 2) == 0 ) {
			System.out.println("O número informado é PAR!");
		}
		else {
			System.out.println("O número informado é IMPAR!");
		}
		
		sc.close();
	}

}
