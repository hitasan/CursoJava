package secao19.GenericsDelimitados.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import secao19.GenericsDelimitados.entities.Product;
import secao19.GenericsDelimitados.services.CalculationService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();	// Criando uma lista de produtos

		String path = "C:\\temp\\in.txt";		// Caminho do arquivo texto que será lido 

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {	// Tratamento para abertura e operação com o arquivo especificado no path

			// Lendo cada linha do arquivo e armazenando os dados na lista
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");	// armazenando no vetor fields os dados da linha que foram separados pelo split
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));	 // Instanciando um produto com os dados que vieram no arquivo e adicionando o objeto produto na lista
				line = br.readLine();
			}
			
			// Instanciando o serviço de calculo passando a lista para o metodo max retornar o maior item
			Product x = CalculationService.max(list);
			System.out.println("Most expensive:");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
	}
}
