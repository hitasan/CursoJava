package secao09;

import java.util.Locale;
import java.util.Scanner;

import entities.ContaBancaria;

public class secao9_exerc1 {

	public static void main(String[] args) {
		int numCta;
		char opc;
		double vlrMovto;
		String nomeCta;

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o numero da conta: ");
		numCta = sc.nextInt();
		
		System.out.print("Informe o nome do correntista: ");
		sc.nextLine();
		nomeCta = sc.nextLine();
	
		ContaBancaria cta = new ContaBancaria(numCta, nomeCta);
		
		System.out.print("Deseja fazer um depósito inicial (s/n)? ");
		if ( sc.next().charAt(0) == 's') {
			System.out.print("Informe o valor inicial do depósito: ");
			vlrMovto =  sc.nextDouble();
			
			cta.depositoConta(vlrMovto);
		}

		System.out.println("");
		System.out.println("Account data:");
		System.out.println(cta);
		System.out.println("-------------------------------------------------------------");
		
		do {
			System.out.println("");
			System.out.print("Deseja D=Depositar/S=Sacar/E=Sair: ");
			opc = sc.next().charAt(0);
			
			if ( opc == 'D') {

				System.out.print("Informe o valor do deposito: ");
				vlrMovto = sc.nextDouble();
				cta.depositoConta(vlrMovto);
				
			} else if ( opc == 'S') {
				
				System.out.print("Informe o valor de saque: ");
				vlrMovto =  sc.nextDouble();
				cta.saqueConta(vlrMovto);
				
			}
			
			System.out.println("");
			System.out.println("Account data:");
			System.out.println(cta);
			System.out.println("-------------------------------------------------------------");
			
		} while (opc != 'E');

		System.out.println("Operação Finalizada");
		sc.close();

	}

}
