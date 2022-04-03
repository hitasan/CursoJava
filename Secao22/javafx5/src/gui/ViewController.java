package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable {	// Implements disponibiliza o metodo initialize para ser executado quando o controlador for criado para executar açoes na instanciação do controlador

	@FXML
	private TextField txtNumber1;
	
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label labelResult;
	
	@FXML
	private Button btSum;
	
	@FXML
	public void onBtSumClick() {
		try {
			Locale.setDefault(Locale.US);

			double height = Double.parseDouble(txtNumber1.getText());
			double width = Double.parseDouble(txtNumber2.getText());
			double sum = height + width;

			labelResult.setText(String.format("%.2f", sum));
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// Especificando as limitações para as caixas de texto disponiveis no GUI
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldMaxLength(txtNumber1, 14);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber2, 14);
	}
}
