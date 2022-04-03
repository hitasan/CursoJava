package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	
	// Declara��o de dependencia com o service e a instancia��o nao ser� usada para usar o metodo set para inje��o de dependencia
	private DepartmentService service;

	// Entidas da classe - Ser�o associados aos objetos da tela
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId; 
	@FXML
	private TableColumn<Department, String> tableColumnName;
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	// Metodo para tratamento de eventos do click do botao NEW
	@FXML
	public void onBtNewAction() {
		System.out.println("Clicou no bot�o NEW");
	}
	
	
	// Metodo SET para adicionar o servi�o e evitar o acoplamento
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
	
	
	// Metodo responsavel por acessar o servi�o, carregar os departamentos e jogar os departamentos na observableList e esse ser� associado a tableView
	public void updateTableView() {
		if ( service == null) {
			throw new IllegalThreadStateException("Service est� nulo");
		}
		
		// Listando os departamentos listados
		List<Department> list = service.findAll();
		
		// Carregando a lista dentro do observableList
		obsList = FXCollections.observableArrayList(list);
		
		// Associando o observableList no tableViewDepartment
		tableViewDepartment.setItems(obsList);
	}

}
