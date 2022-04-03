package secao17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program02_FileR_BufferedR_Ruim {

	public static void main(String[] args) {

		// ----------------------------------------------------------------------------------------------------------------------------------
		// EXEMPLO USANDO FileReader e BufferedReader - Exemplo simples (Dev porco)
		// ----------------------------------------------------------------------------------------------------------------------------------
		String path = "D:\\OneDrive\\Desenvolvimento\\Java\\workspace\\curso_programacao\\src\\secao17\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			while ( line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null)	br.close();
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
