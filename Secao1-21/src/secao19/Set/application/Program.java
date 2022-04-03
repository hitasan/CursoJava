package secao19.Set.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import secao19.Set.entities.LogEntry;
import secao19.Set.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		//Exemplo1();
		
		//Exemplo2();

		//Exemplo3();

		//Exemplo4();

		//Exercicio1();

		//Exercicio2();
		
		//Exemplo5();

		//Exemplo6();

		//Exercicio3();
	}

	// Usando uma coleção SET
	public static void Exemplo1() {
		// Set seria como uma lista porem com suas particulariedades
		Set<String> set = new HashSet<>();			// Nesse exemplo usando a implementação HashSet que é a mais rapida porem não garante a ordem dos itens armazenados
		//Set<String> set = new TreeSet<>();		// Nesse exemplo usando a implementação TreeSet que é a mais lenta porem ele mantem os dados ordenados
		//Set<String> set = new LinkedHashSet<>();	// Nesse exemplo usando a implementação LinkedHashSet que é de velocidade intermediaria, mantem a ordem em que os elementos foram inseridos
		
		// Adicionando 3 elementos em um objeto SET do tipo string declarado acima
		set.add("Tv");
		set.add("Notebook");
		set.add("Tablet");
		
		System.out.println(set.contains("Notebook"));	// testando se nesse elemento SET existe o item notebook.
		
		//set.remove("Tablet");						// Removendo elemento
		//set.removeIf(x -> x.length() >= 3);		// Removendo elemento conforme predicado informado
		
		for (String p : set) {
			System.out.println(p);
		}
	}
	
	// Demais operações usando SET
	public static void Exemplo2() {
		Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));	// Criando o conjunto A
		Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));	// Criando o conjunto B
		
		//union
		Set<Integer> c = new TreeSet<>(a);								// Criando o conjunto C como copia do conjunto A
		c.addAll(b);													// Fazendo o união do conjunto C com o B. Na pratica adicionando no C o que for de diferente existente no B
		System.out.println(c);
		
		//intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);													// adicionando somente os elementos que tiverem em comun entre o D e B
		System.out.println(d);
		
		//difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);													// Removendo do conjunto E todos elementos que existirem no conjunto B
		System.out.println(e);
	}
	
	// Testando igualdade em coleções hash
	public static void Exemplo3() {
		
		Set<Product> set = new HashSet<>();
		
		set.add(new Product("TV", 900.0));
		set.add(new Product("Notebook", 1200.0));
		set.add(new Product("Tablet", 400.0));
		
		Product prod = new Product("Notebook", 1200.0);
		
		System.out.println(set.contains(prod));	// Retornará falso se a classe Product nao tiver a implementação dos metodos hashcode/equals, com isso irá comparar usando a referencia de ponteiros e não o conteudo do objeto passado.
	}

	// Testando comparações em coleções Treehash
	public static void Exemplo4() {

		Set<Product> set = new TreeSet<>();

		set.add(new Product("TV", 900.0));
		set.add(new Product("Notebook", 1200.0));
		set.add(new Product("Tablet", 400.0));

		for (Product p : set) {
			System.out.println(p);
		}
	}

	// Exercicio resolvido 1 seção 19 - SET
	public static void Exercicio1() {
		//Arquivo in.txt
		//amanda 2018-08-26T20:45:08Z
		//alex86 2018-08-26T21:49:37Z
		//bobbrown 2018-08-27T03:19:13Z
		//amanda 2018-08-27T08:11:00Z
		//jeniffer3 2018-08-27T09:19:24Z
		//alex86 2018-08-27T22:39:52Z
		//amanda 2018-08-28T07:42:19Z
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			// Escolhido o hashSet pois é o mais rapido e conforme a regra do programa, não importa a ordem que os elementos estarão entrando
			Set<LogEntry> set = new HashSet<>();	// Declaração do conjunto SET como HashSet
			
			String line = br.readLine();	// Lendo primeira linha do arquivo
			while (line != null) {
				
				// separo todos dados da linha em uma posição especifica em um array com o split()
				String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				// Adicionando no conjunto SET um objeto do tipo LogEntry que contem o usuario e data de acesso
				set.add(new LogEntry(username, moment));
				
				// Leitura da proxima linha
				line = br.readLine();
			}
			
			System.out.println();
			System.out.println("Total users: " + set.size());	// Impressão da quantidade de elementos usando o metodo size do SET
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
	
	// Exercicio de fixação seção 19 - SET
	public static void Exercicio2() {
		
		Scanner sc = new Scanner(System.in);

		// O instrutor possui 3 cursos (A, B e C) então criaremos 3 conjuntos SETs distintos para cada curso
		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> c = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			a.add(number);		// pega o codigo de cada aluno e armazena no conjunto especifico daquele curso
		}

		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			b.add(number);
		}

		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			c.add(number);
		}

		// Criando um conjunto TOTAL do tipo SET com os elementos do conjunto A 
		Set<Integer> total = new HashSet<>(a);
		total.addAll(b);	// adiciona no conjunto TOTAL os elementos do conjunto B, sem repetição
		total.addAll(c);	// adiciona no conjunto TOTAL os elementos do conjunto C, sem repetição

		System.out.println("Total students: " + total.size());	// Imprime o total de elementos no conjunto

		sc.close();
	}
	
	// DEMO 1 usando MAP
	public static void Exemplo5() {
		
		// Criando o objeto MAP do tipo TreeMap
		Map<String, String> cookies = new TreeMap<>(); // TreeMap ordena pela chave
		
		// Adicionando elementos no map cookie criado especificando (chave, valor)
		cookies.put("username", "maria");
		cookies.put("email", "maria@gmail.com");
		cookies.put("phone", "99771122");
		
		// Removendo o elemento conforme a chave email
		cookies.remove("email");
		
		cookies.put("phone", "99771133");	// Adicionando novamente o elemento de chave phone. Isso faz o Map sobrescrever o mesmo elemento que ja existe no conjunto
		
		System.out.println("Contains 'phone' key: " + cookies.containsKey("phone")); 	// Verificando se no MAP existe um elemento com a chave especificada (phone)
		System.out.println("Phone number: " + cookies.get("phone"));					// imprimindo o valor do elemento de chave especificada (phone), resultado é o valor
		System.out.println("Email: " + cookies.get("email"));							// imprimindo um elemento que não existe conforme a chave passada. Resultado será nulo
		System.out.println("Size: " + cookies.size());									// Imprimindo o quantidade de elementos no MAP
		
		System.out.println("ALL COOKIES:");
		
		for (String key : cookies.keySet()) {	// keySet retorna um SET com as chaves do map
			System.out.println(key + ": " + cookies.get(key));	// Imprime a chave(key) e o conteudo relacionado a essa chave
		}
		
	}

	// DEMO 2 usando MAP
	public static void Exemplo6() {
		
		// Criando o objeto MAP do tipo HASHMAP onde a cahve será um PRODUCT e o valor DOUBLE
		Map<Product, Double> stock = new HashMap<>();
		
		// INSTANCIANDO 3 OBJETOS DO TIPO PRODUTO
		Product p1 = new Product("Tv", 900.0);
		Product p2 = new Product("Notebook", 1200.0);
		Product p3 = new Product("Tablet", 400.0);

		// ADICIONANDO CADA OBJETO PRODUTO NO MAP CRIADO
		stock.put(p1, 10000.0);
		stock.put(p2, 20000.0);
		stock.put(p3, 15000.0);

		//INSTANCIANDO UM NOVO PRODUCT IGUAL O ANTERIOR
		Product ps = new Product("Tv", 900.0);
		
		System.out.println("Contains 'ps' key: " + stock.containsKey(ps));	// IMPRIMINDO SE EXISTE O MAP UM ELEMENTO COM AQUELE PRODUCT (true/false)
	}
	
	// EXERCICIO PROPOSTO - MAP
	public static void Exercicio3() {
		// CONTEUDO DO ARQUIVO in.txt
		//Alex Blue,15
		//Maria Green,22
		//Bob Brown,21
		//Alex Blue,30
		//Bob Brown,15
		//Maria Green,27
		//Maria Green,22
		//Bob Brown,25
		//Alex Blue,31
		
		Scanner sc = new Scanner(System.in);

		// Criando o objeto MAP com a chave sendo STRING e o voto sendo um integer
		Map<String, Integer> votes = new LinkedHashMap<>();

		// Selecionando o arquivo com os dados
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		// Fazendo o tratamento para abertura do arquivo e processamento
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();	// Lendo primeira linha
			while (line != null) {
				
				String[] fields = line.split(",");	// Separando dados em um array
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);

				if (votes.containsKey(name)) {				// Verificando se ja existe aquela chave NAME no objeto MAP
					int votesSoFar = votes.get(name);		// Pegando o valor daquela chave especificada
					votes.put(name, count + votesSoFar);	// Substituindo aquela chave existente pela mesma com o valor incrementado
				}
				else {
					votes.put(name, count);					// No caso de nao encontrar o elemento, adiciona.
				}
				
				line = br.readLine();						// Le proxima linha
			}
			
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));	// Impressão de cada elemento com seus valores
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}