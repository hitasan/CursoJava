package secao17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao17.Entities.Product;

public class exercicio01 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// ----------------------------------------------------------------------------------------------------------------------------------
		// LENDO O ARQUIVO BASE
		// ----------------------------------------------------------------------------------------------------------------------------------
		System.out.print("Informe a url do arquivo: ");	// DIGITADO: D:\OneDrive\Desenvolvimento\Java\workspace\curso_programacao\src\secao17\exercicio01\in.csv	
		String pathFile = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(pathFile)) ) {
			// ----------------------------------------------------------------------------------------------------------------------------------
			// LENDO ARQUIVO E ARMAZENANDO DADOS NO OBJETO PRODUTO
			// ----------------------------------------------------------------------------------------------------------------------------------
			List<Product> list = new ArrayList<>();		// Instanciando uma lista de tipo Product

			String items = br.readLine();				// Le e copia a primeira linha para a variavel items
			while ( items != null) {					// Percorre as linhas enquanto existir conteudo
				String[] item = items.split(";");		// Quebra a linha em um array de item
				
				String name = item[0];
				double price = Double.parseDouble(item[1]);
				Integer quantity = Integer.parseInt(item[2]);

				Product prod = new Product(name, price, quantity);	// Instancia o Objeto produto passando seus atributos
				list.add(prod);										// Adiciona o objeto produto instanciado na lista de Produtos
				
				items = br.readLine();								// Adiciona conteudo da proxima linha na variavel de items para executar novamente o loop se tiver conteudo
			}
			
			
			// ----------------------------------------------------------------------------------------------------------------------------------
			// CRIANDO A SUBPASTA PARA ARQUIVO CRIADO
			// ----------------------------------------------------------------------------------------------------------------------------------
			File file = new File(pathFile);										// Instanciação do caminho do arquivo passado por parametro para criar uma variavel do tipo File
			String sourceDir = file.getParent();								// Pega somente o caminhode diretorios do arquivo informado
			boolean success = new File(sourceDir + "\\out").mkdir();			// Criação de uma nova pasta conforme url de diretorios
			System.out.println("Directory created successfully: " + success);
			
			
			// ----------------------------------------------------------------------------------------------------------------------------------
			// CRIANDO NOVO ARQUIVO DE SUMARIO
			// ----------------------------------------------------------------------------------------------------------------------------------
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(sourceDir + "\\out\\summary.csv"))) {	// Criando novo arquivo que será escrito, no caminho informado
				for (Product item : list) {													// Percorre cada produto da lista
					bw.write(item.getName() + ";" + String.format("%.2f", item.total()));	// Grava no novo arquivo, nome e total do produto
					bw.newLine();
				}

				System.out.println(sourceDir + "\\out\\summary.csv" + " CREATED!");
			
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}
