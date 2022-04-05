package model.exceptions;

import java.util.HashMap;
import java.util.Map;

// Exceção personalizada carregando na coleção todos os erros possiveis do formulario
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> errors = new HashMap<>();	// Coleção de pares (chave/valor)
	
	public ValidationException(String msg) {
		super(msg);
	}

	public Map<String, String> getErrors(){
		return errors;
	}
	
	public void addError(String fieldName, String errorMessage) {
		errors.put(fieldName, errorMessage);
	}
}
