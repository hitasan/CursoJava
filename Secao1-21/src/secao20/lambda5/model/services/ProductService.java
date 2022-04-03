package secao20.lambda5.model.services;

import java.util.List;
import java.util.function.Predicate;

import secao20.lambda5.model.entities.Product;

public class ProductService {

	public double filteredSum(List<Product> list, Predicate<Product> criteria) {
		double sum = 0.0;
		for (Product p : list) {
			if (criteria.test(p)) {		// Executando um test generico de qualquer predicado que chegar por parametro, com isso evitamos de chumbar a regra de validação da condição diretamente nessa função.
				sum += p.getPrice();
			}
		}
		return sum;
	}
}
