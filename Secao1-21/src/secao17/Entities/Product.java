package secao17.Entities;

public class Product {
	// ATRIBUTOS DA CLASSE
	private String name;
	private Double price;
	private Integer quantity;
	
	// METODOS CONSTRUTORES
	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	// DEMAIS METODOS
	public double total() {
		return price * quantity;
	}
}
