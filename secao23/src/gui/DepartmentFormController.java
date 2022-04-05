package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	// Adicionando uma dependencia
	private Department entity;			// Para o departamento
	private DepartmentService service;	// Para o serviço de departamento
	
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
	public void onBtSaveAction(ActionEvent event) {
		// Validações para o caso do dev ter esquecido de ter injetado a dependecia do department e departmentService
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

		try {
			// Necessario instanciar um departamento para enviar esse objeto para gravação no banco de dados
			entity = getFormData();	// Responsavel por pegar os dados do formulario e instanciar um departamento
			service.saveOrUpdate(entity);
			
			// Apos processamento no banco precisamos fechar a janela
			Utils.currentStage(event).close();	// Pegando a referencia para a janela atual (Janela do formulario)
			
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private Department getFormData() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();	// Pegando a referencia para a janela atual (Janela do formulario)
	}
	
	
	// Metodo set para dependencia do departamento
	public void setDepartment(Department entity) {
		this.entity = entity;	// Com isso o controlador terá uma instancia do departamento
	}
	// Metodo set para dependencia do ServiceDepartment
	public void setDepartmentService(DepartmentService service) {
		this.service = service;	// Com isso o controlador terá uma instancia do departmentService
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
