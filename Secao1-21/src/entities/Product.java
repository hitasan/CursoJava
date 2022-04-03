package entities;

public class Product {

	private String name;
	private Double price;
	private int quantity;
	
	
	// ---------------------------------------------------------------------------------------------------
	// CONSTRUTORES
	// ---------------------------------------------------------------------------------------------------
	// Metodo desenvolvido em exemplo de construtores
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	// Metodo desenvolvido em exemplo de sobrecarga ja que possui um contrutor + esse metodo
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	// Sobrecarga com a inclusao do construtor padrão
	public Product() {
		
	}
	
	// ---------------------------------------------------------------------------------------------------
	// METODOS GET / SET
	// ---------------------------------------------------------------------------------------------------
	public String getName() { return this.name; }
	public double getPrice() { return this.price; }
	public int getQuantity() { return this.quantity; }

	public void setName(String name) { this.name = name; }
	public void setPrice(Double price) { this.price = price; }
		
	
	// ---------------------------------------------------------------------------------------------------
	// DEMAIS METODOS DE PROCESSAMENTO
	// ---------------------------------------------------------------------------------------------------
	public Double totalValueInStock() {
		return price * quantity;
	}
	
	public void addProducts(int quantity) {
		this.quantity += quantity;
	}
	
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}
	
	public String toString() {
		return name
			   + ", $ "
			   + String.format("%.2f", price)
			   + ", "
			   + quantity
			   + " units, Total: $ "
			   + String.format("%.2f", totalValueInStock());
	}
}
