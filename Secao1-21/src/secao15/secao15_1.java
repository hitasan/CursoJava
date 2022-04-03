package secao15;

import java.util.InputMismatchException;
import java.util.Scanner;

// Classe 1 de exemplo de tratamento de exce��es
public class secao15_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			
			String[] vect = sc.nextLine().split(" ");	// montagem de array pegando texto digitado e recortando com base no espa�o os texto para ser cada posi��o do array
			int position = sc.nextInt();				// pegando uma posi��o qualquer para impressao do conteudo
			System.out.println(vect[position]);			// imprimindo na tela o conteudo do array referente a posi��o escolhida
			
		} 
		catch (ArrayIndexOutOfBoundsException e) {		// Tratamento para caso o usuario informa um valor para POSITION que n�o exista no array. Quando executar a impressao na tela dar� erro se nao tratado
			System.out.println("Invalid position selected!");
		} 
		catch (InputMismatchException e) {				// Tratamento para caso o usuario tenha informado um valor para position que n�o seja do mesmo tipo esperado. No caso deveria ser numerico e acaba por degitar uma letra.
			System.out.println("Input data type invalid!");
		}
		
		System.out.println("End of program");
		
		sc.close();
	}

}
