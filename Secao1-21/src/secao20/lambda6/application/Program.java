package secao20.lambda6.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
// 		Arquivo in.txt com conteudo abaixo
//		Tv,900.00
//		Mouse,50.00
//		Tablet,350.50
//		HD Case,80.90
//		Computer,850.00
//		Monitor,290.00

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Product> list = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));	// Adiciono na lista o objeto produto com seu nome e preço. Double.parseDouble() pq os dados do arquivo estão vindo como string ai precisa converter para double
				line = br.readLine();
			}
			
			// Fazendo um pipeline para achar a soma dos preços e encontrando o valor medio
			double avg = list.stream()								// Convertendo a lista para stream
					.map(p -> p.getPrice())							// utilizando o map para ler somente o preço para cada produto p da lista
					.reduce(0.0, (x,y) -> x + y) / list.size();		// Permite fazer o somatorio dos preços conforme stream gerada pelo map somente com os preços. Essa soma é dividida pelo tamanho do list
			
			System.out.println("Average price: " + String.format("%.2f", avg));
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()); // Comparator para cada item. Regra de uso dos itens sera usado no metodo sorted do map()
			
			// Realizando mais um pipeline para descobrir os produtos com valor menor que a media e ordena-los pelo nome decrescentemente
			List<String> names = list.stream()						// convertendo a list para stream
					.filter(p -> p.getPrice() < avg)				// filtrando somente os registros que tiverem o preço menor que o valor medio
					.map(p -> p.getName()).sorted(comp.reversed())	// pegando e ordenando os nomes de forma decrescente. sorted() necessita de um comparator que esta criado acima 
					.collect(Collectors.toList());					// Convertendo de stream para um list
			
			names.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
}
