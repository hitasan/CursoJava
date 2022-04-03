package secao08;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class secao8_2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Product prod = new Product();
		
		System.out.println("Enter product data.");
		System.out.print("Name: ");
		//prod.name = sc.nextLine();
		
		System.out.print("Price: ");
		//prod.price = sc.nextDouble();
		
		System.out.print("Quantity in stock: ");
		//prod.quantity = sc.nextInt();
		
		System.out.println("----------------------------------------------------------");
		System.out.println("Product data: " + prod); 	// imprimindo o objeto que foi montado a string pelo metodo toString
		System.out.println("");
		
		System.out.print("Enter the number of products to be added in stock: ");
		int qtdd = sc.nextInt();
		prod.addProducts(qtdd); 						// valor de quantidade pegado acima é repassado para metodo de adicionar no estoque
		System.out.println("----------------------------------------------------------");
		System.out.println("Updated data: " + prod);
		System.out.println("");
		
		System.out.print("Enter the number of products to be removed from stock: ");
		qtdd = sc.nextInt();
		prod.removeProducts(qtdd); 						// valor de quantidade pegado acima é repassado para metodo de remover do estoque
		System.out.println("----------------------------------------------------------");
		System.out.println("Updated data: " + prod);
		
		sc.close();
	}

}
