package secao20.lambda5.model.entities;

public class Product {

	// ATRIBUTOS DA CLASSE
	private String name;
	private Double price;
	
	// CONSTRUTORES DA CLASSE
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	// METODOS GETTERS/SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}
 
	public void setPrice(Double price) {
		this.price = price;
	}

	// DEMAIS METODOS
	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", price);
	}
}