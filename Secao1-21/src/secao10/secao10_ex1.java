package secao10;

import java.util.Locale;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import entities.ProductArr;
import entities.Student;

public class secao10_ex1 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Student[] aQuartos = new Student[10];
		
		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println();
			sc.nextLine(); // Adicionado para normalizar a que a quebra de linha ficou pendente por causa do sc.nextInt acima

			System.out.println("Rent #" + i);
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Email: ");
			String email = sc.nextLine();

			System.out.print("Room [0-9]: ");
			int nRoom = sc.nextInt();

			aQuartos[nRoom] = new Student(name, email);
		}

		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Busy rooms:");
		for (int i = 0; i<10; i++) {
			if (aQuartos[i] != null) {
				System.out.println(i + ": " + aQuartos[i]);
			}
		}
		
		sc.close();

	}

}
