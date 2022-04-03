package secao20.lambda5.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import secao20.lambda5.model.entities.Product;
import secao20.lambda5.model.services.ProductService;

public class Program {
	
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		ProductService ps = new ProductService();
		
		// Regra de condição saiu da classe productservice e agora mantem na classe principal passando por parametro, assim evitamos manutenção naquela classe e deixamos mais generica para varias condições que possam ser recebidas
		double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');	
 
		System.out.println("Sum = " + String.format("%.2f", sum));
	}
}
