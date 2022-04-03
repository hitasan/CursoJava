package secao10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee_Lst;

public class secao10_ex3 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		//====================================================================
		// PARTE 1 - LEITURA DE DADOS E ARMAZENAMENTO EM LISTA
		//====================================================================
		
		// Declarando uma lista de EMPLOYEE usando wrapperclass e instanciando a classe arraylist
		List<Employee_Lst> lst = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.printf("Emplyoee #%d:", i);
			System.out.println();
			
			// Pegando dados de ID
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(lst, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			// Pegando dados de nome
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			// Pegando dados de salario
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			// Adicionando uma nova posição na lista com uma instancia da classe funcionarios
			//Employee_Lst emp = new Employee_Lst(id, name, salary);
			//lst.add(emp);
			lst.add(new Employee_Lst(id, name, salary));
		}
		
		
		//====================================================================
		// PARTE 2 - ATUALIZAÇÂO DO SALARIO DO FUNCIONARIO ESPECIFICADO
		//====================================================================

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();

		Employee_Lst emp = lst.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.IncreaseSalary(percentage);
		}


		//====================================================================
		// PARTE 3 - LISTAGEM DOS FUNCIONARIOS
		//====================================================================
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee_Lst obj : lst) {
			System.out.println(obj);
		}

		sc.close();
	}
	
	public static boolean hasId(List<Employee_Lst> list, int id) {
		Employee_Lst emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
