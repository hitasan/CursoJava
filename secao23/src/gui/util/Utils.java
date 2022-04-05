package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

	public static Stage currentStage(ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
	
	// Metodo para auxilio em conversao de valor da caixa de texto para inteiro
	public static Integer tryParseToInt(String str) {
		try {

			return Integer.parseInt(str);

		} catch (NumberFormatException e) {
			return null;
		}
	}
}
