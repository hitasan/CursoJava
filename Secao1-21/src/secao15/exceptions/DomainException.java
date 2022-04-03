package secao15.exceptions;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;	// Como a classe � serializable, vc precisa definir a vers�o da classe desse modo

	// Metodo construtor
	public DomainException(String msg) {	// instancio a classe de exce�ao e permito passar uma string por parametro que retornar� para a superclasse	
		super(msg);
	}
}