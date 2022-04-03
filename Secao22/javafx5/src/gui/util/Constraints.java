package gui.util;

import javafx.scene.control.TextField;

// Classe para controlar o comportamento dos elementos de tela
public class Constraints {

	public static void setTextFieldInteger(TextField txt) {
		// Listener � uma fun��o que ser� executada quando o controle sofrer uma modifica��o ou intera��o com o usuario
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
	        if (newValue != null && !newValue.matches("\\d*")) { // verificando se a informa��o digitada n�o � nula e e se um numero inteiro
	        	txt.setText(oldValue);
	        }
	    });
	}

	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
	        if (newValue != null && newValue.length() > max) {
	        	txt.setText(oldValue);
	        }
	    });
	}

	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
		    	if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) { // Expressao regular para numeros double
                    txt.setText(oldValue);
                }
		    });
	}
}
