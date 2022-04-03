package secao14;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao14.entities.Employee;
import secao14.entities.OutsourcedEmployee;

public class secao14_2 {

	public static void main(String[] args) {

		// Exercicio de polimorfismo
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of employees: ");
		int nFunc = sc.nextInt();
		
		List<Employee> lst = new ArrayList<Employee>();
		
		for (int i = 0; i < nFunc; i++) {
			System.out.println("");
			System.out.printf("Employee #%d data: ", i+1);
			System.out.println("");
			
			System.out.print("Outsourced (y/n)? ");
			char terc = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Hours: ");
			int hours = sc.nextInt();

			System.out.print("Value per Hours: ");
			Double valuePerHour = sc.nextDouble();
			
			// Aqui temos o exemplo de polimorfismo, o obj emp nos If e Else são do tipo Employee porem no if ela acaba herdando a classe OutsourceEmployee e no else somente Employee.
			// Cada herança possui comportamentos diferentes que diferenciam cada uma
			if (terc == 'y') {
				System.out.print("Additional Charge: ");
				Double addCharge = sc.nextDouble();
				
				Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, addCharge);
				lst.add(emp);
			}
			else {
				Employee emp = new Employee(name, hours, valuePerHour);
				lst.add(emp);
			}
		}
		
		System.out.println("============================================================================================");
		System.out.println("PAYMENTS:");
		for (Employee emp : lst) {
			System.out.println(emp.getName() + " $ " + String.format("%.2f", emp.payment()));
		} 
		
		sc.close();
		
	}

}
