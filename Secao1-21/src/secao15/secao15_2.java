package secao15;

import java.util.InputMismatchException;
import java.util.Scanner;

//Classe 2 de exemplo de tratamento de exceções
public class secao15_2 {

	// Metodo principal
	public static void main(String[] args) {

		method1();
		System.out.println("End of program");
	}
	
	// Metodo auxiliar 1
	public static void method1() {
		
		System.out.println("***METHOD 1 START***");
		method2();
		System.out.println("***METHOD 1 END***");
	}

	// Metodo auxiliar 2
	public static void method2() {

		System.out.println("***METHOD 2 START***");
		Scanner sc = new Scanner(System.in);
		
		try {
			
			String[] vect = sc.nextLine().split(" ");	// montagem de array pegando texto digitado e recortando com base no espaço os texto para ser cada posição do array
			int position = sc.nextInt();				// pegando uma posição qualquer para impressao do conteudo
			System.out.println(vect[position]);			// imprimindo na tela o conteudo do array referente a posição escolhida
			
		} 
		catch (ArrayIndexOutOfBoundsException e) {		// Tratamento para caso o usuario informa um valor para POSITION que não exista no array. Quando executar a impressao na tela dará erro se nao tratado
			System.out.println("Invalid position selected!");
			e.printStackTrace();	// mostra toda a pilha de chamada desde o inicio ate o problema. Legal usar o conteudo salvando em um arquivo de log.
		} 
		catch (InputMismatchException e) {				// Tratamento para caso o usuario tenha informado um valor para position que não seja do mesmo tipo esperado. No caso deveria ser numerico e acaba por degitar uma letra.
			System.out.println("Input data type invalid!");
		}
		finally {
			System.out.println("Executado independentemente de ter executado ou nao o TRY");
			sc.close();
		}
		
		System.out.println("***METHOD 2 END***");
	}

}
