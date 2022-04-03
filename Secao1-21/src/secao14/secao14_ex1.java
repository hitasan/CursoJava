package secao14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao14.entities.Employee;
import secao14.entities.ImportedProduct;
import secao14.entities.OutsourcedEmployee;
import secao14.entities.Product;
import secao14.entities.SavingsAccount;
import secao14.entities.UsedProduct;

// Exercicio de fixação sobre polimorfismo
public class secao14_ex1 {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int nProd = sc.nextInt();
		
		List<Product> lst = new ArrayList<Product>();

		for (int i = 0; i < nProd; i++) {
			Product prod;

			System.out.println("");
			System.out.printf("Product #%d data: ", i+1);
			System.out.println("");

			System.out.print("Common, used or importes (c/u/i)? ");
			char tpProd = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Price: ");
			Double price = sc.nextDouble();

			if (tpProd == 'i') {
				System.out.print("Customs Fee: ");
				Double customFee = sc.nextDouble();

				prod = new ImportedProduct(name, price, customFee);
			}
			else if (tpProd == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				
				prod = new UsedProduct(name, price, manufactureDate);
			}
			else {
				prod = new Product(name, price);
			}

			lst.add(prod);
		}
		
		System.out.println("============================================================================================");
		System.out.println("PRICE TAGS:");
		for (Product prod : lst) {
			System.out.println(prod.priceTag());
		} 
		
		sc.close();

	}

}
