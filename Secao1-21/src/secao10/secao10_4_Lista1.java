package secao10;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class secao10_4_Lista1 {

	public static void main(String[] args) {

		List<String> lst = new ArrayList<>();	// Declarando uma lista de inteiros usando wrapperclass e instanciando a classe arraylist pq precisa instanciar uma classe que foi desenvolvida
		
		// Adicionando conteudos na lista
		lst.add("Maria");
		lst.add("Alex");
		lst.add("Anna");
		lst.add("Bob");
		
		// Adicionando itens em posição especifica da lista
		lst.add(2, "Marco");
		
		// Listando o tamanho da lista
		System.out.println(lst.size());
		
		// Removendo um item da lista por comparação de conteudo
		lst.remove("Anna");
		// Removendo um item da lista por item especificado
		lst.remove(1);
		// Removendo todos tendendo a um predicado, parte interna funciona +- como o aScan do advpl
		lst.removeIf(x -> x.charAt(0) == 'M');
		
		// Procurando a posição de um conteudo. Quando nao encontrado retorna -1
		System.out.println("Index Of Bob: " + lst.indexOf("Bob"));
		
		for (String x : lst) {
			System.out.println(x);
		}
		
		
		// Para filtrar somente os itens que foram especificados (no caso que começam com letra A).
		// Primeiro foi criado um novo list para receber o resultado
		// Converteu a lista inicial para stream.
		// filtrou atravez do FILTER o que queria listar
		// Convertendo novamente esse resultado para LIST atravez do COLLECT
		List<String> result = lst.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

		for (String x : result) {
			System.out.println(x);
		}
		
		
		// Encontrar um elemento da lista que atenda um certo predicado
		// criando nova variavel string para receber o primeiro item conforme filtro
		// Convertendo a lista para STREAM.
		// Filtrando conforme comando FILTER
		// Especificando que quero a primeira ocorrencia pelo comando FINDFIRST
		// Se nao encontrou registros, retorna NULL conforme função ORELSE
		String name = lst.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
		System.out.println(name);
		
	}

}
