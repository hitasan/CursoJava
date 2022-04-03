package secao14.entities;

public abstract class Shape {
	
	// Atributod da classe
	private Color color;

	
	// Metodos construtores
	public Shape() {
	}

	public Shape(Color color) {
		this.color = color;
	}
	
	
	// Metodos Getters / Setters
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	// Metodos de processamento
	public abstract Double area(); // Como não é possivel implementar um metodo area sem saber do que, esse metodo declarado acaba sendo abstrato, com isso classe toda deve ser declarada como abstrata.
	
}
