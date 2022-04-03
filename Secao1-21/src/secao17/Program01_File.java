package secao17;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program01_File {

	public static void main(String[] args) {
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		// FORMA SIMPLES DE LER UM ARQUIVO DE TEXTO
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		File file = new File("D:\\OneDrive\\Desenvolvimento\\Java\\workspace\\curso_programacao\\src\\secao17\\in.txt");	// instancia o objeto encapsulado com o caminho do arquivo
		Scanner sc = null;
		try {
			sc = new Scanner(file);	// instancia o scanner mais ao inves do systin.in que é o teclado, especifico o arquivo que será lido
			while ( sc.hasNextLine() ) {
				System.out.println(sc.nextLine());
			}
			// scanner poderia ser encerrado aqui porem se tiver alguma exception, teria problema....jogamos par ao finally
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
