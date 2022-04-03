package secao05;

import java.util.Locale;
import java.util.Scanner;

public class secao5_6 {

	public static void main(String[] args) {
		double nr01;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o valor para saber o intervalo [0-100]: ");
		nr01 = sc.nextDouble();
		
		System.out.println("-------------------------------------------------------------------------");
		
		if (nr01 < 0 || nr01 > 100 )
			System.out.printf("O valor %.2f está fora dos intervalos.", nr01);
		else if (nr01 <= 25)
			System.out.printf("O valor %.2f esta entre [0 - 25]", nr01);
		else if (nr01 <= 50)
			System.out.printf("O valor %.2f esta entre [25 - 50]", nr01);
		else if (nr01 <= 75)
			System.out.printf("O valor %.2f esta entre [50 - 75]", nr01);
		else
			System.out.printf("O valor %.2f esta entre [75 - 100]", nr01);
		
		sc.close();

	}

}
