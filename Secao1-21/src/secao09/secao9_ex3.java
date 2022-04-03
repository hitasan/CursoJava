package secao09;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

/*
 * Exemplo de desenvolvimento utilizando o conceito de encapsulamento.
 * 
 * Valores passados para a classe secundaria n�o ser� mais diretamente com atribui��o direta na variavel,
 * passara a inserir e obter os valores atraves dos metodos get/set
 * 
 * */
public class secao9_ex3 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter product data: ");

		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Price: ");
		Double price = sc.nextDouble();
		
		Product product = new Product(name, price);
		
		// usando metodos get / set
		product.setName("Computer");
		System.out.println("Update name: " + product.getName());

		product.setPrice(1200.00);
		System.out.println("Update price: " + product.getPrice());
		
		/*
		System.out.println();
		System.out.println("Product data: " + product);

		System.out.println();
		System.out.print("Enter the number of products to be added in stock: ");
		int quantity = sc.nextInt();

		product.addProducts(quantity);
		
		System.out.println();
		System.out.println("Updated data: " + product);
		
		System.out.println();
		System.out.print("Enter the number of products to be removed from stock: ");
		quantity = sc.nextInt();
		
		product.removeProducts(quantity);

		System.out.println();
		System.out.println("Updated data: " + product);
		*/
		sc.close();
	}
	
}
