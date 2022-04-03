package secao15;

import java.util.InputMismatchException;
import java.util.Scanner;

//Classe 2 de exemplo de tratamento de exce��es
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
			
			String[] vect = sc.nextLine().split(" ");	// montagem de array pegando texto digitado e recortando com base no espa�o os texto para ser cada posi��o do array
			int position = sc.nextInt();				// pegando uma posi��o qualquer para impressao do conteudo
			System.out.println(vect[position]);			// imprimindo na tela o conteudo do array referente a posi��o escolhida
			
		} 
		catch (ArrayIndexOutOfBoundsException e) {		// Tratamento para caso o usuario informa um valor para POSITION que n�o exista no array. Quando executar a impressao na tela dar� erro se nao tratado
			System.out.println("Invalid position selected!");
			e.printStackTrace();	// mostra toda a pilha de chamada desde o inicio ate o problema. Legal usar o conteudo salvando em um arquivo de log.
		} 
		catch (InputMismatchException e) {				// Tratamento para caso o usuario tenha informado um valor para position que n�o seja do mesmo tipo esperado. No caso deveria ser numerico e acaba por degitar uma letra.
			System.out.println("Input data type invalid!");
		}
		finally {
			System.out.println("Executado independentemente de ter executado ou nao o TRY");
			sc.close();
		}
		
		System.out.println("***METHOD 2 END***");
	}

}
