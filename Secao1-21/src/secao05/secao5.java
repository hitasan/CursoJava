package secao05;

import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class secao5 {
	public static void main(String[] args) {
		Double n1, n2, n3;
		
		Locale.setDefault(Locale.US);			// Configura uso de localiza��o para tratar caracter de pontua��o ou virgula
		Scanner sc = new Scanner(System.in);	// Inicializa classe para receber dados digitados
		
		System.out.print("Digite um numero: ");
		n1 = sc.nextDouble();
		System.out.println("");
		
		if (n1 < 0) {
			System.out.println("O n�mero informado � NEGATIVO!!!");
		}
		else {
			System.out.println("O n�mero informado � POSITIVO!!!");
		}
		
		sc.close();
	}

}
