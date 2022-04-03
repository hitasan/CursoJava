import java.util.Locale;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		int nr1, nr2, nr3, nr4;//, result;
		Double n1, n2, n3, result;
		Double Pi = 3.14159;
		String aluno, cod1, cod2;
		
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		
		
		// =======================================================
		// EXERCICIO 01
		// =======================================================
		/*System.out.println("Digite o primeiro numero: ");
		n1 = sc.nextDouble();
		System.out.println("Digite o segundo numero: ");
		n2 = sc.nextDouble();
		
		result = n1 + n2;
		System.out.printf("SOMA = %.0f%n", result);
		*/
		
		
		// =======================================================
		// EXERCICIO 02
		// =======================================================
		/*n1 = 3.14159;

		System.out.println("Digite o raio do circulo: ");
		n2 = sc.nextDouble();
		
		result = n1 * Math.pow(n2, 2.0);
		System.out.printf("Area = %.4f%n", result);
		*/
		

		// =======================================================
		// EXERCICIO 03
		// =======================================================
		/*System.out.println("Digite o primeiro valor: ");
		nr1 = sc.nextInt();
		System.out.println("Digite o segundo valor: ");
		nr2 = sc.nextInt();
		System.out.println("Digite o terceiro valor: ");
		nr3 = sc.nextInt();
		System.out.println("Digite o quarto valor: ");
		nr4 = sc.nextInt();
		
		result = (nr1 * nr2) - (nr3 * nr4);
		System.out.println("Area = " + result);*/
		
		
		// =======================================================
		// EXERCICIO 04
		// =======================================================
		/*System.out.println("Digite o nr. do funcionario: ");
		nr1 = sc.nextInt();
		System.out.println("Digite a qtdd de horas trabalhadas: ");
		nr2 = sc.nextInt();
		System.out.println("Digite o valor por hora de trabalho: ");
		n1 = sc.nextDouble();
		
		result = (int) nr2 * (Double) n1;
		System.out.println("");
		System.out.println("Number : " + nr1);
		System.out.printf("Salary: $%.2f%n", result);*/

		
		// =======================================================
		// EXERCICIO 05
		// =======================================================
		/*System.out.println("Digite o cod. da peça: ");
		cod1 = sc.next();
		System.out.println("Digite a qtdd de peças cod [" + cod1 + "]: ");
		nr1 = sc.nextInt();
		System.out.println("Digite o valor unitário da peça: ");
		n1 = sc.nextDouble();
		
		System.out.println("");
		
		System.out.println("Digite o cod. da peça: ");
		cod2 = sc.next();
		System.out.println("Digite a qtdd de peças cod [" + cod2 + "]: ");
		nr2 = sc.nextInt();
		System.out.println("Digite o valor unitário da peça: ");
		n2 = sc.nextDouble();
		
		
		result = ((int) nr1 * (Double) n1) + ((int) nr2 * (Double) n2);
		System.out.println("");
		System.out.printf("VALOR A PAGAR = $%.2f%n", result);*/
		
		
		// =======================================================
		// EXERCICIO 06
		// =======================================================
		System.out.print("Digite o primeiro valor: ");
		n1 = sc.nextDouble();
		System.out.print("Digite o segundo valor: ");
		n2 = sc.nextDouble();
		System.out.print("Digite o terceiro valor: ");
		n3 = sc.nextDouble();
		
		System.out.println("");
	
		// Area do triangulo retangulo
		result = (n1 * n3) / 2;
		System.out.printf("TRIANGULO = $%.3f%n", result);

		// Area do circulo
		result = Pi * Math.pow(n3, 2.0);
		System.out.printf("CIRCULO = $%.3f%n", result);
		
		// Area do trapezio
		result = ((n1 + n2) * n3) / 2;
		System.out.printf("TRAPEZIO = $%.3f%n", result);

		// Area do quadrado
		result = Math.pow(n2, 2.0);
		System.out.printf("QUADRADO = $%.3f%n", result);

		// Area do retangulo
		result = n1 * n2;
		System.out.printf("QUADRADO = $%.3f%n", result);


		// Encerramento de objeto de leitura de dados
		sc.close();
	}

}
