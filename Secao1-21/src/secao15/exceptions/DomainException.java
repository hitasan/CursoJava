package secao15.exceptions;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;	// Como a classe é serializable, vc precisa definir a versão da classe desse modo

	// Metodo construtor
	public DomainException(String msg) {	// instancio a classe de exceçao e permito passar uma string por parametro que retornará para a superclasse	
		super(msg);
	}
}