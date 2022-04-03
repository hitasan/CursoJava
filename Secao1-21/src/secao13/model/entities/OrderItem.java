package secao13.model.entities;

// Classe para controle dos itens do pedido
public class OrderItem {

	// Atributos da classe
	private Integer quantity;
	private Double price;
	
	private Product product;	// Composição onde todo item do pedido tem 1 produto

	
	// Metodos Construtores
	public OrderItem() {
	}
	
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	
	// Metodos Get / Set
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	// Metodos Extras
	public double subTotal() {
		return price * quantity;
	}
	
	@Override
	public String toString() {
		return product.getName() 
				+ ", $" + String.format("%.2f", price) 
				+ ", Quantity: " + quantity + 
				", Subtotal: $"  + String.format("%.2f", subTotal());
	}

}
