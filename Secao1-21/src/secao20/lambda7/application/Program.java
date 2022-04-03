package secao20.lambda7.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import secao20.lambda7.entities.Employee;

public class Program {

	public static void main(String[] args) {
//		ARQUIVO in.txt PARA IMPORTAÇÃO COM DADOS
//		Maria,maria@gmail.com,3200.00
//		Alex,alex@gmail.com,1900.00
//		Marco,marco@gmail.com,1700.00
//		Bob,bob@gmail.com,3500.00
//		Anna,anna@gmail.com,2800.00

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Employee> list = new ArrayList<>();	// List para armazenar os funcionarios
			
			String line = br.readLine();	// lendo primeira linha do arquivo
			while (line != null) {
				String[] fields = line.split(",");	// divide os dados da linha conforme separados virgula
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));	// adiciono na lista um objeto funcionario com os parametros nome, email e salario 
				line = br.readLine();	// Leio proxima linha para seguir o laço
			}

			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();	// Solicitando o valor de salario
			
			List<String> emails = list.stream()				// Convertendo o LIST para um STREAM
					.filter(x -> x.getSalary() > salary)	// filtrando esse STREAM para considerar somente os funcionarios que possuirem o salario maior que o valor digitado
					.map(x -> x.getEmail())					// pega o email de cada registro
					.sorted()								// Ordena de modo crescente
					.collect(Collectors.toList());			// Converte o STREAM para LIST

			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
			emails.forEach(System.out::println);	// Imprime o email dos registros qu epossuem salario maior que o que foi informado e foi armazenado no novo list EMAILS apos o paipeline
			
			double sum = list.stream()							// Criando o LIST para STREAM
					.filter(x -> x.getName().charAt(0) == 'M')	// filtrando somente os registros que o nome inicia com a letra M
					.map(x -> x.getSalary())					// Pega o valor do salario
					.reduce(0.0, (x, y) -> x + y);				// Soma tods registros recuperados conforme regras anteriores do pipeline
			
			System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("%.2f", sum));
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
