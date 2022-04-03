package secao17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program04_FileW_BufferedW {

	public static void main(String[] args) {

		// ----------------------------------------------------------------------------------------------------------------------------------
		// EXEMPLO USANDO FileWriter e BufferedWriter - ESCRITA EM ARQUIVO TEXTO
		// ----------------------------------------------------------------------------------------------------------------------------------
		// new FileWriter(path) = Cria no caso do arquivo não existir, recria zerado no caso de existir
		// new FileWriter(path, true) = Acrescenta o conteudo passado no arquivo especificado

		String[] lines = new String[] {"Bom dia", "Boa tarde", "Boa noite"};
		String path = "D:\\OneDrive\\Desenvolvimento\\Java\\workspace\\curso_programacao\\src\\secao17\\out.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {	// Como descrito no comentario acima, nao foi passado todos parametros para a classe FileWriter portanto sempre criará um novo arquivo sobrepondo e ja existir
		//try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {	// Opção passando parametro para nao sobrescrever o arquivo e continuar adicionado o conteudo no ja existente
			for ( String line : lines) {
				bw.write(line);	// não tem quebra de linha por tanto é necessario adicionar se for o caso
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
