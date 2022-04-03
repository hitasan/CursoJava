package gui.util;

import javafx.scene.control.TextField;

// Classe para controlar o comportamento dos elementos de tela
public class Constraints {

	public static void setTextFieldInteger(TextField txt) {
		// Listener é uma função que será executada quando o controle sofrer uma modificação ou interação com o usuario
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
	        if (newValue != null && !newValue.matches("\\d*")) { // verificando se a informação digitada não é nula e e se um numero inteiro
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
