package secao06;

import java.util.Scanner;

/*
Escreva um programa que repita a leitura de uma senha até que ela seja válida. Para cada leitura de senha
incorreta informada, escrever a mensagem "Senha Invalida". Quando a senha for informada corretamente deve ser
impressa a mensagem "Acesso Permitido" e o algoritmo encerrado. Considere que a senha correta é o valor 2002.
 */
public class secao6_3_1 {

	public static void main(String[] args) {
		int codigo;
		int passwd = 2002;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a senha: ");
		codigo = sc.nextInt();
		
		while (codigo != passwd) {
			System.out.println("----------------------------------------------");
			System.out.println("SENHA INVALIDA");

			System.out.print("Digite a senha: ");
			codigo = sc.nextInt();
			
		}
		
		System.out.println("----------------------------------------------");
		System.out.println("ACESSO PERMITIDO!!!");
		
		sc.close();

	}

}
