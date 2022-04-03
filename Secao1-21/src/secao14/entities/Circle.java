package secao14.entities;

public class Circle extends Shape {

	// Atributos da classe
	private Double radius;
	
	
	// Metodos construtores
	public Circle() {
		super();
	}

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}


	// Metodos Getters / Setters
	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}


	// Metodos de processamento
	@Override
	public Double area() {	// Metodo para implementação de regra ja que super classe tem metodo abstrato
		return Math.PI * radius * radius; 
	}


}
