package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {

	
	// Declaração dos componentes da tela
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	@FXML
	private Label lblErrorName;
	@FXML
	private Button btSave;
	@FXML
	private Button btCancel;
	
	
	// Funções para tratar a açao dos botoes
	@FXML
	public void onBtSaveAction() {
		System.out.println("Clicou no botao SAVE");
	}
	@FXML
	public void onBtCancelAction() {
		System.out.println("Clicou no botao CANCEL");
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 50);
	}

}
