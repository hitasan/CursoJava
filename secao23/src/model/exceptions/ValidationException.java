package model.exceptions;

import java.util.HashMap;
import java.util.Map;

// Exce??o personalizada carregando na cole??o todos os erros possiveis do formulario
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> errors = new HashMap<>();	// Cole??o de pares (chave/valor)
	
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
