package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
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
import model.exceptions.ValidationException;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	// Adicionando uma dependencia
	private Department entity;			// Para o departamento
	private DepartmentService service;	// Para o serviço de departamento
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
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
			
			notifyDataChangeListeners();
			
			// Apos processamento no banco precisamos fechar a janela
			Utils.currentStage(event).close();	// Pegando a referencia para a janela atual (Janela do formulario)
			
		} catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private Department getFormData() {
		Department obj = new Department();
		
		ValidationException exception = new ValidationException("Validation error");
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		
		// Validando campos
		if (txtName.getText() == null || txtName.getText().trim().equals("")) {	// Verificando se nao tem infromação no campo
			exception.addError("name", "O campo não pode ser vazio!");
		}
		obj.setName(txtName.getText());
		
		// Verificando se existe error adicionados da validação dos campos
		if (exception.getErrors().size() > 0) {
			throw exception;
		}
		
		return obj;
	}
	
	private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
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
	
	//
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
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
	
	private void setErrorMessages( Map<String, String> errors ) {
		Set<String> fields = errors.keySet();
		
		if (fields.contains("name")) {
			lblErrorName.setText(errors.get("name"));
		}
	}
}
