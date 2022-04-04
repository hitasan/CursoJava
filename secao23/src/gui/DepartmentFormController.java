package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {

	// Adicionando uma dependencia para o departamento
	private Department entity;
	
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
	
	
	// Metodo set para dependencia do departamento
	public void setDepartment(Department entity) {
		this.entity = entity;	// Com isso o controlador terá uma instancia do departamento
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 50);
	}

	// Responsavel por pegar os dados do departamento da dependencia e popular o formulario
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
}
