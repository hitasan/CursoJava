package secao10;

import java.util.Locale;
import java.util.Scanner;

import entities.ProductArr;

public class secao10_2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de produtos: ");
		int nProd = sc.nextInt();
		
		ProductArr[] aProd = new ProductArr[nProd]; 
		
		for (int i = 0; i < aProd.length; i++) {
			sc.nextLine(); // Adicionado para normalizar a que a quebra de linha ficou pendente por causa do sc.nextInt acima
			
			System.out.printf("Informe o nome do %d� produto", i+1);
			String name = sc.nextLine();
			System.out.printf("Informe o pre�o do %d� produto", i+1);
			double price = sc.nextDouble();
			
			aProd[i] = new ProductArr(name, price);	// Em cada posi��o do array estou instanciando a classe de produto para possibilitar tem as informa��es nessa posi��o
		}
		
		double sum = 0.0;
		for (int i = 0; i < aProd.length; i++) {
			sum += aProd[i].getPrice();	// Passando por cada posi��o do array e somando o pre�o do produto obtido atraves do metodo encapsulado(get) do pre�o.
		}
		
		double avg = sum / aProd.length;
		System.out.printf("Average Price = %.2f%n", avg);
		
		sc.close();

	}

}
