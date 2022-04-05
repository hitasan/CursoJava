package gui;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Department;
import model.entities.Seller;
import model.exceptions.ValidationException;
import model.services.DepartmentService;
import model.services.SellerService;

public class SellerFormController implements Initializable {

	// Adicionando uma dependencia
	private Seller entity; // Para o departamento
	private SellerService service; // Para o serviço de Seller
	private DepartmentService department; // Para o serviço de Department

	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	// Declaração dos componentes da tela
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtEmail;
	@FXML
	private DatePicker dpBirthDate;
	@FXML
	private TextField txtBaseSalary;
	@FXML
	private ComboBox<Department> cbDepartment;

	@FXML
	private Label lblErrorName;
	@FXML
	private Label lblErrorEmail;
	@FXML
	private Label lblErrorBirthDate;
	@FXML
	private Label lblErrorBaseSalary;

	@FXML
	private Button btSave;
	@FXML
	private Button btCancel;

	private ObservableList<Department> obsList;

	// Funções para tratar a açao dos botoes
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		// Validações para o caso do dev ter esquecido de ter injetado a dependecia do
		// department e departmentService
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

		try {
			// Necessario instanciar um departamento para enviar esse objeto para gravação
			// no banco de dados
			entity = getFormData(); // Responsavel por pegar os dados do formulario e instanciar um departamento
			service.saveOrUpdate(entity);

			notifyDataChangeListeners();

			// Apos processamento no banco precisamos fechar a janela
			Utils.currentStage(event).close(); // Pegando a referencia para a janela atual (Janela do formulario)

		} catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	// Metodo para pegar os dados que foram informados na tela e cria um objeto retornando para o chamador
	private Seller getFormData() {
		Seller obj = new Seller();

		ValidationException exception = new ValidationException("Validation error");

		obj.setId(Utils.tryParseToInt(txtId.getText()));

		// Validando campos
		// Name
		if (txtName.getText() == null || txtName.getText().trim().equals("")) { // Verificando se nao tem infromação no
			// campo
			exception.addError("name", "O campo não pode ser vazio!");
		}
		obj.setName(txtName.getText());

		// Email
		if (txtEmail.getText() == null || txtEmail.getText().trim().equals("")) {
			exception.addError("email", "O campo não pode ser vazio!");
		}
		obj.setEmail(txtEmail.getText());
		
		// Birthdate
		if (dpBirthDate.getValue() == null) {
			exception.addError("birthDate", "O campo não pode ser vazio!");
		}
		else {
			Instant instant = Instant.from(dpBirthDate.getValue().atStartOfDay(ZoneId.systemDefault()));
			obj.setBirthDate(Date.from(instant));
		}
		
		// Salary
		if (txtBaseSalary.getText() == null || txtBaseSalary.getText().trim().equals("")) {
			exception.addError("baseSalary", "O campo não pode ser vazio!");
		}
		obj.setBaseSalary(Utils.tryParseToDouble(txtBaseSalary.getText()));
		
		// Departmento
		obj.setDepartment(cbDepartment.getValue());
		
		
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
		Utils.currentStage(event).close(); // Pegando a referencia para a janela atual (Janela do formulario)
	}

	// Metodo set para dependencia do departamento
	public void setSeller(Seller entity) {
		this.entity = entity; // Com isso o controlador terá uma instancia do departamento
	}

	// Metodo set para dependencia do ServiceSeller
	public void setServices(SellerService slService, DepartmentService dpService) {
		this.service = slService; // Com isso o controlador terá uma instancia do SellerService
		this.department = dpService; // Com isso o controlador terá uma instancia do DepartmentService
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
		Constraints.setTextFieldDouble(txtBaseSalary);
		Constraints.setTextFieldMaxLength(txtEmail, 70);
		Utils.formatDatePicker(dpBirthDate, "dd/MM/yyyy");
		
		initializeComboBoxDepartment();
	}

	// Responsavel por pegar os dados do departamento da dependencia e popular o
	// formulario
	public void updateFormData() {
		Locale.setDefault(Locale.US);

		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
		txtEmail.setText(entity.getEmail());
		txtBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));
		if (entity.getBirthDate() != null) {
			dpBirthDate.setValue(LocalDate.ofInstant(entity.getBirthDate().toInstant(), ZoneId.systemDefault()));
		}
		
		if (entity.getDepartment() == null) {
			cbDepartment.getSelectionModel().selectFirst();// pega o primeiro registro	
		}
		else {
			cbDepartment.setValue(entity.getDepartment());
		}
	}

	private void setErrorMessages(Map<String, String> errors) {
		Set<String> fields = errors.keySet();

		lblErrorName.setText(fields.contains("name") ? errors.get("name") : "");
		lblErrorEmail.setText(fields.contains("email") ? errors.get("email") : "");
		lblErrorBaseSalary.setText(fields.contains("baseSalary") ? errors.get("baseSalary") : "");
		lblErrorBirthDate.setText(fields.contains("birthDate") ? errors.get("birthDate") : "");
	}

	public void loadAssociatedObjects() {
		if (department == null) {
			throw new IllegalStateException("DepartmentService está nulo");
		}

		List<Department> list = department.findAll(); // Carregando o combo com os dado do db pelo departmentservice
		obsList = FXCollections.observableArrayList(list);
		cbDepartment.setItems(obsList);
	}

	private void initializeComboBoxDepartment() {
		Callback<ListView<Department>, ListCell<Department>> factory = lv -> new ListCell<Department>() {
			@Override
			protected void updateItem(Department item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		cbDepartment.setCellFactory(factory);
		cbDepartment.setButtonCell(factory.call(null));
	}

}
