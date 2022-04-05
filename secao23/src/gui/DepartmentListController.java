package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable, DataChangeListener {

	// Declaração de dependencia com o service e a instanciação nao será usada para
	// usar o metodo set para injeção de dependencia
	private DepartmentService service;

	// Entidas da classe - Serão associados aos objetos da tela
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, String> tableColumnName;
	@FXML
	private TableColumn<Department, Department> tableColumnEDIT;

	@FXML
	private Button btNew;

	private ObservableList<Department> obsList;

	// Metodo para tratamento de eventos do click do botao NEW
	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Department obj = new Department();
		createDialogForm(obj, "/gui/DepartmentForm.fxml", parentStage);
	}

	// Metodo SET para adicionar o serviço e evitar o acoplamento
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	// Metodo inicializador
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		// Padrao do JavaFX para iniciar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Tratamento para tableView completar a altura da janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}

	// Metodo responsavel por acessar o serviço, carregar os departamentos e jogar
	// os departamentos na observableList e esse será associado a tableView
	public void updateTableView() {
		if (service == null) {
			throw new IllegalThreadStateException("Service está nulo");
		}

		// Listando os departamentos listados
		List<Department> list = service.findAll();

		// Carregando a lista dentro do observableList
		obsList = FXCollections.observableArrayList(list);

		// Associando o observableList no tableViewDepartment
		tableViewDepartment.setItems(obsList);
		
		initEditButtons(); // Adiciona um botao EDIT em cada linha da tabela
	}

	private void createDialogForm(Department obj, String absoluteName, Stage parentStage) {
		try {
			// Logica para abertura da janela de formulario
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			DepartmentFormController controller = loader.getController(); // Pegando o controlador da tela carregada na
																			// linha acima
			controller.setDepartment(obj); // injetando o department no controller
			controller.setDepartmentService(new DepartmentService()); // injetando o departmentService no controller
			controller.subscribeDataChangeListener(this);
			controller.updateFormData(); // Carregando os dados do controller na formulario

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter Department data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL); // Especifica que enquanto nao for fechada nao pode acessar
																// a tela anterior
			dialogStage.showAndWait();

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {
		updateTableView();
	}

	// Responsavel por criar um botão de edição em cada linha da minha tabela
	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(Department obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/DepartmentForm.fxml", Utils.currentStage(event)));
			}
		});
	}

}
