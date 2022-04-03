package secao17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program03_FileR_BufferedR_Bom {

	public static void main(String[] args) {
		// ----------------------------------------------------------------------------------------------------------------------------------
		// EXEMPLO USANDO FileReader e BufferedReader - melhor modo (Dev limpo com try-with-resources)
		// ----------------------------------------------------------------------------------------------------------------------------------
		String path = "D:\\OneDrive\\Desenvolvimento\\Java\\workspace\\curso_programacao\\src\\secao17\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path)) ) {	// no try ja é instanciado o BR e FR para o escopo ficar fixo ao try, esses serão encerrados apos fim do bloco
			String line = br.readLine();
			while ( line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
