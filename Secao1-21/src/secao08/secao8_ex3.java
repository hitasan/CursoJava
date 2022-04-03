package secao08;

import java.util.Locale;
import java.util.Scanner;

import entities.Aluno;

public class secao8_ex3 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Aluno stud = new Aluno();
		
		stud.name = sc.nextLine();
		stud.nota1 = sc.nextDouble();
		stud.nota2 = sc.nextDouble();
		stud.nota3 = sc.nextDouble();

		System.out.printf("NOTA FINAL: %.2f%n", stud.notaFinal());
		
		if (stud.notaFinal() < 60.0) {
			System.out.println("FAILED");
			System.out.printf("MISSING %.2f POINTS%n", stud.missingPoints());
		}
		else {
			System.out.println("PASS");
		}
		
		sc.close();
	}

}
