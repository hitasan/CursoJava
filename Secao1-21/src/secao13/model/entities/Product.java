package secao13.model.entities;

// Classe para controle do produto de cada item do pedido
public class Product {
	
	// Atributos da classe
	private String name;
	private Double price;
	
	// Metodos Construtores
	public Product() {
	}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	// Metodos Get / Set
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
	
}
