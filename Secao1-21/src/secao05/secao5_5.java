package secao05;

import java.util.Locale;
import java.util.Scanner;

public class secao5_5 {

	public static void main(String[] args) {
		int codigo, qtdd;
		double conta;
		
		//Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o codigo do produto: ");
		codigo = sc.nextInt();
		System.out.print("Digite a quantidade: ");
		qtdd = sc.nextInt();
		
		System.out.println("-----------------------------------------------------------------");
		
		if (codigo == 1)
			conta = (double) qtdd * 4.0;
		else if (codigo == 2)
			conta = (double) qtdd * 4.5;
		else if (codigo == 3 )
			conta = (double) qtdd * 5.0;
		else if (codigo == 4 )
			conta = (double) qtdd * 2.0;
		else	
			conta = (double) qtdd * 1.5;
		
		System.out.printf("TOTAL: R$ %.2f", conta);
	}

}
