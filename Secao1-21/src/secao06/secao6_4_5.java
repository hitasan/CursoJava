package secao06;

import java.util.Scanner;

/*
Ler um valor N. Calcular e escrever seu respectivo fatorial. Fatorial de N = N * (N-1) * (N-2) * (N-3) * ... * 1.
Lembrando que, por defini??o, fatorial de 0 ? 1.

Exemplos
Entrada: 		Sa?da:
4 				24
Entrada: 		Sa?da:
1 				1
Entrada: 		Sa?da:
5 				120
Entrada: 		Sa?da:
0 				1
 */
public class secao6_4_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int fat = 1;
		for (int i=1; i<=n; i++) {
			fat = fat * i;
		}
		
		System.out.println(fat);
		
		sc.close();

	}

}
