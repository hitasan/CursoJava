package aplicacao;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1, "Alex Grey", "alex@gmail.com");
		Pessoa p2 = new Pessoa(2, "Maria Green", "maria@gmail.com");
		Pessoa p3 = new Pessoa(3, "Bob Brown", "bob@gmail.com");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}

}
