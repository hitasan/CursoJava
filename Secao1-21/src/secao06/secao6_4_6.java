package secao06;

import java.util.Scanner;

/*
Ler um número inteiro N e calcular todos os seus divisores.
Exemplo:
Entrada: 	Saída:
6 			1
			2
			3
			6
 */
public class secao6_4_6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}
		}
		
		sc.close();

	}

}
