package entities;

public class Comment {

	// Atributos da classe
	private String text;

	
	// Metodos Construtores
	public Comment() {
	}

	public Comment(String text) {
		this.text = text;
	}

	
	// Metodos Get / Set
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
