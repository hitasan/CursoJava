package secao13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import secao13.model.entities.Order;
import secao13.model.entities.Client;
import secao13.model.entities.OrderItem;
import secao13.model.entities.Product;
import secao13.model.enums.OrderStatus;

public class secao13_ex3 {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Recebendo os dados do cliente
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);							// Instancia da classe Client passando os dados que já foram informados
		
		// Recebendo os dados do pedido
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		/*
		Order order = new Order(new Date(), status, client);							// Instancia da classe Order passando os dados que ja foram informados

		// Recebendo a quantidade de itens e dados de cada item
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			Product product = new Product(productName, productPrice);				// Instancia da classe Product passando os dados informados

			OrderItem oIt = new OrderItem(quantity, productPrice, product);	// Instancia da classe OrderItem passando os dados recebidos 

			order.addItem(oIt);												// Adicionando no Order cada OrderItem recebido
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		*/
		sc.close();

	}

}
