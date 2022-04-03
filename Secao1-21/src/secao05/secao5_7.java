package secao05;

import java.util.Locale;
import java.util.Scanner;

public class secao5_7 {

	public static void main(String[] args) {
		double x, y;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o valor de X: ");
		x = sc.nextDouble();
		System.out.print("Digite o valor de Y: ");
		y = sc.nextDouble();
		
		System.out.println("------------------------------------------------------------");
		
		if (x == 0 && y == 0) 
			System.out.println("Ponto localizado na ORIGEM.");
		else if ( (x > 0 || x < 0)  && y == 0)
			System.out.println("Ponto localizado no EIXO X.");
		else if ( (y > 0 || y < 0)  && x == 0)
			System.out.println("Ponto localizado no EIXO Y.");
		else if (x > 0 && y > 0) 
			System.out.println("Ponto localizado no Q1.");
		else if (x < 0 && y > 0) 
			System.out.println("Ponto localizado no Q2.");
		else if (x < 0 && y < 0) 
			System.out.println("Ponto localizado no Q3.");
		else
			System.out.println("Ponto localizado no Q4.");
		
		sc.close();

	}

}
