package secao13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class secao13_ex1 {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	// Crio um sdf com mascara especifica para receber depois a data de cada contrato
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter work data");
		System.out.print("Name: ");
		String workerName = sc.nextLine();

		System.out.print("Level: ");
		String workerLevel = sc.nextLine();

		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		
		// Instanciando um objeto trabalhador passando os argumentos nome, level(obj WorkerLevel recebendo o digitado conforme valueof especificado no enum), o salario base e por fim um obj department que esta recebendo o nome do departamento
		// Poderia fazer a criação dos obj WorkerLevel e Department antes da instanciação Worker sem problema e depois só passar por parametro os obj
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("");
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("");
			System.out.println("Enter contract #" + i + " data: ");
			
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse( sc.next() );

			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			// Instanciação de um objeto contrato passando as informações recebidas por tela
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			// Associação/Adição do obj de contrato criado acima no trabalhador WORKER
			worker.addContract(contract);
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("");
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.printf("Income for %s: %.2f", monthAndYear, worker.income(year, month));
				
		sc.close();
	}

}
