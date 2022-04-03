package secao05;

import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class secao5 {
	public static void main(String[] args) {
		Double n1, n2, n3;
		
		Locale.setDefault(Locale.US);			// Configura uso de localização para tratar caracter de pontuação ou virgula
		Scanner sc = new Scanner(System.in);	// Inicializa classe para receber dados digitados
		
		System.out.print("Digite um numero: ");
		n1 = sc.nextDouble();
		System.out.println("");
		
		if (n1 < 0) {
			System.out.println("O número informado é NEGATIVO!!!");
		}
		else {
			System.out.println("O número informado é POSITIVO!!!");
		}
		
		sc.close();
	}

}
