package secao14.entities;

public class Rectangle extends Shape {

	// Atributos da classe
	private Double width;
	private Double height;
	
	
	// Metodos construtores
	public Rectangle() {
		super();
	}

	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	
	// Metodos Getters / Setters
	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	
	// Metodos de processamento
	@Override
	public Double area() {	// Criado metodo para implementar logica ja que metodo da super classe é abstrato
		return width * height;
	}

}
