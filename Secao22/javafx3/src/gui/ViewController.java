package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class ViewController {

	@FXML
	private Button btMyButton;
	
	@FXML
	public void onMyButtonClick() {
		Alerts.showAlert("Alert title", "Alert header", "Hello", AlertType.INFORMATION); // No caso de passar o parametro HEADER como NULL, ser� apresentado um alerta mais simples somente com a mensagem
	}
}
