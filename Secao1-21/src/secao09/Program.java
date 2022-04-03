package secao09;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

/*
 * Classe de exemplo do uso de construtores.
 * Construtor � o desenvolvimento do metodo principal de uma classe qualquer. � o metodo de instancia��o NEW(), 
 * por padr�o nao precisa criar esse metodo mas para uso de construtores onde � obrigatorio repassar os parametros (valore pore exemplo)
 * � indicado a cria��o do metodo de mesmo nome da classe com os parametros indicados.
 * 
 * Exemplo: usso da classe Product() onde foi criado o metodo construtor recebendo as informa��es.
 * 
 * */
public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter product data: ");

		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Price: ");
		Double price = sc.nextDouble();
		
		System.out.print("Quantity in stock: ");
		int quantity = sc.nextInt();
		
		Product product = new Product(name, price, quantity);
		
		System.out.println();
		System.out.println("Product data: " + product);

		System.out.println();
		System.out.print("Enter the number of products to be added in stock: ");
		quantity = sc.nextInt();

		product.addProducts(quantity);
		
		System.out.println();
		System.out.println("Updated data: " + product);
		
		System.out.println();
		System.out.print("Enter the number of products to be removed from stock: ");
		quantity = sc.nextInt();
		
		product.removeProducts(quantity);

		System.out.println();
		System.out.println("Updated data: " + product);
		
		sc.close();
	}
}